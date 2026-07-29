import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PasswordStrengthChecker {
    public String checkPasswordStrength(String password) {
        if (password == null) {
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak";
        }

        boolean hasAtleast8Chars = false;
        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasSpecial = false; // !@#$%^&*

        Set<Character> specials = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*'));
        
        if (password.length() >= 8) {
            hasAtleast8Chars = true;
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            if (specials.contains(c)) {
                hasSpecial = true;
            }
        }

        int passCount = 0;
        if (hasAtleast8Chars) {
            passCount += 1;
        }

        if (hasDigit) {
            passCount += 1;
        }

        if (hasUpper) {
            passCount += 1;
        }

        if (hasSpecial) {
            passCount += 1;
        }

        return String.format("Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s",
            getPassFailStr(hasAtleast8Chars),
            getPassFailStr(hasDigit),
            getPassFailStr(hasUpper),
            getPassFailStr(hasSpecial),
            getStrengthStr(passCount)
        );
    }

    private String getPassFailStr(boolean b) {
        return b ? "Pass" : "Fail";
    }

    private String getStrengthStr(int points) {
        if (points < 2) {
            return "Weak";
        } else if (points < 4) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    // Stretch goals
    
    // Custom Rule Weighting
    public String checkPasswordStrengthCustomRule(String password) {
        if (password == null) {
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak";
        }

        boolean hasAtleast8Chars = false;
        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasSpecial = false; // !@#$%^&*

        Set<Character> specials = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*'));
        
        if (password.length() >= 8) {
            hasAtleast8Chars = true;
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            if (specials.contains(c)) {
                hasSpecial = true;
            }
        }

        int passCount = 0;
        if (hasAtleast8Chars) {
            passCount += 1;
        }

        if (hasDigit) {
            passCount += 2;
        }

        if (hasUpper) {
            passCount += 2;
        }

        if (hasSpecial) {
            passCount += 3;
        }

        return String.format("Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s",
            getPassFailStr(hasAtleast8Chars),
            getPassFailStr(hasDigit),
            getPassFailStr(hasUpper),
            getPassFailStr(hasSpecial),
            getCustomStrengthStr(passCount, 8)
        );
    }

    private String getCustomStrengthStr(int points, int total) {
        double percentage = (double) points / total;

        if (percentage < 0.6) {
            return "Weak";
        } else if (percentage < 0.8) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    // Common Password Blacklist Check
    Set<String> blacklist = new HashSet<>(Arrays.asList("password", "123456", "qwerty", "password123", "pass123"));

    public String checkCommonPassword(String password) {
        if (blacklist.contains(password)) {
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak";
        }

        if (password == null) {
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak";
        }

        boolean hasAtleast8Chars = false;
        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasSpecial = false; // !@#$%^&*

        Set<Character> specials = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*'));
        
        if (password.length() >= 8) {
            hasAtleast8Chars = true;
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            if (specials.contains(c)) {
                hasSpecial = true;
            }
        }

        int passCount = 0;
        if (hasAtleast8Chars) {
            passCount += 1;
        }

        if (hasDigit) {
            passCount += 1;
        }

        if (hasUpper) {
            passCount += 1;
        }

        if (hasSpecial) {
            passCount += 1;
        }

        return String.format("Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s",
            getPassFailStr(hasAtleast8Chars),
            getPassFailStr(hasDigit),
            getPassFailStr(hasUpper),
            getPassFailStr(hasSpecial),
            getStrengthStr(passCount)
        );
    }
}