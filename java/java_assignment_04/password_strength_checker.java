import java.util.Scanner;

public class password_strength_checker {

	public static void main(String[] args) {

		password_strength_checker checker = new password_strength_checker();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a password: ");
		String password = sc.nextLine();

		System.out.println(checker.checkPasswordStrength(password));
		sc.close();
	}

	public String checkPasswordStrength(String password) {

		int passStrength = 0;
		boolean passLength = (password.length() >= 8);
		boolean hasUppercase = !password.equals(password.toLowerCase());
		// regex expression: Checks for a digit (\\d) with anything preceding or following it (.*)
		// functions similar to %LIKE expressions in sql
		boolean hasDigit = password.matches(".*\\d.*");
		//regex expression: Checks for a special character with anything preceding or following it
		// specifically checks for characters in the set [!@#$%^&*]
		boolean hasSpecialChar = password.matches(".*[!@#$%^&*].*");

		if (passLength) {
			passStrength++;
		}

		if (hasUppercase) {
			passStrength++;
		}

		if (hasDigit) {
			passStrength++;
		}

		if (hasSpecialChar) {
			passStrength++;
		}

		switch (passStrength) {
			case 0:
				return "Password strength is weak";
			case 1:
				return "Password strength is weak";
			case 2:
				return "Password strength is medium";
			case 3:
				return "Password strength is medium";
			case 4:
				return "Password strength is strong";
			default:
				return "Password strength is weak";
		}
	}
}
