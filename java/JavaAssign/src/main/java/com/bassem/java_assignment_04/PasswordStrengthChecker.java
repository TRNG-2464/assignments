package com.bassem.java_assignment_04;

public class PasswordStrengthChecker {
    public static void passwordCheck(String password){
          // check null
        if(password == null){
            System.out.println("Length: Fail | Digit:Fail | Uppercase: Fail | Special Char: Fail");
            return ;
        }
        boolean lengthPass = password.length()>= 8;
        Boolean digitPass = false;
        boolean uppercasePass = false;
        boolean specialPass = false;
        String  specialChar ="!@#$%^&*";
        // check each char
        for(int i=0; i< password.length(); i++){
            char ch = password.charAt(i);
            if(Character.isDigit(ch)){
                digitPass = true;
            }
            if(Character.isUpperCase(ch)){

                uppercasePass = true;
            }
            if(specialChar.indexOf(ch) != -1){

                specialPass = true;
            }
            // Count All rules
            int passRules = 0;
            if (lengthPass) {
                passRules++;
            };
             if(digitPass) {
                 passRules++;
             }
             if (uppercasePass) {
                 passRules++;
             }
            if (specialPass) {
                passRules++;
            }
            // strength
            String strength;
            if(passRules == 4){
                strength = "Strong";
            }else if (passRules >= 2){
                strength = "Medium";
            } else {
                strength = "Weak";
            }
            // Result
            System.out.println(
                    "Length :" + ( lengthPass ? "Pass" : "Fail") +
                            "| Digit: " +(digitPass ? "Pass" : "Fail") +
                            "| Uppercase:" + (uppercasePass ? "Pass" : "Fail") +
                            "| Special Char:" + (specialPass ? "Pass" : "Fail") +
                            "| Strength:" + strength );
        }
    }
    public  static void main(String [] args){
        passwordCheck("password");
        passwordCheck("Passward1");
        passwordCheck("P@ssw0rd");
        passwordCheck("");
        passwordCheck(null);
    }
}
