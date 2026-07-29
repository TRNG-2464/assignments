import java.util.List;

class Solution{
    /**
     * Converts a true/false variable into Pass/Fail for printing
     * @param condition
     * @return pass/fail
     */
    static String mapResult(boolean condition){
        if (condition){
            return "Pass";
        }
        return "Fail";
    }

    /**
     * Converts strength level in terms of integer to a string with custom Strong/Medium/Weak levels
     * @param num
     * @return strength level
     */
    static String assignStrength(int num){
        if (num > 3){
            return "Strong";
        }
        else if (num > 1){
            return "Medium";
        }
        return "Weak";
    }

    /**
     * Same as above, but for Stretch Goal 1
     * @param num
     * @return strength level
     */
    static String assignStrengthCustom(int num){
        if (num > 5){
            return "Strong";
        }
        else if (num > 2){
            return "Medium";
        }
        return "Weak";
    }

    /**
     * Main assignment method
     * Checks a password for various rules assigning a strength value accordingly
     * @param password
     */
    static void checkStrength(String password){

        // handle invalid case first
        if (password == null || password.length() == 0){
            System.out.println("Blank password is invalid.");
            return;
        }

        boolean hasDigit = false, hasSpecial = false, hasUpper = false, hasLength = (password.length() >= 8);
        int numPassed = 0;

        // decision to loop through the entire string one by one was made because I have to loop through it anyways to find uppercase characters.
        // So I might as well put everything else in there, it won't increase the complexity any.
        // the special character condition could absolutely be done as a series of (if password.contains("!")) etc. calls

        // note that you can't add bools to ints in Java so I keep a separate counter for the number of tests passed.

        for (char c: password.toCharArray()){
            if (!hasDigit && Character.isDigit(c)){
                hasDigit = true;
                numPassed++;
            }
            else if (!hasUpper && Character.isUpperCase(c)){
                hasUpper = true;
                numPassed++;
            }
            else if (!hasSpecial && "!@#$%^&*".contains(String.valueOf(c))){
                hasSpecial = true;
                numPassed++;
            }
        }

        if (hasLength){
            numPassed++;
        }

        // This is where the helper functions from before come in.
        System.out.println("Length: " + mapResult(hasLength) + " | Digit: " + mapResult(hasDigit) + 
            " | Uppercase: " + mapResult(hasUpper) + " | Special Character: " + mapResult(hasSpecial) + " -- Strength: " + assignStrength(numPassed));
    }

    /**
     * Stretch Goal 1: Exactly the same as the first assignment, but different rules are worth different points.
     * To that end we use the custom assignStrength method, and we also change the assignments of numPassed in certain cases.
     * Specifically, special characters and length >= 8 are now worth 2 "strength points".
     * @param password
     */

    static void checkStrengthCustom(String password){

        if (password == null || password.length() == 0){
            System.out.println("Blank password is invalid.");
            return;
        }

        boolean hasDigit = false, hasSpecial = false, hasUpper = false, hasLength = (password.length() >= 8);
        int numPassed = 0;
        for (char c: password.toCharArray()){
            if (!hasDigit && Character.isDigit(c)){
                hasDigit = true;
                numPassed++;
            }
            else if (!hasUpper && Character.isUpperCase(c)){
                hasUpper = true;
                numPassed++;
            }
            else if (!hasSpecial && "!@#$%^&*".contains(String.valueOf(c))){
                hasSpecial = true;
                // special characters are worth more points
                numPassed += 2;
            }
        }

        if (hasLength){
            numPassed += 2;
        }

        System.out.println("Length: " + mapResult(hasLength) + " | Digit: " + mapResult(hasDigit) + 
            " | Uppercase: " + mapResult(hasUpper) + " | Special Character: " + mapResult(hasSpecial) + " -- Strength: " + assignStrengthCustom(numPassed));
    }

    /**
     * Stretch Goal 2: Exactly the same as the first assignment but first we have a list of blacklisted words it checks against.
     * @param password
     */
    static void checkStrengthBlacklist(String password){

        if (password == null || password.length() == 0){
            System.out.println("Blank password is invalid.");
            return;
        }

        List<String> blacklist = List.of(
            "password",
            "1234567",
            "example",
            "admin",
            "qwerty");
        
        // fairly simple impl: just check if the list contains are password, and if it does just return instantly.
        // use tolowercase to ensure case insensitive matching
        
        if (blacklist.contains(password.toLowerCase())){
            System.out.println("Password " + password + " is on blacklist. -- Strength: Weak");
            return;
        }

        boolean hasDigit = false, hasSpecial = false, hasUpper = false, hasLength = (password.length() >= 8);
        int numPassed = 0;
        for (char c: password.toCharArray()){
            if (!hasDigit && Character.isDigit(c)){
                hasDigit = true;
                numPassed++;
            }
            else if (!hasUpper && Character.isUpperCase(c)){
                hasUpper = true;
                numPassed++;
            }
            else if (!hasSpecial && "!@#$%^&*".contains(String.valueOf(c))){
                hasSpecial = true;
                numPassed++;
            }
        }

        if (hasLength){
            numPassed++;
        }

        System.out.println("Length: " + mapResult(hasLength) + " | Digit: " + mapResult(hasDigit) + 
            " | Uppercase: " + mapResult(hasUpper) + " | Special Character: " + mapResult(hasSpecial) + " -- Strength: " + assignStrength(numPassed));
    }

    public static void main(String[] args){
        checkStrength(""); // Output: Blank password is invalid.
        checkStrength(null); // Output: Blank password is invalid.
        checkStrength("qwertyuiop"); // Output: Length: Pass | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak
        checkStrength("lemming$1"); // Output: Length: Pass | Digit: Pass | Uppercase: Fail | Special Character: Pass -- Strength: Medium
        checkStrength("R4Oo03#%596("); // Output: Length: Pass | Digit: Pass | Uppercase: Pass | Special Character: Pass -- Strength: Strong
        checkStrength("$4R"); // Output: Length: Fail | Digit: Pass | Uppercase: Pass | Special Character: Pass -- Strength: Medium
    }
}