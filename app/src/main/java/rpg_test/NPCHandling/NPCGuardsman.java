package rpg_test.NPCHandling;
import rpg_test.GameStateHandling.Color;
import rpg_test.GameStateHandling.PlayerInputHandler;
public class NPCGuardsman extends NPCSuperClass {

    private PlayerInputHandler inputHandler = new PlayerInputHandler();
    private boolean isFriendly = true;

    public NPCGuardsman() {
        super("Guardsman", 250);
    }

    public void NPCDialogue() {

        if (isFriendly) {

            System.out.println(Color.ANSI_GREEN + "Bob the Guardsman:" + Color.ANSI_RESET);
            String guardDialogueFriend;

            do {
                guardDialogueFriend = inputHandler.getTextInput("How can I be of service? \n" +
                        "1. 'How are things?'\n" +
                        "2. 'What can I do here?'\n" +
                        "3. 'Don't talk to me.'");

                if (guardDialogueFriend.equalsIgnoreCase("1")) {
                    System.out.println("So far, nothing too terrible has happened. \n Crime is down these recent years. \n" +
                            "Monsters outside the walls mainly keep to themselves. \n" );
                    NPCDialogue();

                } else if (guardDialogueFriend.equalsIgnoreCase("2")) {
                    System.out.println("You can do lots of things in this little town! \n" +
                            "Firstly, there is the Hotel, which I recommend going to first for excellent food and rest. \n" +
                            "Then theres the arena, which I don't recommend unless you're particularly \n" +
                            "stout of heart and well-armed and armored. People die there every day, though \n" +
                            "the potential reward is great. \n" );
                    NPCDialogue();

                } else if (guardDialogueFriend.equalsIgnoreCase("3")) {
                    isFriendly = false;
                    System.out.println("Watch your tone with me, knave. I'm watching you.");
                    NPCDialogue();
                }

            } while (!guardDialogueFriend.equalsIgnoreCase("1") &&
                    !guardDialogueFriend.equalsIgnoreCase("2") &&
                    !guardDialogueFriend.equalsIgnoreCase("3"));

        } else if (!isFriendly) {

            System.out.println(Color.ANSI_RED + "Bob the Guardsman:" + Color.ANSI_RESET);
            String guardDialogueHostile;

            do {
                guardDialogueHostile = inputHandler.getTextInput("State your business. \n" +
                        "I don't have much time for the likes of you. \n" +
                        "1. 'Nothing to say.'\n" +
                        "2. 'Goodbye.'");
                if(guardDialogueHostile.equalsIgnoreCase("1")) {
                    System.out.println("That's what I thought. Keep moving.");
                    NPCDialogue();
                } else
                if (guardDialogueHostile.equalsIgnoreCase("2")) {
                    System.out.println("Keep walking.");
                    return;
                }
            } while (!guardDialogueHostile.equalsIgnoreCase("1"));
        }

    }

}
