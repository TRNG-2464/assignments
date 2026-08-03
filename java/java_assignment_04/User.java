import java.util.ArrayList;
import java.util.List;

public class User {

    // This method uses string functions to check the whole string if it contains that certain value
    // It is actually way more efficient to check each character one by one and terminating checking early
    // If each type of condition passes, but it is more readable to use string functions
    public String passwordChecker(String password) {
        if (password == null || password.isEmpty()) {
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak";
        }

        int totalPasswordStrength = 0;

        boolean passLength = password.length() >= 8;

        if (passLength) totalPasswordStrength += 1;

        boolean hasDigit = password.matches(".*\\d.*");

        if (hasDigit) totalPasswordStrength += 1;

        boolean hasUpper = password.matches(".*[A-Z].*");

        if (hasUpper) totalPasswordStrength += 1;

        boolean hasSpecial = password.matches(".*[!@#$%^&*].*");

        if (hasSpecial) totalPasswordStrength += 1;

        return "Length: " + (passLength ? "Pass" : "Fail") +
                " | Digit: " + (hasDigit ? "Pass" : "Fail") +
                " | Uppercase: " + (hasUpper ? "Pass" : "Fail") +
                " | Special Character: " + (hasSpecial ? "Pass" : "Fail") +
                " -- Strength: " +
                (totalPasswordStrength == 4 ? "Strong" : totalPasswordStrength > 1 ? "Medium" : "Weak");
    }

    // Stretch Goal 1 - special characters are worth 2 points
    // 5 = Strong, 3-4 = Medium, less than 3 = Weak
    public String passwordCheckerCustomWeights(String password) {
        if (password == null || password.isEmpty()) {
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak";
        }

        int totalPasswordStrength = 0;

        boolean passLength = password.length() >= 8;

        if (passLength) totalPasswordStrength += 1;

        boolean hasDigit = password.matches(".*\\d.*");

        if (hasDigit) totalPasswordStrength += 1;

        boolean hasUpper = password.matches(".*[A-Z].*");

        if (hasUpper) totalPasswordStrength += 1;

        boolean hasSpecial = password.matches(".*[!@#$%^&*].*");

        if (hasSpecial) totalPasswordStrength += 2;

        return "Length: " + (passLength ? "Pass" : "Fail") +
                " | Digit: " + (hasDigit ? "Pass" : "Fail") +
                " | Uppercase: " + (hasUpper ? "Pass" : "Fail") +
                " | Special Character: " + (hasSpecial ? "Pass" : "Fail") +
                " -- Strength: " +
                (totalPasswordStrength == 5 ? "Strong" : totalPasswordStrength > 2 ? "Medium" : "Weak");
    }

    // Stretch Goal 2 - common password blacklist
    public String passwordCheckerWithCommon(String password) {

        List<String> commonPasswords = new ArrayList<>(
                List.of("password", "123456", "qwerty", "12345678", "admin123")
        );

        if (password == null || password.isEmpty()) {
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak";
        }

        int totalPasswordStrength = 0;

        boolean passLength = password.length() >= 8;

        if (passLength) totalPasswordStrength += 1;

        boolean hasDigit = password.matches(".*\\d.*");

        if (hasDigit) totalPasswordStrength += 1;

        boolean hasUpper = password.matches(".*[A-Z].*");

        if (hasUpper) totalPasswordStrength += 1;

        boolean hasSpecial = password.matches(".*[!@#$%^&*].*");

        if (hasSpecial) totalPasswordStrength += 1;

        boolean isCommonPassword = false;

        for (String commonPassword : commonPasswords) {
            if (commonPassword.equalsIgnoreCase(password)) {
                isCommonPassword = true;
                break;
            }
        }

        return "Length: " + (passLength ? "Pass" : "Fail") +
                " | Digit: " + (hasDigit ? "Pass" : "Fail") +
                " | Uppercase: " + (hasUpper ? "Pass" : "Fail") +
                " | Special Character: " + (hasSpecial ? "Pass" : "Fail") +
                " -- Strength: " +
                (isCommonPassword ? "Weak" : totalPasswordStrength == 4 ? "Strong" : totalPasswordStrength > 1 ? "Medium" : "Weak");
    }

    public static void main(String[] args) {
        User user = new User();

        System.out.println("Base requirements:");
        System.out.println(user.passwordChecker("password"));
        System.out.println(user.passwordChecker("Password1"));
        System.out.println(user.passwordChecker("P@ssw0rd"));
        System.out.println(user.passwordChecker(""));
        System.out.println(user.passwordChecker(null));
        System.out.println(user.passwordChecker("Password1?"));

        System.out.println("\nCustom weighting:");
        System.out.println(user.passwordCheckerCustomWeights("P@ssw0rd"));
        System.out.println(user.passwordCheckerCustomWeights("Password1"));

        System.out.println("\nCommon password blacklist:");
        System.out.println(user.passwordCheckerWithCommon("password"));
        System.out.println(user.passwordCheckerWithCommon("PASSWORD"));
        System.out.println(user.passwordCheckerWithCommon("P@ssw0rd"));
    }
}
