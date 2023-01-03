package rpg_test.GameStateHandling;

import rpg_test.PlayerCharacterHandling.PlayerCharacterHandler;


public class GameStateHandler {
    public boolean characterHasBeenCreated = false;
    private PlayerInputHandler inputHandler = new PlayerInputHandler();
    private PlayerCharacterHandler characterHandler = new PlayerCharacterHandler();
    private TownHubHandler townHubHandler = new TownHubHandler();

    public void mainMenu() {
        String console;
        do {
            console = inputHandler.getTextInput(
                    "Welcome to the RPG! \n For player menu type "
                            + Color.ANSI_CYAN + "'menu'" + Color.ANSI_RESET +
                            " at any time in game, otherwise type "
                            + Color.ANSI_GREEN + "'start'" + Color.ANSI_RESET +
                            ", or" + Color.ANSI_GREEN + " 'load game' " + Color.ANSI_RESET +
                            " to begin your journey. If you want to quit type " +
                           Color.ANSI_RED + "'quit'." + Color.ANSI_RESET);

            if (console.equalsIgnoreCase("menu")) {
                playerMenu();
            }
            if (console.equalsIgnoreCase("start") && !characterHasBeenCreated) {
                pcCharaCreate();
            } else
                if (console.equalsIgnoreCase("start") && characterHasBeenCreated) {
                    townHubHandler.townGate();
            }
            if (console.equalsIgnoreCase("load")) {
                System.out.println("Feature not implemented.");
                mainMenu();
            }
            if (console.equalsIgnoreCase("quit")) {
                return;
            }

        } while (!console.equalsIgnoreCase("menu") &&
                !console.equalsIgnoreCase("start") &&
                !console.equalsIgnoreCase("load") &&
                !console.equalsIgnoreCase("quit"));

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

        townHubHandler.townGate();

    }


    public void playerMenu() {
        String helper;
        do {
            helper = inputHandler.getTextInput("Type the following to perform action " +
                    "\n 'stats' to show stats \n 'save' to save (non functional) \n 'exit' to quit game, or \n 'main' to return to the main screen.");

            if (helper.equalsIgnoreCase("stats") && characterHasBeenCreated) {
                System.out.println(characterHandler.statsManager()); playerMenu();
            } else
                if (helper.equalsIgnoreCase("stats") && !characterHasBeenCreated) {
                    System.out.println("You must create a character first. \n From the main menu type 'start'.");
                    mainMenu();
                }
            if (helper.equalsIgnoreCase("save")) {System.out.println("Feature not implemented."); playerMenu(); }
            if (helper.equalsIgnoreCase("exit")) { return; }
            if (helper.equalsIgnoreCase("main")) { mainMenu(); }

        } while (!helper.equalsIgnoreCase("stats") &&
                !helper.equalsIgnoreCase("save") &&
                !helper.equalsIgnoreCase("exit") &&
                !helper.equalsIgnoreCase("main"));

    }

}
