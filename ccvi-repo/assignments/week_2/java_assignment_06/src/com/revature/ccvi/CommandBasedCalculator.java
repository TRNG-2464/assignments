package com.revature.ccvi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CommandBasedCalculator {

    private static int runningTotal = 0;

    // State variables for Stretch Goals
    private static final List<String> commandHistory = new ArrayList<>();
    private static final Stack<Integer> previousTotals = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter a command: ");
            if (!scanner.hasNextLine()) {
                break;
            }

            String line = scanner.nextLine().trim();
            
            // Route through the advanced processor to support History and Undo
            running = processAdvancedCommand(line);

            if (running) {
                System.out.println();
            }
        }

        scanner.close();
    }

    // =========================================================================
    // STRETCH GOAL IMPLEMENTATIONS
    // =========================================================================

    /**
     * Advanced processor that evaluates states for undo/history tracking
     * while utilizing the original calculation methods.
     */
    public static boolean processAdvancedCommand(String line) {
        if (line.isEmpty()) {
            return true;
        }

        String[] parts = line.split("\\s+", 2);
        String command = parts[0];
        
        boolean isValidCommand = false;
        boolean stateChanged = false;
        int previousTotalState = runningTotal;

        switch (command.toLowerCase()) {
            case "history" -> {
                printHistory();
                isValidCommand = true;
            }
            case "undo" -> {
                undoLastCommand();
                isValidCommand = true;
            }
            case "add", "subtract" -> {
                // Validate if this command will succeed before updating history/undo states
                if (parts.length >= 2) {
                    try {
                        Integer.parseInt(parts[1]);
                        isValidCommand = true;
                        stateChanged = true;
                    } catch (NumberFormatException _) {
                        // Handled natively by handleMathCommand
                    }
                }
                handleMathCommand(command.toLowerCase(), parts);
            }
            case "reset" -> {
                isValidCommand = true;
                stateChanged = true;
                runningTotal = 0;
                System.out.println("Running total has been reset to 0.");
            }
            case "total" -> {
                isValidCommand = true;
                System.out.println("Current total: " + runningTotal);
            }
            case "exit" -> {
                System.out.println("Goodbye! Final total: " + runningTotal);
                return false;
            }
            default -> System.out.println("Unrecognized command: '" + command + "'");
        }

        // Push to undo stack only if a mathematical change or reset occurred
        if (stateChanged) {
            previousTotals.push(previousTotalState);
        }
        
        // Add to history only if the command was recognized and valid
        if (isValidCommand) {
            commandHistory.add(line);
        }

        return true;
    }

    /**
     * Stretch Goal: Prints every valid command entered so far.
     */
    public static void printHistory() {
        if (commandHistory.isEmpty()) {
            System.out.println("Command history is empty.");
            return;
        }
        System.out.println("Command History:");
        for (int i = 0; i < commandHistory.size(); i++) {
            System.out.println((i + 1) + ". " + commandHistory.get(i));
        }
    }

    /**
     * Stretch Goal: Reverses the effect of the most recent add, subtract, or reset.
     */
    public static void undoLastCommand() {
        if (previousTotals.isEmpty()) {
            System.out.println("Nothing to undo.");
        } else {
            runningTotal = previousTotals.pop();
            System.out.println("Undo successful. Restored running total to: " + runningTotal);
            
            // We also remove the last state-changing command from history so it isn't tracked post-undo
            // (Optional behavior, but keeps the history clean)
            for (int i = commandHistory.size() - 1; i >= 0; i--) {
                String prevCmd = commandHistory.get(i).toLowerCase();
                if (prevCmd.startsWith("add") || prevCmd.startsWith("subtract") || prevCmd.equals("reset")) {
                    commandHistory.remove(i);
                    break;
                }
            }
        }
    }

    // =========================================================================
    // ORIGINAL METHODS
    // =========================================================================

    public static boolean processCommand(String line) {
        if (line.isEmpty()) {
            return true;
        }

        String[] parts = line.split("\\s+", 2);
        String command = parts[0];

        switch (command.toLowerCase()) {
            case "add" -> handleMathCommand("add", parts);
            case "subtract" -> handleMathCommand("subtract", parts);
            case "reset" -> {
                runningTotal = 0;
                System.out.println("Running total has been reset to 0.");
            }
            case "total" -> System.out.println("Current total: " + runningTotal);
            case "exit" -> {
                System.out.println("Goodbye! Final total: " + runningTotal);
                return false;
            }
            default -> System.out.println("Unrecognized command: '" + command + "'");
        }

        return true;
    }

    private static void handleMathCommand(String action, String[] parts) {
        if (parts.length < 2) {
            System.out.println("'" + action + "' requires a valid number. Please try again.");
            return;
        }

        try {
            int number = Integer.parseInt(parts[1]);
            if ("add".equalsIgnoreCase(action)) {
                runningTotal += number;
                System.out.println("Added " + number + ". Running total: " + runningTotal);
            } else if ("subtract".equalsIgnoreCase(action)) {
                runningTotal -= number;
                System.out.println("Subtracted " + number + ". Running total: " + runningTotal);
            }
        } catch (NumberFormatException _) {
            System.out.println("'" + action + "' requires a valid number. Please try again.");
        }
    }
}
