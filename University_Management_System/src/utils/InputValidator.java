package utils;

import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) return value;
                System.out.println("Error: The value must be between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please input a valid integer value");
            }
        }
    }

    public static double readPositiveDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) return value;
                System.out.println("Error: This input must be grater than 0");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please input a valid decimal value");
            }
        }
    }

    public static String readNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Error: This input can't be empty");
        }
    }
}