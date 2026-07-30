import java.util.Set;
import java.util.HashSet;

public class main {

    static void validatePassword(String password) {
        boolean validLength = true;
        boolean digit = false;
        boolean upper = false;
        boolean special = false;

        if (password != null) {

            if (password.length() < 8) {
                validLength = false;
            }


            for (int i = 0; i < password.length(); i++) {
                Character c = password.charAt(i);
                if (Character.isDigit(c)) {
                    digit = true;
                    break;
                }
            }

            for (int i = 0; i < password.length(); i++) {
                Character c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    upper = true;
                    break;
                }
            }


            String setString = "!@#$%^&*";
            Set<Character> set = new HashSet<>();
            for (Character c : setString.toCharArray()) {
                set.add(c);
            }

            for (int i = 0; i < password.length(); i++) {
                Character c = password.charAt(i);
                if (set.contains(c)) {
                    special = true;
                    break;
                }
            }
        }


        int strength = 0;
        if (validLength) {
            strength++;
        }
        if (digit) {
            strength++;
        }
        if (upper) {
            strength++;
        }
        if (special) {
            strength++;
        }

        String strengthType = "";
        switch (strength) {
            case 4:
                strengthType = "Strong";
                break;
            case 3:
            case 2:
                strengthType = "Medium";
                break;
            default:
                strengthType = "Weak";
                break;
        }

        System.out.println("Length: " + (validLength ? "Pass" : "Fail") + " | Digit: " + (digit ? "Pass" : "Fail") + " | Uppercase: " + (upper ? "Pass" : "Fail") + " | Special Character: " + (special ? "Pass" : "Fail") + " -- Strength: " + strengthType);
    }

    static void weightedPassword(String password) {
        boolean validLength = true;
        boolean digit = false;
        boolean upper = false;
        boolean special = false;

        if (password != null) {

            if (password.length() < 8) {
                validLength = false;
            }


            for (int i = 0; i < password.length(); i++) {
                Character c = password.charAt(i);
                if (Character.isDigit(c)) {
                    digit = true;
                    break;
                }
            }

            for (int i = 0; i < password.length(); i++) {
                Character c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    upper = true;
                    break;
                }
            }


            String setString = "!@#$%^&*";
            Set<Character> set = new HashSet<>();
            for (Character c : setString.toCharArray()) {
                set.add(c);
            }

            for (int i = 0; i < password.length(); i++) {
                Character c = password.charAt(i);
                if (set.contains(c)) {
                    special = true;
                    break;
                }
            }
        }

        int lengthPoints = 2;
        int digitPoints = 2;
        int upperPoints = 4;
        int specialPoints = 6;

        String strengthType;
        int strength = 0;
        if (validLength) {
            strength += lengthPoints;
        }
        if (digit) {
            strength += digitPoints;
        }
        if (upper) {
            strength += upperPoints;
        }
        if (special) {
            strength += specialPoints;
        }

        if (strength > 0 && strength <= 2) {
            strengthType = "Weak";
        } else if (strength <= 9) {
            strengthType = "Medium";
        } else {
            strengthType = "Strong";
        }

        System.out.println("Length: " + (validLength ? "Pass" : "Fail") + " | Digit: " + (digit ? "Pass" : "Fail") + " | Uppercase: " + (upper ? "Pass" : "Fail") + " | Special Character: " + (special ? "Pass" : "Fail") + " -- Strength: " + strengthType);
    }

    static void blacklistPassword(String password) {
        String[] blacklist = {
            "password",
            "root",
            "123456",
            "qwerty",
            "admin"
        };

        for (int i = 0; i < blacklist.length; i++) {
            String str = blacklist[i];
            if (password.equals(str)) {
                System.out.println("Weak password is blacklisted.");
                return;
            }
        }


        boolean validLength = true;
        boolean digit = false;
        boolean upper = false;
        boolean special = false;

        if (password != null) {
            if (password.length() < 8) {
                validLength = false;
            }


            for (int i = 0; i < password.length(); i++) {
                Character c = password.charAt(i);
                if (Character.isDigit(c)) {
                    digit = true;
                    break;
                }
            }

            for (int i = 0; i < password.length(); i++) {
                Character c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    upper = true;
                    break;
                }
            }


            String setString = "!@#$%^&*";
            Set<Character> set = new HashSet<>();
            for (Character c : setString.toCharArray()) {
                set.add(c);
            }

            for (int i = 0; i < password.length(); i++) {
                Character c = password.charAt(i);
                if (set.contains(c)) {
                    special = true;
                    break;
                }
            }
        }


        int strength = 0;
        if (validLength) {
            strength++;
        }
        if (digit) {
            strength++;
        }
        if (upper) {
            strength++;
        }
        if (special) {
            strength++;
        }

        String strengthType = "";
        switch (strength) {
            case 4:
                strengthType = "Strong";
                break;
            case 3:
            case 2:
                strengthType = "Medium";
                break;
            default:
                strengthType = "Weak";
                break;
        }

        System.out.println("Length: " + (validLength ? "Pass" : "Fail") + " | Digit: " + (digit ? "Pass" : "Fail") + " | Uppercase: " + (upper ? "Pass" : "Fail") + " | Special Character: " + (special ? "Pass" : "Fail") + " -- Strength: " + strengthType);
    }

    public static void main(String[] args) {
        blacklistPassword("password");
        blacklistPassword("D3d1jekljlk1!");
    }
}
