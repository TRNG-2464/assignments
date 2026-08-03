import java.util.Scanner;

public class CommandCalculator {
    // Running total for the calculator
    static int total = 0;
    // Handles one command from the user
    public static void handleCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0].toLowerCase();

        switch (command) {
            case "add":
                if (parts.length < 2) {
                    System.out.println("'add' requires a valid number. Please try again.");
                    break;
                }
                try {
                    int number = Integer.parseInt(parts[1]);
                    total += number;
                    System.out.println("Added " + number + ". Running total: " + total);
                } catch (NumberFormatException e) {
                    System.out.println("'add' requires a valid number. Please try again.");
                }
                break;
            case "subtract":
                if (parts.length < 2) {
                    System.out.println("'subtract' requires a valid number. Please try again.");
                    break;
                }
                try {
                    int number = Integer.parseInt(parts[1]);
                    total -= number;
                    System.out.println("Subtracted " + number + ". Running total: " + total);
                } catch (NumberFormatException e) {
                    System.out.println("'subtract' requires a valid number. Please try again.");
                }
                break;
            case "reset":
                total = 0;
                System.out.println("Running total has been reset to 0.");
                break;
            case "total":
                System.out.println("Current total: " + total);
                break;
            default:
                System.out.println("Unrecognized command: '" + command + "'");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! Final total: " + total);
                break;
            }
            handleCommand(input);
        }
        scanner.close();
    }
}