import java.util.Scanner;

public class CommandBasedCalculator {

    // Handles one command and returns the updated running total
    public static int handleCommand(String input, int runningTotal) {

        // Remove extra spaces from the beginning and end
        input = input.trim();

        // Ignore a blank command
        if (input.isEmpty()) {
            System.out.println(
                    "No command entered. Please try again."
            );

            return runningTotal;
        }

        // Split the input into the command and its argument
        String[] parts = input.split("\\s+");

        // Convert the command to lowercase
        String command = parts[0].toLowerCase();

        switch (command) {

            case "add":

                // Make sure a number was provided
                if (parts.length < 2) {
                    System.out.println(
                            "'add' requires a valid number. "
                                    + "Please try again."
                    );

                    return runningTotal;
                }

                try {
                    int numberToAdd = Integer.parseInt(parts[1]);

                    runningTotal += numberToAdd;

                    System.out.println(
                            "Added " + numberToAdd
                                    + ". Running total: "
                                    + runningTotal
                    );

                } catch (NumberFormatException exception) {

                    System.out.println(
                            "'add' requires a valid number. "
                                    + "Please try again."
                    );
                }

                break;


            case "subtract":

                // Make sure a number was provided
                if (parts.length < 2) {
                    System.out.println(
                            "'subtract' requires a valid number. "
                                    + "Please try again."
                    );

                    return runningTotal;
                }

                try {
                    int numberToSubtract =
                            Integer.parseInt(parts[1]);

                    runningTotal -= numberToSubtract;

                    System.out.println(
                            "Subtracted " + numberToSubtract
                                    + ". Running total: "
                                    + runningTotal
                    );

                } catch (NumberFormatException exception) {

                    System.out.println(
                            "'subtract' requires a valid number. "
                                    + "Please try again."
                    );
                }

                break;


            case "reset":

                runningTotal = 0;

                System.out.println(
                        "Running total has been reset to 0."
                );

                break;


            case "total":

                System.out.println(
                        "Current total: " + runningTotal
                );

                break;


            default:

                System.out.println(
                        "Unrecognized command: '"
                                + parts[0] + "'"
                );
        }

        // Return the current or updated total
        return runningTotal;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // The running value starts at 0
        int runningTotal = 0;

        System.out.println(
                "Command-Based Calculator"
        );

        System.out.println(
                "Commands: add [number], "
                        + "subtract [number], "
                        + "reset, total, exit"
        );

        // Continue until the user enters exit
        while (true) {

            System.out.print("\nEnter a command: ");

            String input = scanner.nextLine();

            // Check for exit before calling handleCommand()
            if (input.trim().equalsIgnoreCase("exit")) {

                System.out.println(
                        "Goodbye! Final total: "
                                + runningTotal
                );

                break;
            }

            // Process the command and save the updated total
            runningTotal =
                    handleCommand(input, runningTotal);
        }

        scanner.close();
    }
}