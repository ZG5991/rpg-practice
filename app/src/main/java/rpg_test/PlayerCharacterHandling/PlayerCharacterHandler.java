
package rpg_test.PlayerCharacterHandling;

import rpg_test.GameStateHandling.Color;
import rpg_test.GameStateHandling.PlayerInputHandler;

import java.util.Objects;
import java.util.Random;

public class PlayerCharacterHandler {

  private Random ran = new Random();

  //basic info
  private static String name;
  private static int age;
  private static String race;
  private static String charjob;
  private PlayerInputHandler inputHandler = new PlayerInputHandler();
  //stats
  private static int level;
  private static int health;
  private static int stamina;
  private static int intelligence;
  private static int dexterity;
  private static int strength;

  //simple combat modifiers, affected by combat stats(STR,DEX,INT) + equipped armor/weapons(not yet implemented)
//   public int atk;
//   public int def;

  public PlayerCharacterHandler() {}

  public PlayerCharacterHandler(String name, int age, String race, String job) {
    this.name = name;
    this.age = age;
    this.race = race;
    this.charjob = job;

  }

public String raceQuery() {
  
    String selectRace = inputHandler.getTextInput("What sort of creature are you? (please type a corresponding digit) " +
            "\n 1. Human \n 2. Elf \n 3. Dwarf");

       String race = selectRace;

    if (selectRace.equals("1")) 
    {
      race = "Human";
    } else

    if (selectRace.equals("2")) 
    {
      race = "Elf";
    } else

    if (selectRace.equals("3")) 
    {
      race = "Dwarf";
    }

    return race;

}

public String jobQuery() {

  String selectJob = inputHandler.getTextInput("What is your vocation? (please type a corresponding digit) " +
          "\n 1. Wizard \n 2. Fighter \n 3. Hunter");

    String job = selectJob;

  if (selectJob.equals("1")) 
  {
    job = "Wizard";
    
  } else

  if (selectJob.equals("2")) 
  {
    job = "Fighter";
    
  } else

  if (selectJob.equals("3")) 
  {
    job = "Hunter";
   
  }

  return job;

}

  public void printStats() {
    System.out.println(
            Color.ANSI_PURPLE + "-STATS-\n" +
    name +", "+ race +" "+ charjob  + "\n" +
    age +" yrs old \n" +
    "LV: " + level + "\n" + 
    "HP: " + health + "\n" +
    "STA: " + stamina + "\n" +
    "INT: " + intelligence + "\n" +
    "DEX: " + dexterity + "\n" +
    "STR: " + strength 
    + Color.ANSI_RESET);
      
  }

  public void getRaceTraits() {

    switch (race) {
      case "Human":
        health += 2;
        stamina += 4;
        intelligence += 3;
        dexterity += 3;
        strength += 4;
        break;
      case "Elf":
        health += 3;
        stamina += 2;
        intelligence += 5;
        dexterity += 4;
        strength += 2;
        break;
      case "Dwarf":
        health += 5;
        stamina += 4;
        intelligence += 2;
        dexterity += 2;
        strength += 6;
        break;
    }

  }

  public void jobsModifiers() {

    if (Objects.equals(charjob, "Wizard"))
    {//modifiers
    health += 1;
    stamina += 3;
    intelligence += 7;
    dexterity += 4;
    }

    if (Objects.equals(charjob, "Fighter"))
    {
    health += 6;
    stamina += 5;
    dexterity += 2;
    strength += 4;
    }

    if (Objects.equals(charjob, "Hunter"))
    {
    health += 2;
    stamina += 3;
    intelligence += 2;
    dexterity += 6;
    strength += 4;
    }
    
  }

  public void statsRandomRoller(){

   //randomly initializes stats when called. Use to roll base attributes for new character.
  level =+ 1;
  health =+ ran.nextInt(10); health += 1;
  stamina =+ ran.nextInt(10); stamina += 1;
  intelligence =+ ran.nextInt(10); intelligence += 1;
  dexterity =+ ran.nextInt(10); dexterity += 1;
  strength =+ ran.nextInt(10); strength += 1;

  }


}