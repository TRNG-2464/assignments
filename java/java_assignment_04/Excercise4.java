public class Excercise4 {
    // Checks the password and returns the results
    public static String checkPassword(String password) {
        // Handling null input
        if (password == null) {
            password = "";
        }
        boolean hasLength = false;
        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        // Checking length
        if (password.length() >= 8) {
            hasLength = true;
        }
        // Go through each character
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
            if ("!@#$%^&*".indexOf(ch) != -1) {
                hasSpecial = true;
            }
        }

        int passed = 0;

        if (hasLength) {
            passed++;
        }
        if (hasDigit) {
            passed++;
        }
        if (hasUpper) {
            passed++;
        }
        if (hasSpecial) {
            passed++;
        }

        String strength;

        if (passed == 4) {
            strength = "Strong";
        } else if (passed >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        return "Length: " + (hasLength ? "Pass" : "Fail") +
                " | Digit: " + (hasDigit ? "Pass" : "Fail") +
                " | Uppercase: " + (hasUpper ? "Pass" : "Fail") +
                " | Special Character: " + (hasSpecial ? "Pass" : "Fail") +
                " -- Strength: " + strength;
    }

    public static void main(String[] args) {
        System.out.println(checkPassword("password"));
        System.out.println(checkPassword("Password1"));
        System.out.println(checkPassword("P@ssw0rd"));
        System.out.println(checkPassword(""));
        System.out.println(checkPassword(null));
    }
}