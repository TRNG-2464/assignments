package com.revature.ccvi;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.SequencedCollection;

public class PasswordStrengthChecker {

    // Helper Record to store the independent rules without heavy boilerplate
    record RuleEvaluation(boolean hasLength, boolean hasDigit, boolean hasUpper, boolean hasSpecial) {
        
        int countPassed() {
            int count = 0;
            if (hasLength) count++;
            if (hasDigit) count++;
            if (hasUpper) count++;
            if (hasSpecial) count++;
            return count;
        }

        int getWeightedPoints() {
            int points = 0;
            if (hasLength) points += 1;
            if (hasDigit) points += 1;
            if (hasUpper) points += 1;
            if (hasSpecial) points += 2; // Special character is worth 2 points
            return points;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Would you like to run the Stretch Goals? (y/n): ");
            boolean runStretch = scanner.nextLine().trim().equalsIgnoreCase("y");
            
            System.out.println("Type 'EXIT' at any prompt to quit the application.");

            while (true) {
                System.out.print("\nEnter password: ");
                String input = scanner.nextLine();
                
                // Exit condition
                if ("EXIT".equalsIgnoreCase(input)) {
                    System.out.println("Exiting the Password Strength Checker. Goodbye!");
                    break;
                }

                // Simulating a null pass for testing purposes if the user literally types "null"
                if ("null".equals(input)) {
                    input = null;
                }

                // Format the input
                String displayInput = (input == null) ? "" : input;
                System.out.println("Input: \"" + displayInput + "\"");

                // Evaluate based on user's choice regarding Stretch Goals
                if (runStretch) {
                    System.out.println("Output (Weighted): \"" + checkPasswordWeighted(input) + "\"");
                    System.out.println("Output (Blacklist): \"" + checkPasswordBlacklist(input) + "\"");
                } else {
                    System.out.println("Output: \"" + checkPassword(input) + "\"");
                }
            }
        }
    }

    /**
     * Core Requirement: Evaluates password based on 4 criteria.
     */
    public static String checkPassword(String password) {
        String safePassword = switch (password) {
            case null -> "";
            case String s -> s;
        };

        RuleEvaluation eval = evaluateRules(safePassword);
        int passed = eval.countPassed();
        
        String strength = switch (passed) {
            case 4 -> "Strong";
            case 2, 3 -> "Medium";
            case 0, 1 -> "Weak";
            default -> "Weak";
        };

        return formatOutput(eval, strength);
    }

    /**
     * Stretch Goal 1: Custom Rule Weighting
     */
    public static String checkPasswordWeighted(String password) {
        String safePassword = switch (password) {
            case null -> "";
            case String s -> s;
        };

        RuleEvaluation eval = evaluateRules(safePassword);
        int points = eval.getWeightedPoints();

        // Max points = 5. Cutoffs: 5 = Strong, 3-4 = Medium, 0-2 = Weak
        String strength = switch (points) {
            case 5 -> "Strong";
            case 3, 4 -> "Medium";
            default -> "Weak";
        };

        return formatOutput(eval, strength);
    }

    /**
     * Stretch Goal 2: Common Password Blacklist Check
     */
    public static String checkPasswordBlacklist(String password) {
        SequencedCollection<String> blacklist = new LinkedHashSet<>(List.of(
                "password", "123456", "qwerty", "admin", "12345678"
        ));

        String safePassword = switch (password) {
            case null -> "";
            case String s -> s;
        };

        for (String badPass : blacklist) {
            if (badPass.equalsIgnoreCase(safePassword)) {
                RuleEvaluation eval = evaluateRules(safePassword);
                // Immediately return Weak if it's on the blacklist
                return formatOutput(eval, "Weak");
            }
        }

        // If not blacklisted, proceed with the standard evaluation
        return checkPassword(safePassword);
    }

    // --- Private Helper Methods ---

    private static RuleEvaluation evaluateRules(String password) {
        boolean length = password.length() >= 8;
        boolean digit = false;
        boolean uppercase = false;
        boolean special = false;

        String specialChars = "!@#$%^&*";

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) digit = true;
            if (Character.isUpperCase(c)) uppercase = true;
            if (specialChars.indexOf(c) != -1) special = true;
        }

        return new RuleEvaluation(length, digit, uppercase, special);
    }

    private static String formatOutput(RuleEvaluation eval, String strength) {
        return String.format("Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s",
                eval.hasLength() ? "Pass" : "Fail",
                eval.hasDigit() ? "Pass" : "Fail",
                eval.hasUpper() ? "Pass" : "Fail",
                eval.hasSpecial() ? "Pass" : "Fail",
                strength);
    }
}
