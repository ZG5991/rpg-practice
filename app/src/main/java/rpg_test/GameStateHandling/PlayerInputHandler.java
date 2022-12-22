package rpg_test.GameStateHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerInputHandler {

    private String prompt;
    static Scanner scanner = new Scanner(System.in);

    public String getTextInput(String prompt) {

        this.prompt = prompt;

        while (true) {
            System.out.println(prompt);
            try {
                return scanner.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Input requires valid characters.");
                scanner.nextLine(); // clear the invalid input from the scanner
            }
        }
    }

    public int getIntInput(String prompt) {

        this.prompt = prompt;

        while (true) {
            System.out.println(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Input requires valid numbers.");
                scanner.nextLine();
            }
        }
    }

    public boolean hasValidResponse() {
        return !getTextInput(prompt).isEmpty();
    }

}
