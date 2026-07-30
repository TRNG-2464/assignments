import java.util.*;

public class CommandBasedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int runningValue = 0; // Starts at 0 as requested

        while (true) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! Final running value: " + runningValue);
                break;
            }

            String[] parts = input.split("\\s+");

            if (parts.length == 0 || parts[0].isEmpty()) {
                continue;
            }

            String command = parts[0].toLowerCase();

            if (command.equals("total")) {
                System.out.println("Current total: " + runningValue);
                continue;
            }

            if (command.equals("reset")) {
                runningValue = 0;
                System.out.println("Running total has been reset to 0.");
                continue;
            }

            if (command.equals("add") || command.equals("subtract")) {
                // Check if the number argument is missing completely
                if (parts.length < 2) {
                    System.out.println("'" + command + "' requires a valid number. Please try again.");
                    continue;
                }

                String numberStr = parts[1];
                int number = 0;

                try {
                    number = Integer.parseInt(numberStr);
                } catch (NumberFormatException e) {
                    System.out.println("'" + command + "' requires a valid number. Please try again.");
                    continue;
                }

                if (command.equals("add")) {
                    runningValue += number;
                    System.out.println("Added " + number + ". Running total: " + runningValue);
                } else {
                    runningValue -= number;
                    System.out.println("Subtracted " + number + ". Running total: " + runningValue);
                }

            } else {
                System.out.println("Unrecognized command: '" + parts[0] + "'");
            }
        }

        scanner.close();
    }

    public static void runCalculatorWithHistory() {
        Scanner scanner = new Scanner(System.in);
        int runningValue = 0;

        // List to store successful operational inputs
        List<String> commandHistory = new ArrayList<>();

        while (true) {
            System.out.print("Enter a command (or 'history'): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! Final running value: " + runningValue);
                break;
            }

            String[] parts = input.split("\\s+");
            if (parts.length == 0 || parts[0].isEmpty()) {
                continue;
            }

            String command = parts[0].toLowerCase();

            // Unique behavior extension for this specific method
            if (command.equals("history")) {
                System.out.println("\n--- Command History Log ---");
                if (commandHistory.isEmpty()) {
                    System.out.println("(No operations recorded yet)");
                } else {
                    for (int i = 0; i < commandHistory.size(); i++) {
                        System.out.println((i + 1) + ". " + commandHistory.get(i));
                    }
                }
                continue;
            }

            if (command.equals("total")) {
                System.out.println("Current total: " + runningValue);
                commandHistory.add("Checked total (Value: " + runningValue + ")");
                continue;
            }

            if (command.equals("reset")) {
                runningValue = 0;
                System.out.println("Running total has been reset to 0.");
                commandHistory.add("Reset running total back to 0");
                continue;
            }

            if (command.equals("add") || command.equals("subtract")) {
                if (parts.length < 2) {
                    System.out.println("'" + command + "' requires a valid number. Please try again.");
                    continue;
                }

                String numberStr = parts[1];
                int number = 0;

                try {
                    number = Integer.parseInt(numberStr);
                } catch (NumberFormatException e) {
                    System.out.println("'" + command + "' requires a valid number. Please try again.");
                    continue;
                }

                if (command.equals("add")) {
                    runningValue += number;
                    System.out.println("Added " + number + ". Running total: " + runningValue);
                    commandHistory.add("Added " + number + " (Running total: " + runningValue + ")");
                } else {
                    runningValue -= number;
                    System.out.println("Subtracted " + number + ". Running total: " + runningValue);
                    commandHistory.add("Subtracted " + number + " (Running total: " + runningValue + ")");
                }
            } else {
                System.out.println("Unrecognized command: '" + parts[0] + "'");
            }
        }
    }
    public static void runCalculatorWithUndo() {
        Scanner scanner = new Scanner(System.in);
        int runningValue = 0;

        // Stack to store older integer states before they get modified
        Deque<Integer> valueHistoryStack = new ArrayDeque<>();

        while (true) {
            System.out.print("Enter a command (or 'undo'): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! Final running value: " + runningValue);
                break;
            }

            String[] parts = input.split("\\s+");
            if (parts.length == 0 || parts[0].isEmpty()) {
                continue;
            }

            String command = parts[0].toLowerCase();

            // Unique behavior extension for this specific method
            if (command.equals("undo")) {
                if (valueHistoryStack.isEmpty()) {
                    System.out.println("Nothing to undo.");
                } else {
                    // Pop the last saved state off the stack and restore it
                    int previousValue = valueHistoryStack.pop();
                    System.out.println("Undid last action. Value changed from " + runningValue + " back to " + previousValue + ".");
                    runningValue = previousValue;
                }
                continue;
            }

            if (command.equals("total")) {
                System.out.println("Current total: " + runningValue);
                // "total" doesn't change the value, so we do NOT save to the stack
                continue;
            }

            if (command.equals("reset")) {
                // Save current state to stack BEFORE updating it
                valueHistoryStack.push(runningValue);

                runningValue = 0;
                System.out.println("Running total has been reset to 0.");
                continue;
            }

            if (command.equals("add") || command.equals("subtract")) {
                if (parts.length < 2) {
                    System.out.println("'" + command + "' requires a valid number. Please try again.");
                    continue;
                }

                String numberStr = parts[1];
                int number = 0;

                try {
                    number = Integer.parseInt(numberStr);
                } catch (NumberFormatException e) {
                    System.out.println("'" + command + "' requires a valid number. Please try again.");
                    continue;
                }

                // Save current state to stack BEFORE updating it
                valueHistoryStack.push(runningValue);

                if (command.equals("add")) {
                    runningValue += number;
                    System.out.println("Added " + number + ". Running total: " + runningValue);
                } else {
                    runningValue -= number;
                    System.out.println("Subtracted " + number + ". Running total: " + runningValue);
                }
            } else {
                System.out.println("Unrecognized command: '" + parts[0] + "'");
            }
        }
        scanner.close();
    }
}
