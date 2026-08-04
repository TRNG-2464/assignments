import java.util.Scanner;

public class PasswordStrengthChecker {

    public static String checkPasswordStrength(String password) {

        // Handle null input without crashing
        if (password == null) {
            return "Length: Fail | Digit: Fail | Uppercase: Fail "
                    + "| Special Character: Fail -- Strength: Weak";
        }

        // Track each password rule independently
        boolean hasValidLength = password.length() >= 8;
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasSpecialCharacter = false;

        // The allowed special characters
        String specialCharacters = "!@#$%^&*";

        // Check every character in the password
        for (int i = 0; i < password.length(); i++) {

            char currentCharacter = password.charAt(i);

            // Check for a digit
            if (Character.isDigit(currentCharacter)) {
                hasDigit = true;
            }

            // Check for an uppercase letter
            if (Character.isUpperCase(currentCharacter)) {
                hasUppercase = true;
            }

            // Check for an allowed special character
            if (specialCharacters.indexOf(currentCharacter) >= 0) {
                hasSpecialCharacter = true;
            }
        }

        // Count how many rules passed
        int rulesPassed = 0;

        if (hasValidLength) {
            rulesPassed++;
        }

        if (hasDigit) {
            rulesPassed++;
        }

        if (hasUppercase) {
            rulesPassed++;
        }

        if (hasSpecialCharacter) {
            rulesPassed++;
        }

        // Determine the overall password strength
        String strength;

        if (rulesPassed == 4) {
            strength = "Strong";
        } else if (rulesPassed >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        // Return the result of every rule and the overall strength
        return "Length: " + (hasValidLength ? "Pass" : "Fail")
                + " | Digit: " + (hasDigit ? "Pass" : "Fail")
                + " | Uppercase: " + (hasUppercase ? "Pass" : "Fail")
                + " | Special Character: "
                + (hasSpecialCharacter ? "Pass" : "Fail")
                + " -- Strength: " + strength;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");

        // nextLine() allows the program to read the entire input
        String password = scanner.nextLine();

        System.out.println();
        System.out.println(checkPasswordStrength(password));

        scanner.close();
    }
}