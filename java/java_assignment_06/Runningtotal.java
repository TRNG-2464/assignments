import java.util.Scanner;
 
public class RunningTotal {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int runningTotal = 0;
        boolean running = true;
 
        while (running) {
            System.out.print("Enter a command: ");
            String line = scanner.nextLine();
 
            CommandResult result = handleCommand(line, runningTotal);
            System.out.println(result.message);
            runningTotal = result.updatedTotal;
 
            if (result.shouldExit) {
                running = false;
            }
        }
 
        scanner.close();
    }

    private static CommandResult handleCommand(String line, int currentTotal) {
        String trimmed = line.trim();
        String[] parts = trimmed.split("\\s+", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : null;
 
        switch (command) {
            case "add": {
                Integer number = parseNumber(argument);
                if (number == null) {
                    return new CommandResult(
                            "'add' requires a valid number. Please try again.",
                            currentTotal, false);
                }
                int updated = currentTotal + number;
                return new CommandResult(
                        "Added " + number + ". Running total: " + updated,
                        updated, false);
            }
 
            case "subtract": {
                Integer number = parseNumber(argument);
                if (number == null) {
                    return new CommandResult(
                            "'subtract' requires a valid number. Please try again.",
                            currentTotal, false);
                }
                int updated = currentTotal - number;
                return new CommandResult(
                        "Subtracted " + number + ". Running total: " + updated,
                        updated, false);
            }
 
            case "reset":
                return new CommandResult(
                        "Running total has been reset to 0.", 0, false);
 
            case "total":
                return new CommandResult(
                        "Current total: " + currentTotal, currentTotal, false);
 
            case "exit":
                return new CommandResult(
                        "Goodbye! Final total: " + currentTotal, currentTotal, true);
 
            default:
                return new CommandResult(
                        "Unrecognized command: '" + command + "'", currentTotal, false);
        }
    }
 
    private static Integer parseNumber(String argument) {
        if (argument == null || argument.isBlank()) {
            return null;
        }
        try {
            return Integer.parseInt(argument.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
 
    private static class CommandResult {
        final String message;
        final int updatedTotal;
        final boolean shouldExit;
 
        CommandResult(String message, int updatedTotal, boolean shouldExit) {
            this.message = message;
            this.updatedTotal = updatedTotal;
            this.shouldExit = shouldExit;
        }
    }
}