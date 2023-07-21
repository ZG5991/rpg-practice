package rpg_test.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GridFrame extends JFrame {
    private int frameWidth;
    private int frameHeight;
    private int gridSize;
    private BufferedImage tileImage;

    public GridFrame(int frameWidth, int frameHeight, int gridSize, String imagePath) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.gridSize = gridSize;

        try {
            tileImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Grid Frame");
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        createGrid();
        setVisible(true);
    }

    private void createGrid() {
        JPanel gridPanel = new JPanel(new GridLayout(gridSize, gridSize));

        for (int i = 0; i < gridSize * gridSize; i++) {
            int finalI = i;
            JPanel cellPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int cellWidth = getWidth() / gridSize;
                    int cellHeight = getHeight() / gridSize;
                    int row = finalI / gridSize;
                    int col = finalI % gridSize;
                    BufferedImage subImage = tileImage.getSubimage(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                    g.drawImage(subImage, 0, 0, getWidth(), getHeight(), null);
                }
            };

            cellPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gridPanel.add(cellPanel);
        }

        add(gridPanel);
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
        recreateGrid();
    }

    public void setFrameSize(int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        setSize(frameWidth, frameHeight);
    }

    private void recreateGrid() {
        getContentPane().removeAll();
        createGrid();
        revalidate();
        repaint();
    }
}
