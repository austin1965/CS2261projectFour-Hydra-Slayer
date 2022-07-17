package game;

import java.util.Scanner;

public class GameStaticHelpers {

    static int receiveHydraInput(String hydraPart) {
        boolean inputValid = false;
        Scanner scanner = new Scanner(System.in);
        String hydraPartCount = "";

        while (!inputValid) {
            System.out.print("Please input the number of " + hydraPart + ": ");
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
