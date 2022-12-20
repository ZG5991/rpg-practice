package rpg_test.GameStateHandling;

import rpg_test.PlayerCharacterHandling.PlayerCharacterHandler;

import java.util.InputMismatchException;


public class GameStateHandler {

    private PlayerInputHandler playerInput = new PlayerInputHandler();
    private PlayerCharacterHandler playerCharacter =  new PlayerCharacterHandler();

    public void pc_chara_create() {

        String name = playerInput.getTextInput("Greetings Traveler, what is your name? \n (please type name below)");
      
        int age = playerInput.getIntInput("How old are you?");

        String race = playerCharacter.raceQuery();

        String job = playerCharacter.jobQuery();

        //initializes a NEW playerCharacter object which stats are applied through
        playerCharacter = new PlayerCharacterHandler(name, age, race, job);

        playerCharacter.statsRandomRoller();
        playerCharacter.jobsModifiers();
        playerCharacter.getRaceTraits();

        System.out.printf("So it is written, you will be called "
                +Color.ANSI_YELLOW+"%s"+Color.ANSI_RESET+
                " the %s, aged %s years, a fine %s!%n", name, race, age, job);

        playerCharacter.printStats();

    }

  }

