package rpg_test.NPCHandling;

import rpg_test.GameStateHandling.Color;
import rpg_test.GameStateHandling.PlayerInputHandler;
import rpg_test.GameStateHandling.TownHubHandler;
import rpg_test.PlayerCharacterHandling.PlayerCharacterHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NPCPrisonGuard extends NPCSuperClass{

    private PlayerInputHandler inputHandler = new PlayerInputHandler();
    private TownHubHandler townHubHandler = new TownHubHandler();
    private PlayerCharacterHandler playerCharacterHandler = new PlayerCharacterHandler();
    private boolean isFriendly = true;
    private boolean isIntroduced = false;

    public NPCPrisonGuard() {
        super("Prison Guard", 500);
    }

    public void FirstTimeDialogue() {

        TownHubHandler.isNewCharacter = false;

        if (isFriendly) {
            System.out.println(Color.ANSI_GREEN + "Prison Guard Rob:" + Color.ANSI_RESET);
            String firstDialogue;

            do {
                firstDialogue = inputHandler.getTextInput("What are you doing in here? \n" +
                        "I don't recall locking you up at all! \n" +
                        "1. 'I dont know.'\n" +
                        "2. 'Who are you?'\n" );

                if (firstDialogue.equalsIgnoreCase("1")) {
                    System.out.println("Well, that's no good. Normally I'd play it safe but... \n" +
                            "Considering the low crime rate, I'd say you probably just \n" +
                            "got a bit too rowdy at the inn tavern last night. \n" +
                            "Happens to the best of us!");
                    townHubHandler.townSquare();

                } else if (firstDialogue.equalsIgnoreCase("2")) {
                    System.out.println("I'm Rob, the prison guard. My brother Bob is the gate guard. \n" +
                            "Before you ask, yes, we are both named Robert.\n" +
                            "Let's get you out of this cell.\n" +
                            "My instincts tell me you aren't a bad type.");
                    isIntroduced = true;
                    townHubHandler.townSquare();

                }
            } while (!firstDialogue.equalsIgnoreCase("1") &&
                    !firstDialogue.equalsIgnoreCase("2"));

        }
    }

    public void NPCDialogue() {

        if (isFriendly && !isIntroduced) {

            System.out.println(Color.ANSI_GREEN + "Prison Guard Rob:" + Color.ANSI_RESET);
            String dialogueFriendRob;

            do {
                dialogueFriendRob = inputHandler.getTextInput("Hello there! \n" +
                        "What can I help you with?\n" +
                        "1. 'Any gossip?'\n" +
                        "2. 'Who are you?'\n" +
                        "3. 'Goodbye.'");

                        if (dialogueFriendRob.equalsIgnoreCase("1")) {
                            System.out.println(gossipResponsesForPrisonGuard());
                            NPCDialogue();
                         }

                        if (dialogueFriendRob.equalsIgnoreCase("2")) {
                            System.out.println("I'm Rob, the prison guard. My brother Bob is the gate guard. \n" +
                                    "Before you ask, yes, we are both named Robert.");
                            NPCDialogue();
                        }

                if (dialogueFriendRob.equalsIgnoreCase("3")) {
                    System.out.println("Later!");
                    townHubHandler.townSquare();
                }

            } while (!dialogueFriendRob.equalsIgnoreCase("1") &&
                    !dialogueFriendRob.equalsIgnoreCase("2"));

        } else if (isFriendly) {

            System.out.println(Color.ANSI_GREEN + "Prison Guard Rob:" + Color.ANSI_RESET);
            String dialogueFriendRob;

            do {
                dialogueFriendRob = inputHandler.getTextInput("Hello there! \n" +
                        "What can I help you with?\n" +
                        "1. 'Any gossip?'\n" +
                        "2. 'Goodbye.'");

                if (dialogueFriendRob.equalsIgnoreCase("1")) {
                    System.out.println(gossipResponsesForPrisonGuard());
                    NPCDialogue();
                }

                if (dialogueFriendRob.equalsIgnoreCase("2")) {
                    System.out.println("Later!");
                    townHubHandler.townSquare();
                }

            } while (!dialogueFriendRob.equalsIgnoreCase("1") &&
                    !dialogueFriendRob.equalsIgnoreCase("2"));

        }
    }

    private String gossipResponsesForPrisonGuard() {

        Random random = new Random();

        List<String> responses = new ArrayList<>();

        responses.add("One time I had to lock up the mayor for--\n" +
                "Actually, I shouldn't say.");

        responses.add("I caught a fish THIS big once.");

        responses.add("You know Virella the enchantress? She's my ex.");

        responses.add("Huh. You know what- I can't think of anything.");

        return responses.get(random.nextInt(4));
    }

}
