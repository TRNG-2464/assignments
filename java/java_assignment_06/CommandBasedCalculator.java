import java.util.Scanner;

public class CommandBasedCalculator {
    public static void main(String[] args) {

        calculateCommand();

    }

    public static void calculateCommand() {
        int value = 0;
        boolean running = true; // change
        Scanner sc = new Scanner(System.in);

        while(running) {
            System.out.print("\nEnter a command: ");
            String op = sc.nextLine();
            String[] sepStrings = op.toLowerCase().trim().split(" ");
            int lenCheck = sepStrings.length;

            if ("add".equals(sepStrings[0])) {
                if (lenCheck == 1) {
                    System.err.println("Enter a number after 'add' command!");
                    continue;
                }
                try {
                    int newVal = Integer.parseInt(sepStrings[1]);
                    value += newVal;
                    System.out.println("Added '" + newVal + "'. Total value: " + value);
                } catch (NumberFormatException e) {
                    System.out.println(sepStrings[1] + " is not a valid number! Try again.");
                }
            } else if ("subtract".equals(sepStrings[0])) {
                if (lenCheck == 1) {
                    System.err.println("Enter a number after 'subtract' command!");
                    continue;
                }
                try {
                    int newVal = Integer.parseInt(sepStrings[1]);
                    value -= newVal;
                    System.out.println("Subtracted '" + newVal + "'. Total value: " + value);
                } catch (NumberFormatException e) {
                    System.out.println(sepStrings[1] + " is not a valid number! Try again.");
                }
            } else if ("reset".equals(sepStrings[0])) {
                System.out.println("Value has been reset to 0!");
                value = 0;
            }else if ("total".equals(sepStrings[0])) {
                System.out.println("Current total: " + value);
            }else if ("exit".equals(sepStrings[0])) {
                System.out.println("Final total: " + value + " Goodbye!\n");
                running = false;
            } else {
                System.out.println("Command '" + sepStrings[0] + "' not recognized! Try again.");
            }
        }

        sc.close();
    }
}
