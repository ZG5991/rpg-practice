package rpg_test.GameStateHandling;

import rpg_test.PlayerCharacterHandling.PlayerCharacterHandler;

public class PcCommanderDashboard extends PlayerCharacterHandler {

    private PlayerInputHandler inputHandler = new PlayerInputHandler();

    private String playerInput;
    public String console() {

        playerInput = inputHandler.getTextInput(
                "Welcome to the game! For help type "
                        + Color.ANSI_CYAN + "'help'" + Color.ANSI_RESET +
                        ", otherwise type "
                        + Color.ANSI_GREEN + "'start'" + Color.ANSI_RESET +
                        ", or" + Color.ANSI_GREEN + "'load game' " + Color.ANSI_RESET +
                        " to begin your journey.");

        if (playerInput.equals("help")) {
           return helpOpt();
        }

        return playerInput;

    }

    public String helpOpt() {
        playerInput = inputHandler.getTextInput("Type the following to perform action " +
                "\n 'stats' to show stats \n 'save' to save (non functional)");
        if (playerInput.equals("stats")) {
            printStats();
        }

        return playerInput;

    }

    @Override
    public void printStats() {
        super.printStats();
    }

}



