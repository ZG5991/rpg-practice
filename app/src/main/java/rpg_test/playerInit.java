
package rpg_test;

import java.util.Random;

public class playerInit {

  public static Random ran = new Random();

  //basic info
  private static String name;
  private static int age;
  private static String race;
  private static String charJob;

  //stats
  public static int level;
  public static int health;
  public static int stamina;
  public static int intelligence;
  public static int dexterity;
  public static int strength;

  //simple combat modifiers, affected by combat stats(STR,DEX,INT) + equipped armor/weapons(not yet implemented)
//   public int atk;
//   public int def;

  public playerInit(String name, int age, String race, String job) {

    playerInit.name = name;
    playerInit.age = age;
    playerInit.race = race;
    playerInit.charJob = job;

  }

public static String raceQuery() {
  
    String selectRace = uiInit.getTextInput("What sort of creature are you? (please type a corresponding digit) \n 1. Human \n 2. Elf \n 3. Dwarf"); 

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

public static String jobQuery() {

  String selectJob = uiInit.getTextInput("What is your vocation? (please type a corresponding digit) \n 1. Wizard \n 2. Fighter \n 3. Hunter"); 

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

  public static void printStats() {
    System.out.println(
      "-STATS-\n" +  
    name +", "+ race +" "+ charJob  + "\n" +
    age +" yrs old \n" +
    "LV: " + level + "\n" + 
    "HP: " + health + "\n" +
    "STA: " + stamina + "\n" +
    "INT: " + intelligence + "\n" +
    "DEX: " + dexterity + "\n" +
    "STR: " + strength 
    );
      
  }

  public void getRaceTraits() {

    if (race.equals("Human")) 
    {
      health += 2;
      stamina += 4;
      intelligence += 3;
      dexterity += 3;
      strength += 4;
    } else

    if (race.equals("Elf")) 
    {
      health += 3;
      stamina += 2;
      intelligence += 5;
      dexterity += 4;
      strength += 2;
    } else

    if (race.equals("Dwarf")) 
    {
      health += 5;
      stamina += 4;
      intelligence += 2;
      dexterity += 2;
      strength += 6;
    }

  }

  public void jobsModifiers() {

    if (charJob == "Wizard")
    {//modifiers
    health += 1;
    stamina += 3;
    intelligence += 7;
    dexterity += 4;
    strength += 0;
    }

    if (charJob == "Fighter") 
    {
    health += 6;
    stamina += 5;
    intelligence += 0;
    dexterity += 2;
    strength += 4;
    }

    if (charJob == "Hunter") 
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