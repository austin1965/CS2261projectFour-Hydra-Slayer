import game.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean playingGame = true;
        Scanner scanner = new Scanner(System.in);

        while (playingGame) {
            System.out.println("Starting hydra slaying game.");
            Game game = new Game();
            game.startGame();
            System.out.print("Press Q to quit. Press anything else to play again: ");
            String userInput = scanner.nextLine();

            if (userInput.equals("Q") || userInput.equals("q")) {
                playingGame = false;
            }

        }
        System.out.println("\nEnding hydra slaying game. ");
    }
}
