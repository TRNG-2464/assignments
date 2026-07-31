import java.util.ArrayList;
import java.util.List;

public class User{

    // This method uses string functions to check the whole string if it contains that certain value
    // It is actually way more efficient to check each character one by one and terminating checking early
    // If each type of condition passes, but it is more readable to use string functions
    public String passwordChecker(String password){
        if (password == null || password.isEmpty()){
            return "Length: No Input | Digit: No Input | Uppercase: No Input | Special Character: No Input -- Strength: No Input";
        }

        int totalPasswordStrength = 0;

        boolean passLength = password.length() >= 8;
        
        if (passLength) totalPasswordStrength +=  1;

        boolean hasDigit = password.matches(".*\\d.*");

        if (hasDigit) totalPasswordStrength += 1;

        boolean hasUpper = password.matches(".*[A-Z].*");

        if (hasUpper) totalPasswordStrength += 1;

        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        if (hasSpecial) totalPasswordStrength += 1;

        return "Length: " + (passLength?"Pass":"Fail") + " | Digit: " + (hasDigit?"Pass":"Fail") + " | Uppercase: " + (hasUpper?"Pass":"Fail") + 
        " | Special Character: " + (hasSpecial?"Pass":"Fail") + " -- Strength: " + (totalPasswordStrength == 4? "Strong": totalPasswordStrength > 1? "Medium": "Weak");
    }

    // Stretch Goal 1 - I'll only change special to have 2
    // 5 = Strong, 3-4 = Medium, < 3 = Weak
    public String passwordCheckerCustomWeights(String password){
        if (password == null || password.isEmpty()){
            return "Length: No Input | Digit: No Input | Uppercase: No Input | Special Character: No Input -- Strength: No Input";
        }

        int totalPasswordStrength = 0;

        boolean passLength = password.length() >= 8;
        
        if (passLength) totalPasswordStrength +=  1;

        boolean hasDigit = password.matches(".*\\d.*");

        if (hasDigit) totalPasswordStrength += 1;

        boolean hasUpper = password.matches(".*[A-Z].*");

        if (hasUpper) totalPasswordStrength += 1;

        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        if (hasSpecial) totalPasswordStrength += 2;

        return "Length: " + (passLength?"Pass":"Fail") + " | Digit: " + (hasDigit?"Pass":"Fail") + " | Uppercase: " + (hasUpper?"Pass":"Fail") + 
        " | Special Character: " + (hasSpecial?"Pass":"Fail") + " -- Strength: " + (totalPasswordStrength == 5? "Strong": totalPasswordStrength > 2? "Medium": "Weak");
    }

    // With common passwords
    public String passwordCheckerWithCommon(String password){

        List<String> commonPasswords = new ArrayList<>(List.of("123456", "admin", "Password", "12345678", "admin123"));
        
        if (password == null || password.isEmpty()){
            return "Length: No Input | Digit: No Input | Uppercase: No Input | Special Character: No Input -- Strength: No Input";
        }

        int totalPasswordStrength = 0;

        boolean passLength = password.length() >= 8;
        
        if (passLength) totalPasswordStrength +=  1;

        boolean hasDigit = password.matches(".*\\d.*");

        if (hasDigit) totalPasswordStrength += 1;

        boolean hasUpper = password.matches(".*[A-Z].*");

        if (hasUpper) totalPasswordStrength += 1;

        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        if (hasSpecial) totalPasswordStrength += 1;

        return "Length: " + (passLength?"Pass":"Fail") + " | Digit: " + (hasDigit?"Pass":"Fail") + " | Uppercase: " + (hasUpper?"Pass":"Fail") + 
        " | Special Character: " + (hasSpecial?"Pass":"Fail") + " -- Strength: " + (commonPasswords.contains(password)?"Weak":totalPasswordStrength == 4? "Strong": totalPasswordStrength > 1? "Medium": "Weak");
    }

}