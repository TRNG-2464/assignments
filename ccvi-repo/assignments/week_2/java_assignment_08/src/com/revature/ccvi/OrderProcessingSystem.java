package com.revature.ccvi;

import java.util.List;
import java.util.Scanner;

// 1. Define Top-Level Custom Exceptions
class InventoryException extends Exception {
    public InventoryException(String message) { super(message); }
}

class PaymentException extends Exception {
    public PaymentException(String message) { super(message); }
}

// 2. Define Subclasses (Includes Stretch Goal: Custom Fields on OutOfStockException)
class OutOfStockException extends InventoryException {
    private final int requested;
    private final int available;
    
    public OutOfStockException(String message, int requested, int available) {
        super(message);
        this.requested = requested;
        this.available = available;
    }
    
    public int getRequested() { return requested; }
    public int getAvailable() { return available; }
}

class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException(String message) { super(message); }
}

class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException(String message) { super(message); }
}

class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException(String message) { super(message); }
}

// Record to represent a simulated order for batch processing
record OrderRecord(String item, int requestedQty, int availableStock, double paymentAmount, double orderCost, boolean isExpired) {}

public class OrderProcessingSystem {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("=== Order Processing System Menu ===");
            System.out.println("1. Process a Single Interactive Order");
            System.out.println("2. Run Batch Order Processing (Stretch Goal)");
            System.out.println("Type 'exit' to quit.");
            System.out.print("Select an option (1, 2, or exit): ");
            
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }
            
            if (choice.equals("1")) {
                runInteractiveOrder(scanner);
            } else if (choice.equals("2")) {
                runBatchDemo();
            } else {
                System.out.println("Invalid option. Please try again.\n");
            }
        }
        scanner.close();
    }

    // Original single-order interactive flow
    static void runInteractiveOrder(Scanner scanner) {
        System.out.println("\n--- Interactive Order Processing ---");
        System.out.println("Type 'exit' at any prompt to return to the main menu.\n");
        
        // Prompt for item name
        System.out.print("Enter item name: ");
        String item = scanner.nextLine().trim();
        if (item.equalsIgnoreCase("exit")) return;
        
        // Prompt for requested quantity
        int requestedQty;
        try {
            System.out.print("Enter requested quantity: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) return;
            requestedQty = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer for quantity.\n");
            return;
        }
        
        // Prompt for available stock
        int availableStock;
        try {
            System.out.print("Enter available stock: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) return;
            availableStock = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer for stock.\n");
            return;
        }
        
        // Prompt for payment amount
        double paymentAmount;
        try {
            System.out.print("Enter payment amount ($): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) return;
            paymentAmount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number for payment amount.\n");
            return;
        }
        
        // Prompt for order total cost
        double orderCost;
        try {
            System.out.print("Enter order total cost ($): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) return;
            orderCost = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number for order cost.\n");
            return;
        }
        
        // Prompt for payment expiration status
        System.out.print("Is payment method expired? (true/false): ");
        String inputExp = scanner.nextLine().trim();
        if (inputExp.equalsIgnoreCase("exit")) return;
        boolean isExpired = Boolean.parseBoolean(inputExp);
        
        System.out.println("\nInput: item = \"" + item + "\", requestedQty = " + requestedQty + 
                           ", availableStock = " + availableStock + ", paymentAmount = " + 
                           String.format("%.2f", paymentAmount) + ", orderCost = " + 
                           String.format("%.2f", orderCost) + ", isExpired = " + isExpired);
        
        System.out.print("Output: ");
        executeOrderHandling(item, requestedQty, availableStock, paymentAmount, orderCost, isExpired);
        System.out.println("\n----------------------------------------\n");
    }

    // Original core order validation method
    static void processOrder(String item, int requestedQty, int availableStock, double paymentAmount, double orderCost, boolean isExpired) 
            throws InventoryException, PaymentException {
        
        // Validate inventory-related rules first
        if (requestedQty <= 0) {
            throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0.");
        }
        if (requestedQty > availableStock) {
            // Utilizing custom exception fields (Stretch Goal)
            throw new OutOfStockException("Out of stock.", requestedQty, availableStock);
        }
        
        // Validate payment-related rules next
        if (isExpired) {
            throw new PaymentExpiredException("Payment method expired.");
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException("Payment declined. Insufficient funds.");
        }
        
        // Report a successful order confirmation
        System.out.println("\"Order successful! " + requestedQty + " x " + item + " confirmed.\"");
    }

    // Helper block containing specific/broad exception hierarchy catches
    static void executeOrderHandling(String item, int requestedQty, int availableStock, double paymentAmount, double orderCost, boolean isExpired) {
        try {
            processOrder(item, requestedQty, availableStock, paymentAmount, orderCost, isExpired);
        } catch (OutOfStockException e) {
            // Tailored handling using custom exception fields (Stretch Goal)
            System.out.println("\"Order failed: " + e.getMessage() + " Requested " + e.getRequested() + ", but only " + e.getAvailable() + " available.\"");
        } catch (InventoryException e) {
            System.out.println("\"Order failed: " + e.getMessage() + "\"");
        } catch (PaymentException e) {
            System.out.println("\"Order failed: " + e.getMessage() + "\"");
        }
    }

    // STRETCH GOAL: Batch Order Processing with a Summary Report
    static void runBatchDemo() {
        System.out.println("\n--- Running Batch Order Processing Stretch Goal ---");
        
        // Build a list simulating multiple order outcomes (all exception types + successes)
        List<OrderRecord> batchOrders = List.of(
            new OrderRecord("Widget", 5, 2, 50.00, 50.00, false),   // Out of stock
            new OrderRecord("Widget", -1, 10, 50.00, 50.00, false),  // Invalid quantity
            new OrderRecord("Widget", 2, 10, 10.00, 50.00, false),   // Payment declined
            new OrderRecord("Widget", 2, 10, 50.00, 50.00, true),    // Payment expired
            new OrderRecord("Widget", 2, 10, 50.00, 50.00, false),   // Successful order
            new OrderRecord("Gadget", 1, 5, 100.00, 100.00, false)   // Successful order 2
        );

        int successes = 0;
        int failures = 0;
        int outOfStockCount = 0;
        int invalidQtyCount = 0;
        int paymentDeclinedCount = 0;
        int paymentExpiredCount = 0;

        int index = 1;
        for (OrderRecord order : batchOrders) {
            System.out.println("Processing Batch Item #" + index++ + " (" + order.item() + ")...");
            try {
                processOrder(order.item(), order.requestedQty(), order.availableStock(), 
                             order.paymentAmount(), order.orderCost(), order.isExpired());
                successes++;
            } catch (OutOfStockException e) {
                failures++;
                outOfStockCount++;
                System.out.println("-> Handled: Out of stock (Requested: " + e.getRequested() + ", Available: " + e.getAvailable() + ")");
            } catch (InvalidQuantityException e) {
                failures++;
                invalidQtyCount++;
                System.out.println("-> Handled: " + e.getMessage());
            } catch (PaymentDeclinedException e) {
                failures++;
                paymentDeclinedCount++;
                System.out.println("-> Handled: " + e.getMessage());
            } catch (PaymentExpiredException e) {
                failures++;
                paymentExpiredCount++;
                System.out.println("-> Handled: " + e.getMessage());
            } catch (InventoryException | PaymentException e) {
                failures++;
                System.out.println("-> Handled general error: " + e.getMessage());
            }
        }

        // Print Final Summary Report
        System.out.println("\n========== BATCH SUMMARY REPORT ==========");
        System.out.println("Total Orders Processed : " + batchOrders.size());
        System.out.println("Successful Orders      : " + successes);
        System.out.println("Failed Orders          : " + failures);
        System.out.println("\nFailure Breakdown by Type:");
        System.out.println(" - OutOfStockException     : " + outOfStockCount);
        System.out.println(" - InvalidQuantityException: " + invalidQtyCount);
        System.out.println(" - PaymentDeclinedException: " + paymentDeclinedCount);
        System.out.println(" - PaymentExpiredException : " + paymentExpiredCount);
        System.out.println("==========================================\n");
    }
}
