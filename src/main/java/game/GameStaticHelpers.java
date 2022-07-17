package game;

import lombok.Getter;

import java.util.Scanner;

public class GameStaticHelpers {

    @Getter
    final static String KNIGHT_NAME = "PyPy";

    static void printGameMenu() {
        System.out.println("1. Cut off one head. ");
        System.out.println("2. Cut off one tail. ");
        System.out.println("3. Cut off two heads. ");
        System.out.println("4. Cut off two tails. ");
        System.out.println("5. Solve game with current hydra.");
        System.out.println("6. Quit current game. ");
        System.out.println();
    }

    static void printWinMessage() {
        System.out.println("You killed the hydra, " + GameStaticHelpers.getKNIGHT_NAME()+ "! Thank you!!!");
    }

    static void printLossMessage() {
        System.out.println("Hope is lost, " + GameStaticHelpers.getKNIGHT_NAME()
                + "! The hydra cannot be defeated now");
        System.out.println("------------GAME OVER------------");
        System.out.println("");
    }

    static int receiveHydraInput(String hydraPart) {
        boolean inputValid = false;
        Scanner scanner = new Scanner(System.in);
        String hydraPartCount = "";

        while (!inputValid) {
            System.out.print("How many " + hydraPart + " do you see? ");
            hydraPartCount = scanner.nextLine();
            inputValid = validateHydraInput(hydraPartCount);
        }

        return Integer.parseInt(hydraPartCount);
    }

    private static boolean validateHydraInput(String hydraPartCount) {

        return !checkIfNumeric(hydraPartCount)
                && !checkHydraInputLength(hydraPartCount)
                && !checkHydraValue(Integer.parseInt(hydraPartCount));
    }

    private static boolean checkHydraValue(int hydraPartCount) {
        if (hydraPartCount < 0 ) {
            System.out.println("Input is not at least 0.");
            return true;
        }
        return false;
    }

    private static boolean checkHydraInputLength(String hydraPartCount) {
        if (hydraPartCount.length() < 1) {
            System.out.println("Input cannot be empty.");
            return true;
        }

        return false;
    }

    static int receiveActionInput() {
        Scanner scanner = new Scanner(System.in);
        boolean inputValid = false;
        String userInput = "";

        while (!inputValid) {
            userInput = scanner.nextLine();
            inputValid = validateInputAction(userInput);
        }

        return Integer.parseInt(userInput);
    }

    private static boolean validateInputAction(String input) {
        return !checkIfNumeric(input) && !checkInputLength(input) && !checkActionValues(input);
    }

    private static boolean checkActionValues(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 6) {
            System.out.println("Input is not within menu bounds");
            return true;
        }
        return false;
    }

    private static boolean checkInputLength(String input) {
        if (input.length() < 1) {
            System.out.println("Input is not one character.");
            return true;
        }
        return false;
    }

    private static boolean checkIfNumeric(String input) {
        for (int i = 0; i < input.length(); ++i) {
            if (!Character.isDigit(input.charAt(i))) {
                System.out.println("Input not valid. Cannot have a negative sign or be non-numeric.");
                return true;
            }
        }
        return false;
    }

}
