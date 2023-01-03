
package rpg_test.PlayerCharacterHandling;

import rpg_test.GameStateHandling.Color;
import rpg_test.GameStateHandling.PlayerInputHandler;

import java.util.Objects;
import java.util.Random;

public class PlayerCharacterHandler{

  private Random random = new Random();
  private final PlayerInputHandler inputHandler = new PlayerInputHandler();

  public String statsManager() {

    return
            Color.ANSI_PURPLE + "-STATS-\n" +
            GlobalPlayerVariables.name +", "+ GlobalPlayerVariables.race +" "+ GlobalPlayerVariables.job + "\n" +
    "LV: " + GlobalPlayerVariables.level + "\n" +
    "HP: " + GlobalPlayerVariables.health + "\n" +
    "STA: " + GlobalPlayerVariables.stamina + "\n" +
    "INT: " + GlobalPlayerVariables.intelligence + "\n" +
    "DEX: " + GlobalPlayerVariables.dexterity + "\n" +
    "STR: " + GlobalPlayerVariables.strength
    + Color.ANSI_RESET;

  }

  public String setName() {
    String setName = inputHandler.getTextInput("Greetings Traveler, what is your name? \n (please type name below)");
    return GlobalPlayerVariables.name = setName;
  }

  public String setRace() {
    String selectRace;
    String race;
    do {
      selectRace = inputHandler.getTextInput("What sort of creature are you? " +
              "\n 1. Human \n 2. Elf \n 3. Dwarf");

      race = selectRace;

      if (selectRace.equalsIgnoreCase("human") || selectRace.equalsIgnoreCase("1")) {
        race = "Human";
      } else if (selectRace.equalsIgnoreCase("elf") || selectRace.equalsIgnoreCase("2")) {
        race = "Elf";
      } else if (selectRace.equalsIgnoreCase("dwarf") || selectRace.equalsIgnoreCase("3")) {
        race = "Dwarf";
      }
    } while (!selectRace.equalsIgnoreCase("human") && !selectRace.equalsIgnoreCase("1") &&
            !selectRace.equalsIgnoreCase("elf") && !selectRace.equalsIgnoreCase("2") &&
            !selectRace.equalsIgnoreCase("dwarf") && !selectRace.equalsIgnoreCase("3"));

    return GlobalPlayerVariables.race = race;
  }

  public String setJob() {
    String selectJob;
    String job;
    do {
      selectJob = inputHandler.getTextInput("What is your vocation? " +
              "\n 1. Wizard \n 2. Fighter \n 3. Hunter");

      job = selectJob;

      if (selectJob.equalsIgnoreCase("wizard") || selectJob.equalsIgnoreCase("1")) {
        job = "Wizard";
      } else if (selectJob.equalsIgnoreCase("fighter") || selectJob.equalsIgnoreCase("2")) {
        job = "Fighter";
      } else if (selectJob.equalsIgnoreCase("hunter") || selectJob.equalsIgnoreCase("3")) {
        job = "Hunter";
      }
    } while (!selectJob.equalsIgnoreCase("wizard") && !selectJob.equalsIgnoreCase("1") &&
            !selectJob.equalsIgnoreCase("fighter") && !selectJob.equalsIgnoreCase("2") &&
            !selectJob.equalsIgnoreCase("hunter") && !selectJob.equalsIgnoreCase("3"));

    return GlobalPlayerVariables.job = job;
  }

  public void setRaceTraits() {

    switch (GlobalPlayerVariables.race) {
      case "Human":
        GlobalPlayerVariables.health += 2;
        GlobalPlayerVariables.stamina += 4;
        GlobalPlayerVariables.intelligence += 3;
        GlobalPlayerVariables.dexterity += 3;
        GlobalPlayerVariables.strength += 4;
        break;
      case "Elf":
        GlobalPlayerVariables.health += 3;
        GlobalPlayerVariables.stamina += 2;
        GlobalPlayerVariables.intelligence += 5;
        GlobalPlayerVariables.dexterity += 4;
        GlobalPlayerVariables.strength += 2;
        break;
      case "Dwarf":
        GlobalPlayerVariables.health += 5;
        GlobalPlayerVariables.stamina += 4;
        GlobalPlayerVariables.intelligence += 2;
        GlobalPlayerVariables.dexterity += 2;
        GlobalPlayerVariables.strength += 6;
        break;
    }

  }

  public void setJobModifiers() {

    if (Objects.equals(GlobalPlayerVariables.job, "Wizard"))
    {//modifiers
    GlobalPlayerVariables.health += 1;
    GlobalPlayerVariables.stamina += 3;
    GlobalPlayerVariables.intelligence += 7;
    GlobalPlayerVariables.dexterity += 4;
    }

    if (Objects.equals(GlobalPlayerVariables.job, "Fighter"))
    {
    GlobalPlayerVariables.health += 6;
    GlobalPlayerVariables.stamina += 5;
    GlobalPlayerVariables.dexterity += 2;
    GlobalPlayerVariables.strength += 4;
    }


    if (Objects.equals(GlobalPlayerVariables.job, "Hunter"))
    {
    GlobalPlayerVariables.health += 2;
    GlobalPlayerVariables.stamina += 3;
    GlobalPlayerVariables.intelligence += 2;
    GlobalPlayerVariables.dexterity += 6;
    GlobalPlayerVariables.strength += 4;
    }
    
  }

  public void setLocation(String location) { GlobalPlayerVariables.location = location; }

  public void statsRandomRoller(){
   //randomly initializes stats when called. Use to roll base attributes for new character.
  GlobalPlayerVariables.level =+ 1;
  GlobalPlayerVariables.health =+ random.nextInt(10); GlobalPlayerVariables.health += 1;
  GlobalPlayerVariables.stamina =+ random.nextInt(10); GlobalPlayerVariables.stamina += 1;
  GlobalPlayerVariables.intelligence =+ random.nextInt(10); GlobalPlayerVariables.intelligence += 1;
  GlobalPlayerVariables.dexterity =+ random.nextInt(10); GlobalPlayerVariables.dexterity += 1;
  GlobalPlayerVariables.strength =+ random.nextInt(10); GlobalPlayerVariables.strength += 1;
  }

}

class GlobalPlayerVariables {
  public static String name;
  public static String race;
  public static String job;

  public static String location;
  public static int level;
  public static int health;
  public static int stamina;
  public static int intelligence;
  public static int dexterity;
  public static int strength;

}