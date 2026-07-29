public class PasswordStrengthCheckerDriver {
    public static void main(String[] args) {
        PasswordStrengthChecker p = new PasswordStrengthChecker();
        System.out.println(p.checkPasswordStrength("password"));
        System.out.println(p.checkPasswordStrength("Password1"));
        System.out.println(p.checkPasswordStrength("P@ssw0rd"));
        System.out.println(p.checkPasswordStrength(""));

        System.out.println(p.checkPasswordStrengthCustomRule("Password1"));
        System.out.println(p.checkCommonPassword("password123"));
    }
}
