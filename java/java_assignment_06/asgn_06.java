import java.util.Scanner;

public class asgn_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;

        while (true) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine();
            Integer result = calculator(input, total);
            if (result == null) {
                System.out.println("Goodbye! Final total: " + total);
                break;
            }
            total = result;
        }
        scanner.close(); // technically not necessary but the ide is complaining with a yellow underline w/o this
    }

    public static Integer calculator(String input, int currentTotal) {
        
        if (input.isEmpty()) {
            System.out.println("Unrecognized command: ''");
            return currentTotal;
        }

        String[] parts = input.split("\\s+");
        String command = parts[0].toLowerCase();

        switch (command) {
            case "exit":
                return null;
            case "add":
                if (parts.length < 2 || !isValidInt(parts[1])) {
                    System.out.println("'add' requires a valid number. Please try again.");
                    return currentTotal;
                }
                int addAmount = Integer.parseInt(parts[1]);
                int afterAdd = currentTotal + addAmount;
                System.out.println("Added " + addAmount + ". Running total: " + afterAdd);
                return afterAdd;

            case "subtract":
                if (parts.length < 2 || !isValidInt(parts[1])) {
                    System.out.println("'subtract' requires a valid number. Please try again.");
                    return currentTotal;
                }
                int subAmount = Integer.parseInt(parts[1]);
                int afterSub = currentTotal - subAmount;
                System.out.println("Subtracted " + subAmount + ". Running total: " + afterSub);
                return afterSub;

            case "reset":
                System.out.println("Running total has been reset to 0.");
                return 0;

            case "total":
                System.out.println("Current total: " + currentTotal);
                return currentTotal;
                
            default:
                System.out.println("Unrecognized command: '" + parts[0] + "'");
                return currentTotal;
        }
    }

    public static boolean isValidInt(String s) { // probably better practice to make this private
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
