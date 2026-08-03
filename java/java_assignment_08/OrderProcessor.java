import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderProcessor {

    public String processOrder(String item, int requestedQuantity, int availableStock, double paymentAmount, double orderCost, boolean isExpired) throws InventoryException, PaymentException {
        if (requestedQuantity <= 0) {
            throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0.");
        }

        if (requestedQuantity > availableStock) {
            throw new OutOfStockException(
                    "Out of stock. Requested " + requestedQuantity + ", but only " + availableStock + " available."
            );
        }

        if (isExpired) {
            throw new PaymentExpiredException("Payment method expired.");
        }

        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException("Payment declined. Insufficient funds.");
        }

        return "Order successful! " + requestedQuantity + " x " + item + " confirmed.";
    }

    // Stretch Goal 1: identical to processOrder, but throws OutOfStockException
    // with the requested/available quantities attached so callers can build a
    // tailored message from the exception's fields instead of just its message.
    public String processOrderWithCustomFields(String item, int requestedQuantity, int availableStock, double paymentAmount, double orderCost, boolean isExpired) throws InventoryException, PaymentException {
        if (requestedQuantity <= 0) {
            throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0.");
        }

        if (requestedQuantity > availableStock) {
            throw new OutOfStockException(
                    "Out of stock. Requested " + requestedQuantity + ", but only " + availableStock + " available.",
                    requestedQuantity,
                    availableStock
            );
        }

        if (isExpired) {
            throw new PaymentExpiredException("Payment method expired.");
        }

        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException("Payment declined. Insufficient funds.");
        }

        return "Order successful! " + requestedQuantity + " x " + item + " confirmed.";
    }

    // Stretch Goal 2: process a batch of orders, continuing on failure, and
    // report a summary at the end.
    public void processOrders(List<OrderRequest> orders) {
        int successCount = 0;
        int failureCount = 0;
        Map<String, Integer> failuresByType = new LinkedHashMap<>();

        for (OrderRequest order : orders) {
            try {
                String result = processOrder(
                        order.getItem(),
                        order.getRequestedQuantity(),
                        order.getAvailableStock(),
                        order.getPaymentAmount(),
                        order.getOrderCost(),
                        order.isExpired()
                );
                System.out.println(result);
                successCount++;
            } catch (InventoryException | PaymentException e) {
                System.out.println("Order failed: " + e.getMessage());
                failureCount++;
                String type = e.getClass().getSimpleName();
                failuresByType.put(type, failuresByType.getOrDefault(type, 0) + 1);
            }
        }

        System.out.println("\nBatch summary: " + successCount + " succeeded, " + failureCount + " failed.");
        for (Map.Entry<String, Integer> failure : failuresByType.entrySet()) {
            System.out.println("  " + failure.getKey() + ": " + failure.getValue());
        }
    }

    private static void testOrder(OrderProcessor orderProcessor, String item, int requestedQuantity, int availableStock, double paymentAmount, double orderCost, boolean isExpired) {
        try {
            System.out.println(orderProcessor.processOrder(item, requestedQuantity, availableStock, paymentAmount, orderCost, isExpired));
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        System.out.println("Base requirements:");
        testOrder(orderProcessor, "Widget", 5, 2, 50.00, 50.00, false);
        testOrder(orderProcessor, "Widget", -1, 10, 50.00, 50.00, false);
        testOrder(orderProcessor, "Widget", 2, 10, 10.00, 50.00, false);
        testOrder(orderProcessor, "Widget", 2, 10, 50.00, 50.00, true);
        testOrder(orderProcessor, "Widget", 2, 10, 50.00, 50.00, false);

        System.out.println("\nStretch Goal 1 (custom fields on exceptions):");
        try {
            System.out.println(orderProcessor.processOrderWithCustomFields("Gadget", 5, 2, 20.00, 20.00, false));
        } catch (OutOfStockException e) {
            System.out.println("Order failed: requested " + e.getRequestedQuantity()
                    + " units of stock that only had " + e.getAvailableQuantity() + " available.");
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        System.out.println("\nStretch Goal 2 (batch order processing with summary report):");
        List<OrderRequest> orders = List.of(
                new OrderRequest("Widget", 2, 10, 50.00, 50.00, false),
                new OrderRequest("Widget", 5, 2, 50.00, 50.00, false),
                new OrderRequest("Widget", -1, 10, 50.00, 50.00, false),
                new OrderRequest("Widget", 2, 10, 10.00, 50.00, false),
                new OrderRequest("Widget", 2, 10, 50.00, 50.00, true),
                new OrderRequest("Gizmo", 1, 5, 15.00, 15.00, false)
        );
        orderProcessor.processOrders(orders);
    }
}
