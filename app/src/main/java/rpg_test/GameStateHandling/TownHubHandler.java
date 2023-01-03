package rpg_test.GameStateHandling;

import rpg_test.NPCHandling.NPCGuardsman;
import rpg_test.PlayerCharacterHandling.PlayerCharacterHandler;

public class TownHubHandler {
    private PlayerCharacterHandler characterHandler = new PlayerCharacterHandler();

    public TownHubHandler() {}
    //town locations are to be populated with NPC objects which have specific functions related to their locale

    public void townGate() {
        characterHandler.setLocation("towngate");
        NPCGuardsman guardsman = new NPCGuardsman();
        guardsman.NPCDialogue();
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
