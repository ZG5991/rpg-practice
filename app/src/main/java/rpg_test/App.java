/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rpg_test;

import rpg_test.GameStateHandling.GameStateHandler;

public class App {

    public static void main(String[] args) {

        new App().runUI();

    }

    private void runUI() {
        new GameStateHandler().mainMenu();
    }

}
