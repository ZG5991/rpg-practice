package rpg_test;

import java.util.Scanner;

public class uiPrinter {

    public static void pc_chara_create() {

        String name = uiInit.getTextInput("Greetings Traveler, what is your name? \n (please type name below)");
      
        int age = uiInit.getIntInput("How old are you?");

        String race = playerInit.raceQuery();

        String job = playerInit.jobQuery();

        playerInit player =  new playerInit(name, age, race, job);
        player.statsRandomRoller();
        player.jobsModifiers();
        player.getRaceTraits();

        System.out.println(String.format("So it is written, you will be called %s the %s, aged %s years, a fine %s!", name, race, age, job));

        playerInit.printStats();

    }

    public static void pc_Commands() {

      while (true){
      System.out.println("Welcome to the game! For help type 'help', otherwise type 'start' to begin your journey.");
      
       if (uiInit.scanner.next("help") != null) {

          String helpopt = uiInit.getTextInput("Type the following to perform action \n 'stats' to show stats \n 'save' to save (non functional)");

          if (helpopt.equals("stats")) 
          {
            playerInit.printStats();
          }

        }

       }
      
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
        race = "Human";
      } else

      if (selectRace.equals("3")) 
      {
        race = "Human";
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


  }

final class uiInit {

 static Scanner scanner = new Scanner(System.in);

    public static String getTextInput(String prompt) {

        System.out.println(prompt);
    
        String input = scanner.next();
    
        return input;
    
      }

      public static int getIntInput(String prompt) {

        System.out.println(prompt);
    
        int input = scanner.nextInt();
    
        return input;
    
      }

}
