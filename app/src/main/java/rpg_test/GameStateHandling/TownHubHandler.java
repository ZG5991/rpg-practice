package rpg_test.GameStateHandling;

import rpg_test.NPCHandling.NPCGuardsman;
import rpg_test.NPCHandling.NPCPrisonGuard;
import rpg_test.PlayerCharacterHandling.PlayerCharacterHandler;

public class TownHubHandler {
    private PlayerCharacterHandler characterHandler = new PlayerCharacterHandler();
    private PlayerInputHandler inputHandler = new PlayerInputHandler();
    public static boolean isNewCharacter = true;
    public TownHubHandler() {}
    //town locations are to be populated with NPC objects which have specific functions related to their locale

    public void townSquare() {
        characterHandler.setLocation("town_square");

        String squareMenu = inputHandler.getTextInput("From here you can get anywhere in town, just type where you want to go.\n" +
                "1. Town Gate\n" +
                "2. Jail\n");

        if (squareMenu.equalsIgnoreCase("1")) {
            townGate();
        } else if (squareMenu.equalsIgnoreCase("2")) {
            townJail();
        }
    }

    public void townGate() {
        characterHandler.setLocation("town_gate");
        NPCGuardsman guardsman = new NPCGuardsman();
        guardsman.NPCDialogue();
         }

    public void townJail() {
        characterHandler.setLocation("jail");
        NPCPrisonGuard prisonGuard = new NPCPrisonGuard();

        if (isNewCharacter) {
            prisonGuard.FirstTimeDialogue();
        } else
            prisonGuard.NPCDialogue();
    }

    public void hotel() {
        characterHandler.setLocation("hotel");
        //TODO implement "Innkeep" NPC
        //TODO implement "Bartender" NPC
    }

    public void arena() {
        characterHandler.setLocation("arena");
        //TODO implement "Announcer" NPC
        //TODO impelemnt enemies to kill
    }

}
