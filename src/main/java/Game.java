import lombok.Getter;
import lombok.Setter;
import models.Hydra;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter
@Setter
public class Game {
    private final Map<String, Integer> WIN_PARAMETERS = new HashMap<String, Integer>() {{
        put("heads", 0);
        put("tails", 0);
    }};

    private final Map<String, Integer> LOSE_PARAMETERS = new HashMap<String, Integer>() {{
        put("heads", 1);
        put("tails", 0);
    }};

    private boolean continueGame = true;
    private Hydra hydra;

    public void startGame() {
        // FIXME: 7/16/2022: add user input validation for hydra set up
        Scanner scanner = new Scanner(System.in);

        System.out.println("heads: ");
        int heads = Integer.parseInt(scanner.nextLine());

        System.out.println("tails: ");
        int tails = Integer.parseInt(scanner.nextLine());

        this.setHydra(new Hydra(heads, tails));
        this.gameLoop();
    }

    private void gameLoop() {
        while (this.isContinueGame()) {
            this.printGameMenu();
            int action = receiveActionInput();
            this.performAction(action);
            this.getHydra().printStatus();
            this.checkWinCondition();
            this.checkLoseCondition();
        }
    }

    private void printGameMenu() {
        System.out.println("1. Cut off one head. ");
        System.out.println("2. Cut off one tail. ");
        System.out.println("3. Cut off two heads. ");
        System.out.println("4. Cut off two tails. ");
        System.out.println("5. Solve game with current hydra.");
        System.out.println("6. Quit current game. ");
        System.out.println();
    }

    private int receiveActionInput() {
        Scanner scanner = new Scanner(System.in);
        boolean inputValid = false;
        String userInput = "";

        while (!inputValid) {
            userInput = scanner.nextLine();
            inputValid = validateInputAction(userInput);
        }

        return Integer.parseInt(userInput);
    }

    private boolean validateInputAction(String input) {
        return !checkIfNumeric(input) && !checkInputLength(input) && !checkActionValues(input);
    }

    private boolean checkActionValues(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 6) {
            System.out.println("Input is not within menu bounds");
            return true;
        }
        return false;
    }

    private boolean checkInputLength(String input) {
        if (input.length() < 1) {
            System.out.println("Input is not one character.");
            return true;
        }
        return false;
    }

    private boolean checkIfNumeric(String input) {
        for (int i = 0; i < input.length(); ++i) {
            if (!Character.isDigit(input.charAt(i))) {
                System.out.println("Input not numeric.");
                return true;
            }
        }
        return false;
    }

    private void performAction(int action) {
        switch (action) {
            case 1:
                this.getHydra().removeOneHead();
                break;
            case 2:
                this.getHydra().removeOneTail();
                break;
            case 3:
                this.getHydra().removeTwoHeads();
                break;
            case 4:
                this.getHydra().removeTwoTails();
                break;
            case 5:
                // FIXME: 7/16/2022 add solving algorithm
                break;
            case 6:
                this.setContinueGame(false);
                break;
        }
    }

    private void checkWinCondition() {
        if (this.getHydra().getHeads() == this.getWIN_PARAMETERS().get("heads")
                && this.getHydra().getTails() == this.getWIN_PARAMETERS().get("tails")) {
            this.setContinueGame(false);
            System.out.println("Game won! Congratulations.");
        }
    }

    private void checkLoseCondition() {
        if (this.getHydra().getHeads() == this.getLOSE_PARAMETERS().get("heads")
                && this.getHydra().getTails() == this.getLOSE_PARAMETERS().get("tails")) {
            this.setContinueGame(false);
            System.out.println("Game lost due to scenario where you cannot win.");
        }
    }

}
