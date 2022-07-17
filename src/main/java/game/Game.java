package game;

import lombok.Getter;
import lombok.Setter;
import models.Hydra;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println("Help " + GameStaticHelpers.getKNIGHT_NAME() + "! We need to slay the hydra!");
        this.buildHydra();
        this.gameLoop();
    }

    private void buildHydra() {
        int heads = GameStaticHelpers.receiveHydraInput("heads");
        int tails = GameStaticHelpers.receiveHydraInput("tails");
        this.setHydra(new Hydra(heads, tails));
    }

    private void gameLoop() {
        while (this.isContinueGame()) {
            GameStaticHelpers.printGameMenu();
            int action = GameStaticHelpers.receiveActionInput();
            this.performAction(action);

            if (action != 5) {
                this.getHydra().printStatus();
                this.checkWinCondition();
                this.checkLoseCondition();
            }
        }
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
                this.solveHydra();
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
            GameStaticHelpers.printWinMessage();
        }
    }

    private void checkLoseCondition() {
        if (this.getHydra().getHeads() == this.getLOSE_PARAMETERS().get("heads")
                && this.getHydra().getTails() == this.getLOSE_PARAMETERS().get("tails")) {
            this.setContinueGame(false);
            GameStaticHelpers.printLossMessage();
        }
    }

    private void solveHydra() {
        if ((this.getHydra().getHeads() % 2 != 0) && (this.getHydra().getTails() == 0)) {
            this.setContinueGame(false);
            GameStaticHelpers.printLossMessage();
        }
        else {
            int count = 0;
            while (this.isContinueGame()) {
                while (this.getHydra().getHeads() > 1) {
                    this.getHydra().removeTwoHeads();
                    this.getHydra().printStatus();
                    ++count;
                }
                if (this.getHydra().getHeads() == 0 && this.getHydra().getTails() == 1) {
                        for (int i = 0; i < 3; i++) {
                            this.getHydra().removeOneTail();
                            this.getHydra().printStatus();
                            ++count;
                    }
                }
                else if (this.getHydra().getHeads() == 0 && this.getHydra().getTails() == 2) {
                        for (int i = 0; i < 2; i++) {
                            this.getHydra().removeOneTail();
                            this.getHydra().printStatus();
                            ++count;
                        }
                }
                else if (this.getHydra().getHeads() == 1 && this.getHydra().getTails() == 1) {
                    this.getHydra().removeOneTail();
                    this.getHydra().printStatus();
                    ++count;
                }
                else if (this.getHydra().getTails() != 0){
                    this.getHydra().removeTwoTails();
                    this.getHydra().printStatus();
                    ++count;
                }
                this.checkLoseCondition();
                this.checkWinCondition();
            }
            System.out.println(GameStaticHelpers.getKNIGHT_NAME() +" defeated hydra in " + count + " actions.");
        }
    }
}
