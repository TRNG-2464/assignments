import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter password: ");
        String password = sc.nextLine();

        checkPassword(password);

        //System.out.println();
        sc.close();
    }

    public static void checkPassword(String pw) {
        int strength = 0;

        if (pw.length() < 8) {
            System.out.print("\n[ Length: Fail ]");
        } else {
            System.out.print("\n[ Length: Pass ]");
            strength += 1;
        }

        if (!pw.chars().anyMatch(Character::isDigit)) {
            System.out.print("[ Digit: Fail ]");
        } else {
            System.out.print("[ Digit: Pass ]");
            strength += 1;
        }

        if (!pw.chars().anyMatch(Character::isUpperCase)) {
            System.out.print("[ Uppercase: Fail ]");
        } else {
            System.out.print("[ Uppercase: Pass ]");
            strength += 1;
        }

        if (!pw.matches(".*[!@#$%^&*].*")) {
            System.out.print("[ Special Character: Fail ]");
        } else {
            System.out.print("[ Special Character: Pass ]");
            strength += 1;
        }

        switch (strength) {
            case 0:
            case 1:
                System.out.print(" ----> Strength: Weak\n\n");
                break;
            case 2:
            case 3:
                System.out.print(" ----> Strength: Medium\n\n");
                break;
            case 4:
                System.out.print(" ----> Strength: Strong\n\n");
                break;
        
            default:
                // Should never get here
                break;
        }
    }
}
