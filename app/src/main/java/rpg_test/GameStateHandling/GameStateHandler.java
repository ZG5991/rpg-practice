package rpg_test.GameStateHandling;

import rpg_test.PlayerCharacterHandling.PlayerCharacterHandler;


public class GameStateHandler {
    public boolean characterHasBeenCreated = false;
    private PlayerInputHandler inputHandler = new PlayerInputHandler();
    private PlayerCharacterHandler characterHandler = new PlayerCharacterHandler();

    public void mainMenu() {
        //TODO implement mainMenu method
    }

    public void pcCharaCreate() {

        String name = characterHandler.setName();
        String race = characterHandler.setRace();
        String job = characterHandler.setJob();

        characterHandler.statsRandomRoller();
        characterHandler.setJobModifiers();
        characterHandler.setRaceTraits();

        System.out.printf("So it is written, you will be called "
                + Color.ANSI_PURPLE + "%s the %s, a fine %s!%n" + Color.ANSI_RESET, name, race, job);

        System.out.println(characterHandler.statsManager());

        characterHasBeenCreated = true;

    }

    public void console() {
        String console;
        do {
            console = inputHandler.getTextInput(
                    "For menu type "
                            + Color.ANSI_CYAN + "'menu'" + Color.ANSI_RESET +
                            ", otherwise type "
                            + Color.ANSI_GREEN + "'start'" + Color.ANSI_RESET +
                            ", or" + Color.ANSI_GREEN + " 'load game' " + Color.ANSI_RESET +
                            " to begin your journey.");

            if (console.equalsIgnoreCase("menu")) {
                helper();
            }
            if (console.equalsIgnoreCase("start")) {
                System.out.println("Feature not implemented.");
                console();
            }
            if (console.equalsIgnoreCase("load")) {
                System.out.println("Feature not implemented.");
                console();
            }

        } while (!console.equalsIgnoreCase("menu") &&
                !console.equalsIgnoreCase("start") &&
                !console.equalsIgnoreCase("load game"));
    }

    public void helper() {
        String helper;
        do {
            helper = inputHandler.getTextInput("Type the following to perform action " +
                    "\n 'stats' to show stats \n 'save' to save (non functional)");

            if (helper.equalsIgnoreCase("stats")) { System.out.println(characterHandler.statsManager()); console(); } else
            if (helper.equalsIgnoreCase("save")) {System.out.println("Feature not implemented."); helper(); }

        } while (!helper.equalsIgnoreCase("stats"));

    }

}
