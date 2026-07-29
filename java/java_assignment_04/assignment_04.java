//package java.java_assignment_04;

public class assignment_04 {
    public static String passwordChecker(String password){
        boolean lengthCheck = false;
        boolean digitCheck = false;
        boolean uppercaseCheck = false;
        boolean specialCharCheck = false;
        if(password == null || password.isEmpty()){
            return "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Stength: Weak";
        }
        if(password.length() >= 8){
            lengthCheck = true;
        }
        for(int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if(Character.isDigit(c)){
                digitCheck = true;
            }
            if(Character.isUpperCase(c)){
                uppercaseCheck = true;
            }
            if(!Character.isLetterOrDigit(c)){
                specialCharCheck = true;
            }
        }
        String lengthResult = lengthCheck ? "Pass" : "Fail";
        String digitResult = digitCheck ? "Pass" : "Fail";
        String uppercaseResult = uppercaseCheck ? "Pass" : "Fail";
        String specialCharResult = specialCharCheck ? "Pass" : "Fail";
        String strength = "";

        int ruleCount = 0;
        if(lengthCheck){
            ruleCount++;
        }
        if(digitCheck){
            ruleCount++;
        }
        if(uppercaseCheck){
            ruleCount++;
        }
        if(specialCharCheck){
            ruleCount++;
        }

        switch(ruleCount){
            case 4:
                strength = "Strong";
                break;
            case 2:
            case 3:
                strength = "Moderate";
                break;
            default:
                strength = "Weak";
        }
        return "Input: %s %nLength: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s %n".formatted(password, lengthResult, digitResult, uppercaseResult, specialCharResult, strength);
    }

    public static void main(String[] args) {
        System.out.println(passwordChecker("Password123!"));
        System.out.println(passwordChecker("pass"));
        System.out.println(passwordChecker("password"));
        System.out.println(passwordChecker("PA@ssw0rd"));
        System.out.println(passwordChecker(""));
        System.out.println(passwordChecker("@1"));
}
}
