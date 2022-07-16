import models.Hydra;

import java.util.HashMap;
import java.util.Map;

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
        // FIXME: 7/16/2022: add user input for hydra set up
        this.hydra = new Hydra(0, 0);
        this.gameLoop();
    }


    private void gameLoop() {
        while (continueGame) {
            this.printGameMenu();
            int action = receiveActionInput();
            this.performAction(action);
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
    }

    private int receiveActionInput() {
        //FIXME: 7/16/2022: add user input for menu
        System.out.println("FIXME");
        return 1;
    }
    private void performAction(int decisionValue) {
        //FIXME: 7/16/2022: add decisioning for user input
        System.out.println("FIXME");
    }
    private void checkWinCondition() {
        if (this.hydra.getHeads() == this.WIN_PARAMETERS.get("heads")
                && this.hydra.getTails() == this.WIN_PARAMETERS.get("tails")) {
            this.continueGame = false;
            System.out.println("Game won! Congratulations.");
        }
    }

    private void checkLoseCondition() {
        if (this.hydra.getHeads() == this.LOSE_PARAMETERS.get("heads")
                && this.hydra.getTails() == this.LOSE_PARAMETERS.get("tails")) {
            this.continueGame = false;
            System.out.println("Game lost due to scenario where you cannot win.");
        }
    }

}
