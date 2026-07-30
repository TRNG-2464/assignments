
public class PasswordStrengthChecker {

    public static void main(String[] args) {
        checkPassword("password");
        checkPassword("Password1");
        checkPassword("P@ssw0rd");
        checkPassword("");
        checkPassword(null);
    }

    public static void checkPassword(String password) {

        if (password == null) {
            password = "";
        }

        boolean lengthPass = password.length() >= 8;
        boolean digitPass = false;
        boolean uppercasePass = false;
        boolean specialPass = false;

        String specialCharacters = "!@#$%^&*";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isDigit(c)) {
                digitPass = true;
            }

            if (Character.isUpperCase(c)) {
                uppercasePass = true;
            }

            if (specialCharacters.indexOf(c) != -1) {
                specialPass = true;
            }
        }

        int passedRules = 0;

        if (lengthPass) {
            passedRules++;
        }

        if (digitPass) {
            passedRules++;
        }

        if (uppercasePass) {
            passedRules++;
        }

        if (specialPass) {
            passedRules++;
        }

        String strength;

        if (passedRules == 4) {
            strength = "Strong";
        } else if (passedRules >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        System.out.println(
                "Input: " + (password.isEmpty() ? "\"\"" : "\"" + password + "\""));
        System.out.println(
                "Length: " + (lengthPass ? "Pass" : "Fail")
                        + " | Digit: " + (digitPass ? "Pass" : "Fail")
                        + " | Uppercase: " + (uppercasePass ? "Pass" : "Fail")
                        + " | Special Character: " + (specialPass ? "Pass" : "Fail")
                        + " -- Strength: " + strength);
        System.out.println();
    }
}