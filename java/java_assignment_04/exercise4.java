import java.util.*;
public class exercise4 {
    public static void main(String[] args) {
        System.out.print(passwordStrength("111"));
    }
    public static String passwordStrength(String password) {
        String ret = "";
        int passes = 0;
        if (password.length() >= 8) {
            passes += 1;
            ret += "Length: Pass | ";
        } else {
            ret += "Length: Fail | ";
        }
        ArrayList<Character> specialChars = new ArrayList<Character>(List.of('!', '@', '#', '$', '%', '^', '&', '*'));
        ArrayList<Character> digits = new ArrayList<Character>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        boolean containsSpecialChar = false;
        boolean containsDigit = false;
        boolean containsUpper = false;
        for (char i : password.toCharArray()) {
            if (specialChars.contains(i)) {
                containsSpecialChar = true;
            } else if (digits.contains(i)) {
                containsDigit = true;
            } else if (Character.isUpperCase(i)) {
                containsUpper = true;
            }
        }
        if (containsDigit) {
            passes += 1;
            ret += "Digit: Pass | ";
        } else {
            ret += "Digit: Fail | ";
        }
        if (containsUpper) {
            passes += 1;
            ret += "Upper: Pass | ";
        } else {
            ret += "Upper: Fail | ";
        }
        if (containsSpecialChar) {
            passes += 1;
            ret += "Special Character: Pass -- ";
        } else {
            ret += "Special Character: Fail -- ";
        }
        if (passes == 4) {
            ret += "Strength: Strong";
        } else if (passes > 1 && passes < 4) {
            ret += "Strength: Medium";
        } else {
            ret += "Strength: Weak";
        }
        return ret;
    }
    public static String stretchGoal1(String password) {
        String ret = "";
        int passes = 0;
        if (password.length() >= 8) {
            passes += 1;
            ret += "Length: Pass | ";
        } else {
            ret += "Length: Fail | ";
        }
        ArrayList<Character> specialChars = new ArrayList<Character>(List.of('!', '@', '#', '$', '%', '^', '&', '*'));
        ArrayList<Character> digits = new ArrayList<Character>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        boolean containsSpecialChar = false;
        boolean containsDigit = false;
        boolean containsUpper = false;
        for (char i : password.toCharArray()) {
            if (specialChars.contains(i)) {
                containsSpecialChar = true;
            } else if (digits.contains(i)) {
                containsDigit = true;
            } else if (Character.isUpperCase(i)) {
                containsUpper = true;
            }
        }
        if (containsDigit) {
            passes += 1;
            ret += "Digit: Pass | ";
        } else {
            ret += "Digit: Fail | ";
        }
        if (containsUpper) {
            passes += 1;
            ret += "Upper: Pass | ";
        } else {
            ret += "Upper: Fail | ";
        }
        if (containsSpecialChar) {
            passes += 2;
            ret += "Special Character: Pass -- ";
        } else {
            ret += "Special Character: Fail -- ";
        }
        ArrayList<String> badPasswords = new ArrayList<>();
        badPasswords.add("password");
        badPasswords.add("123456");
        badPasswords.add("qwerty");
        badPasswords.add("password1");
        badPasswords.add("password2");
        if (badPasswords.contains(password.toLowerCase())) {
            ret += "Strength: Weak";
        } else {
            if (passes == 5) {
                ret += "Strength: Strong";
            } else if (passes > 1 && passes < 5) {
                ret += "Strength: Medium";
            } else {
                ret += "Strength: Weak";
            }
        }
        return ret;
    }
}
