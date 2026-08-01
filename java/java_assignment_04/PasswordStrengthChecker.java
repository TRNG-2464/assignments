
public class PasswordStrengthChecker {

    public static void main(String[] args) {
        System.out.println("=== Password Strength Tests ===\n");

        // 1. Fails everything except length
        System.out.println(PasswordStrengthChecker("password"));

        // 2. Passes length, digit, uppercase
        System.out.println(PasswordStrengthChecker("Password1"));

        // 3. Passes all four rules
        System.out.println(PasswordStrengthChecker("P@ssw0rd"));

        // 4. Empty string
        System.out.println(PasswordStrengthChecker(""));

        // 5. Null input
        System.out.println(PasswordStrengthChecker(null));

        // 6. Exactly 8 characters, all rules pass
        System.out.println(PasswordStrengthChecker("A1!bcdef"));

        // 7. Exactly 7 characters, otherwise passes everything
        System.out.println(PasswordStrengthChecker("A1!bcde"));

        // 8. Only digits
        System.out.println(PasswordStrengthChecker("12345678"));

        // 9. Only uppercase letters
        System.out.println(PasswordStrengthChecker("ABCDEFGH"));

        // 10. Only special characters
        System.out.println(PasswordStrengthChecker("!@#$%^&*"));

        // 11. Lowercase + digit, no uppercase/special
        System.out.println(PasswordStrengthChecker("abcdefg1"));

        // 12. Uppercase + special, no digit
        System.out.println(PasswordStrengthChecker("Abcdefg!"));

        // 13. Uppercase + digit + special, but too short
        System.out.println(PasswordStrengthChecker("A1!bc"));

        // 14. Special character at beginning
        System.out.println(PasswordStrengthChecker("!Password1"));

        // 15. Special character at end
        System.out.println(PasswordStrengthChecker("Password1!"));

        // 16. Special character in middle
        System.out.println(PasswordStrengthChecker("Pass!word1"));

        // 17. Multiple digits
        System.out.println(PasswordStrengthChecker("Password123"));

        // 18. Multiple uppercase letters
        System.out.println(PasswordStrengthChecker("PASSWORD1!"));

        // 19. All allowed special characters
        System.out.println(PasswordStrengthChecker("Abcdef1!@#$%^&*"));

        // 20. Completely empty/invalid-ish input
        System.out.println(PasswordStrengthChecker("1"));
    }

    public static String PasswordStrengthChecker(String password) {

        // Pattern one_digit_regex = Pattern.compile("\\d");
        // boolean one_digit = one_digit_regex.matcher(password).matches();
        StringBuilder out = new StringBuilder();

        if (password == null || password.length() == 0) {
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak";
        }

        int strength_meter = 0;
        // boolean length = false;
        boolean one_digit = false;
        boolean one_uppercase = false;
        boolean special_character = false;

        // Length check
        if (password.length() >= 8) {
            strength_meter++;
            out.append("Length: Pass | ");
        } else {
            out.append("Length: Fail | ");
        }

        // Special character set
        String special_chars = "!@#$%^&*";
        int[] special_set = new int[256];
        for (int i = 0; i < special_chars.length(); i++) {
            special_set[(int) special_chars.charAt(i)] = 1;
        }

        // Check all characters with short circuiting checks
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!one_digit && c >= '0' && c <= '9') {
                one_digit = true;
            }

            if (!one_uppercase && c >= 'A' && c <= 'Z') {
                one_uppercase = true;
            }

            if (!special_character && special_set[(int) c] == 1) {
                special_character = true;
            }

        }

        String[] strength_label = {"Weak", "Medium", "Strong"};
        if (one_digit) {
            strength_meter++;
            out.append("Digit: Pass | ");
        } else {
            out.append("Digit: Fail | ");
        }

        if (one_uppercase) {
            strength_meter++;
            out.append("Uppercase: Pass | ");
        } else {
            out.append("Uppercase: Fail | ");
        }

        if (special_character) {
            strength_meter++;
            out.append("Special Character: Pass ");
        } else {
            out.append("Special Character: Fail ");
        }

        if (strength_meter > 3) {
            out.append("-- Strength: Strong");
            return new String(out);
        }

        if (strength_meter == 3) {
            out.append("-- Strength: Medium");
            return new String(out);
        }

        out.append("-- Strength: Weak");
        return new String(out);

    }
}
