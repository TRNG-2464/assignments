import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Order Processing System
 *
 * Demonstrates a custom exception hierarchy with two top-level exception
 * families (InventoryException, PaymentException), each with two specific
 * subclasses, and shows catching those exceptions at both a specific
 * subclass level and a broader parent-type level.
 */
public class OrderProcessingSystem {

    // ------------------------------------------------------------------
    // Exception hierarchy
    // ------------------------------------------------------------------

    /** Top-level exception for anything related to inventory/stock problems. */
    static class InventoryException extends Exception {
        public InventoryException(String message) {
            super(message);
        }
    }

    /** Top-level exception for anything related to payment problems. */
    static class PaymentException extends Exception {
        public PaymentException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when an order requests more of an item than is currently
     * available in stock. Carries the requested and available quantities
     * so callers can build a tailored message without re-parsing text.
     */
    static class OutOfStockException extends InventoryException {
        private final int requestedQuantity;
        private final int availableQuantity;

        public OutOfStockException(int requestedQuantity, int availableQuantity) {
            super("Out of stock. Requested " + requestedQuantity
                    + ", but only " + availableQuantity + " available.");
            this.requestedQuantity = requestedQuantity;
            this.availableQuantity = availableQuantity;
        }

        public int getRequestedQuantity() {
            return requestedQuantity;
        }

        public int getAvailableQuantity() {
            return availableQuantity;
        }
    }

    /** Thrown when an order requests a zero or negative quantity of an item. */
    static class InvalidQuantityException extends InventoryException {
        public InvalidQuantityException() {
            super("Invalid quantity. Quantity must be greater than 0.");
        }
    }

    /** Thrown when a simulated payment amount is less than the order's total cost. */
    static class PaymentDeclinedException extends PaymentException {
        public PaymentDeclinedException() {
            super("Payment declined. Insufficient funds.");
        }
    }

    /** Thrown when a simulated payment method is marked as expired. */
    static class PaymentExpiredException extends PaymentException {
        public PaymentExpiredException() {
            super("Payment method expired.");
        }
    }

    // ------------------------------------------------------------------
    // Core order processing
    // ------------------------------------------------------------------

    /**
     * Processes a single simulated order, validating inventory rules
     * before payment rules, and reports a confirmation on success.
     */
    static void processOrder(String item, int requestedQty, int availableStock,
                             double paymentAmount, double orderCost, boolean isExpired)
            throws InventoryException, PaymentException {

        // Inventory rules first
        if (requestedQty <= 0) {
            throw new InvalidQuantityException();
        }
        if (requestedQty > availableStock) {
            throw new OutOfStockException(requestedQty, availableStock);
        }

        // Payment rules second
        if (isExpired) {
            throw new PaymentExpiredException();
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException();
        }

        System.out.println("Order successful! " + requestedQty + " x " + item + " confirmed.");
    }

    // ------------------------------------------------------------------
    // Driving code
    // ------------------------------------------------------------------

    public static void main(String[] args) {

        System.out.println("=== Individual Order Demonstrations ===\n");

        // 1) Out of stock -> caught by SPECIFIC subclass catch, using custom fields
        try {
            processOrder("Widget", 5, 2, 50.00, 50.00, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: Out of stock. Requested "
                    + e.getRequestedQuantity() + ", but only "
                    + e.getAvailableQuantity() + " available.");
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            throw new RuntimeException(e);
        }

        // 2) Invalid quantity -> caught by the broader PARENT catch (InventoryException)
        try {
            processOrder("Widget", -1, 10, 50.00, 50.00, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: Out of stock. Requested "
                    + e.getRequestedQuantity() + ", but only "
                    + e.getAvailableQuantity() + " available.");
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            throw new RuntimeException(e);
        }

        // 3) Payment declined -> caught by SPECIFIC subclass catch
        try {
            processOrder("Widget", 2, 10, 10.00, 50.00, false);
        } catch (PaymentDeclinedException e) {
            System.out.println("Order failed: " + e.getMessage()
                    + " (Please use a different payment method.)");
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e) {
            throw new RuntimeException(e);
        }

        // 4) Payment expired -> caught by the broader PARENT catch (PaymentException)
        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, true);
        } catch (PaymentDeclinedException e) {
            System.out.println("Order failed: " + e.getMessage()
                    + " (Please use a different payment method.)");
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e) {
            throw new RuntimeException(e);
        }

        // 5) Successful order
        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, false);
        } catch (InventoryException | PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // ------------------------------------------------------------------
        // Stretch Goal: Batch Order Processing with a Summary Report
        // ------------------------------------------------------------------
        System.out.println("\n=== Batch Order Processing ===\n");

        List<Order> batch = new ArrayList<>();
        batch.add(new Order("Widget", 5, 2, 50.00, 50.00, false));   // OutOfStockException
        batch.add(new Order("Gadget", -1, 10, 50.00, 50.00, false)); // InvalidQuantityException
        batch.add(new Order("Gizmo", 2, 10, 10.00, 50.00, false));   // PaymentDeclinedException
        batch.add(new Order("Doohickey", 2, 10, 50.00, 50.00, true));// PaymentExpiredException
        batch.add(new Order("Widget", 3, 10, 75.00, 75.00, false));  // Success
        batch.add(new Order("Gadget", 1, 5, 20.00, 20.00, false));   // Success

        processBatch(batch);
    }

    // ------------------------------------------------------------------
    // Stretch Goal helper types/methods
    // ------------------------------------------------------------------

    /** Simple data holder representing one simulated order's inputs. */
    static class Order {
        final String item;
        final int requestedQty;
        final int availableStock;
        final double paymentAmount;
        final double orderCost;
        final boolean isExpired;

        Order(String item, int requestedQty, int availableStock,
              double paymentAmount, double orderCost, boolean isExpired) {
            this.item = item;
            this.requestedQty = requestedQty;
            this.availableStock = availableStock;
            this.paymentAmount = paymentAmount;
            this.orderCost = orderCost;
            this.isExpired = isExpired;
        }
    }

    /**
     * Processes a batch of orders one at a time, continuing past failures,
     * then prints a summary report of successes/failures broken down by
     * exception type. Does not modify or reuse processOrder's own try/catch
     * logic from main — this is a separate, self-contained method.
     */
    static void processBatch(List<Order> orders) {
        int successCount = 0;
        int failureCount = 0;
        Map<String, Integer> failuresByType = new LinkedHashMap<>();

        for (Order o : orders) {
            try {
                processOrder(o.item, o.requestedQty, o.availableStock,
                        o.paymentAmount, o.orderCost, o.isExpired);
                successCount++;
            } catch (InventoryException | PaymentException e) {
                failureCount++;
                String type = e.getClass().getSimpleName();
                failuresByType.merge(type, 1, Integer::sum);
                System.out.println("Order failed (" + type + "): " + e.getMessage());
            }
        }

        System.out.println("\n--- Batch Summary ---");
        System.out.println("Total orders processed: " + orders.size());
        System.out.println("Succeeded: " + successCount);
        System.out.println("Failed: " + failureCount);
        System.out.println("Failure breakdown:");
        if (failuresByType.isEmpty()) {
            System.out.println("  (no failures)");
        } else {
            for (Map.Entry<String, Integer> entry : failuresByType.entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
