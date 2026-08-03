package com.revature.ccvi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineChangeMaker {

    /*
     * Record representing the breakdown of change into bill and coin denominations.
     */
    public record DenominationBreakdown(int dollars, int quarters, int dimes, int nickels, int pennies) {
        @Override
        public String toString() {
            return """
                   Change Breakdown ($1.00, $0.25, $0.10, $0.05, $0.01):
                     - Dollars ($1.00):  %d
                     - Quarters ($0.25): %d
                     - Dimes ($0.10):    %d
                     - Nickels ($0.05):  %d
                     - Pennies ($0.01):  %d"""
                   .formatted(dollars, quarters, dimes, nickels, pennies);
        }
    }

    /*
     * Core Requirement: Evaluates a single item price and amount inserted.
     */
    public static String processTransaction(double price, double amountInserted) {
        if (price < 0) {
            return "Invalid input: item price cannot be negative.";
        }
        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        if (amountInserted < price) {
            double needed = price - amountInserted;
            return "Insufficient funds. Please insert $%.2f more.".formatted(needed);
        }

        double change = amountInserted - price;
        return "Purchase successful. Change due: $%.2f".formatted(change);
    }

    /*
     * Stretch Goal 1: Running Total for Multiple Items
     */
    public static String processMultipleItems(List<Double> itemPrices, double amountInserted) {
        if (itemPrices == null || itemPrices.isEmpty()) {
            return "Invalid input: price list cannot be empty.";
        }
        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        double total = 0.0;
        for (double price : itemPrices) {
            if (price < 0) {
                return "Invalid input: item price cannot be negative.";
            }
            total += price;
        }

        return processTransaction(total, amountInserted);
    }

    /*
     * Stretch Goal 2: Making Change in Denominations
     */
    public static String makeChangeInDenominations(double changeOwed) {
        if (changeOwed < 0) {
            return "Invalid input: change amount cannot be negative.";
        }

        long cents = Math.round(changeOwed * 100);

        int dollars = (int) (cents / 100);
        cents %= 100;

        int quarters = (int) (cents / 25);
        cents %= 25;

        int dimes = (int) (cents / 10);
        cents %= 10;

        int nickels = (int) (cents / 5);
        cents %= 5;

        int pennies = (int) cents;

        var breakdown = new DenominationBreakdown(dollars, quarters, dimes, nickels, pennies);
        return breakdown.toString();
    }

    /* 
     * ==========================================
     *  INTERACTIVE MENU
     * ==========================================
	 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Welcome to the Vending Machine Change Maker ===");

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Single Item Transaction (Core)");
            System.out.println("2. Multiple Items Transaction (Stretch Goal 1)");
            System.out.println("3. Make Change in Denominations (Stretch Goal 2)");
            System.out.println("4. Quit");
            System.out.print("Select an option (1-4): ");

            String choice = scanner.next();
            
            switch (choice) {
                case "1" -> handleSingleItem(scanner);
                case "2" -> handleMultipleItems(scanner);
                case "3" -> handleDenominations(scanner);
                case "4", "q", "quit" -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void handleSingleItem(Scanner scanner) {
        System.out.println("\n--- Single Item Transaction ---");
        try {
            System.out.print("Enter item price: ");
            double price = Double.parseDouble(scanner.next());

            System.out.print("Enter amount inserted: ");
            double amountInserted = Double.parseDouble(scanner.next());

            System.out.println("\nInput: price = " + String.format("%.2f", price) + ", amountInserted = " + String.format("%.2f", amountInserted));
            String result = processTransaction(price, amountInserted);
            System.out.println("Output: \"" + result + "\"");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers.");
        }
    }

    private static void handleMultipleItems(Scanner scanner) {
        System.out.println("\n--- Multiple Items Transaction ---");
        List<Double> items = new ArrayList<>();
        System.out.println("Enter item prices one by one. Type 'd' when done.");

        while (true) {
            System.out.print("Enter price for item " + (items.size() + 1) + " (or 'd' to finish): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("d")) {
                break;
            }

            try {
                double price = Double.parseDouble(input);
                items.add(price);
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number or 'd' to finish.");
            }
        }

        if (items.isEmpty()) {
            System.out.println("No items entered. Canceling transaction.");
            return;
        }

        try {
            System.out.print("Enter total amount inserted: ");
            double amountInserted = Double.parseDouble(scanner.next());

            double totalCost = items.stream().mapToDouble(Double::doubleValue).sum();
            
            System.out.println("\nInput: items total = " + String.format("%.2f", totalCost) + ", amountInserted = " + String.format("%.2f", amountInserted));
            String result = processMultipleItems(items, amountInserted);
            System.out.println("Output: \"" + result + "\"");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers.");
        }
    }

    private static void handleDenominations(Scanner scanner) {
        System.out.println("\n--- Denomination Breakdown ---");
        try {
            System.out.print("Enter the change amount owed (e.g., 3.68): ");
            double change = Double.parseDouble(scanner.next());

            System.out.println("\n" + makeChangeInDenominations(change));

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers.");
        }
    }
}
