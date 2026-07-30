import java.util.Arrays;
import java.util.List;

public class PasswordStrengthChecker {
    private static final List<String> PASSWORD_BLACKLIST = Arrays.asList(
            "password",
            "123456",
            "qwerty",
            "welcome1",
            "letmein1"
    );
    public static void main(String[] args){
        // Test with your original input
        System.out.println(passWordStrengthChecker("Password"));
    }

    public static String passWordStrengthChecker(String password){
        String specialCharList = "!@#$%^&*";
        int count = 0;

        // Boolean flags to track criteria fulfillment
        boolean isLengthValid = password.length() >= 8;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Step 1: Scan the password character by character
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            // Check if the character is in our special character list
            if (specialCharList.indexOf(ch) != -1) {
                hasSpecial = true;
            }
        }

        // Step 2: Calculate total score (count)
        if (isLengthValid) count++;
        if (hasUpper) count++;
        if (hasDigit) count++;
        if (hasSpecial) count++;

        // Step 3: Format the status reports
        String resultLength = isLengthValid ? "Length: Pass" : "Length: Fail";
        String resultUppercase = hasUpper ? "Uppercase: Pass" : "Uppercase: Fail";
        String resultDigit = hasDigit ? "Digit: Pass" : "Digit: Fail";
        String resultSpecialChar = hasSpecial ? "Special Character: Pass" : "Special Character: Fail";

        // Step 4: Determine strength based on total successful criteria
        String strength;
        if (count <= 1) {
            strength = "Weak";
        } else if (count == 2 || count == 3) {
            strength = "Medium";
        } else {
            strength = "Strong";
        }

        return resultLength + " | " + resultDigit + " | " + resultUppercase + " | " +
                resultSpecialChar + " | " + "Strength: " + strength;
    }

    public static String passWordStrengthChecker2(String password){
        String specialCharList = "!@#$%^&*";
        int totalPoints = 0; // Tracks the weighted score

        boolean isLengthValid = password.length() >= 8;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (specialCharList.indexOf(ch) != -1) {
                hasSpecial = true;
            }
        }

        if (isLengthValid) totalPoints += 1;      // Length = 1 pt
        if (hasUpper)      totalPoints += 1;      // Uppercase = 1 pt
        if (hasDigit)      totalPoints += 1;      // Digit = 1 pt
        if (hasSpecial)    totalPoints += 2;      // Special Character = 2 pts

        String resultLength = isLengthValid ? "Length: Pass" : "Length: Fail";
        String resultUppercase = hasUpper ? "Uppercase: Pass" : "Uppercase: Fail";
        String resultDigit = hasDigit ? "Digit: Pass" : "Digit: Fail";
        String resultSpecialChar = hasSpecial ? "Special Character: Pass" : "Special Character: Fail";

        String strength;
        if (totalPoints <= 2) {
            strength = "Weak";
        } else if (totalPoints == 3 || totalPoints == 4) {
            strength = "Medium";
        } else {
            strength = "Strong";
        }

        return resultLength + " | " + resultDigit + " | " + resultUppercase + " | " +
                resultSpecialChar + " | " + "Total Points: " + totalPoints + "/5 | Strength: " + strength;
    }

    public static String passWordStrengthChecker3(String password){
        if (password != null && PASSWORD_BLACKLIST.contains(password.toLowerCase())) {
            return "Length: Bypass | Digit: Bypass | Uppercase: Bypass | " +
                    "Special Character: Bypass | Total Points: 0/5 | Strength: Weak (Blacklisted)";
        }

        String specialCharList = "!@#$%^&*";
        int totalPoints = 0;

        boolean isLengthValid = password != null && password.length() >= 8;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (password != null) {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);

                if (Character.isUpperCase(ch)) {
                    hasUpper = true;
                }
                if (Character.isDigit(ch)) {
                    hasDigit = true;
                }
                if (specialCharList.indexOf(ch) != -1) {
                    hasSpecial = true;
                }
            }
        }

        if (isLengthValid) totalPoints += 1;
        if (hasUpper)      totalPoints += 1;
        if (hasDigit)      totalPoints += 1;
        if (hasSpecial)    totalPoints += 2;

        String resultLength = isLengthValid ? "Length: Pass" : "Length: Fail";
        String resultUppercase = hasUpper ? "Uppercase: Pass" : "Uppercase: Fail";
        String resultDigit = hasDigit ? "Digit: Pass" : "Digit: Fail";
        String resultSpecialChar = hasSpecial ? "Special Character: Pass" : "Special Character: Fail";

        String strength;
        if (totalPoints <= 2) {
            strength = "Weak";
        } else if (totalPoints == 3 || totalPoints == 4) {
            strength = "Medium";
        } else {
            strength = "Strong";
        }

        return resultLength + " | " + resultDigit + " | " + resultUppercase + " | " +
                resultSpecialChar + " | " + "Total Points: " + totalPoints + "/5 | Strength: " + strength;
    }
}


