package rpg_test.GameStateHandling;

import java.util.Scanner;

public class PlayerInputHandler {

    static Scanner scanner = new Scanner(System.in);

    public String getTextInput(String prompt) {

        System.out.println(prompt);
        return scanner.next();

    }

    public int getIntInput(String prompt) {

        System.out.println(prompt);
        return scanner.nextInt();

    }

}
