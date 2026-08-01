public class asgn_04 {
    public static void main(String[] args) {
        String password;
        if (args.length > 0){
            password=args[0];
        }else{
            password = "";
        }
        System.out.println(checkPasswordStrength(password));
    }

    public static String checkPasswordStrength(String password) {
        if (password==null) {
            password = "";
        }

        boolean hasLength = password.length()>=8;
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*";

        for (int i = 0; i < password.length(); i++) {
            char currentChar=password.charAt(i);
            if (Character.isDigit(currentChar)) {
                hasDigit = true;
            }
            // Doesn't this assignment assume that we won't make a password that's all caps?
            if (Character.isUpperCase(currentChar)) { 
                hasUppercase = true;
            }
            if (specialChars.indexOf(currentChar) >= 0) {
                hasSpecial = true;
            }
        }

        int passed = 0;
        if (hasLength){passed++;};
        if (hasDigit){passed++;};
        if (hasUppercase){passed++;};
        if (hasSpecial){passed++;};

        String strength;
        if (passed == 4) {
            strength = "Strong";
        } else if (passed >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }

        return String.format(
            "Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s",
            // Ternary operator '?' is if/else-> true : false
            hasLength ? "Pass" : "Fail",
            hasDigit ? "Pass" : "Fail",
            hasUppercase ? "Pass" : "Fail",
            hasSpecial ? "Pass" : "Fail",
            strength
        );
    }
}
