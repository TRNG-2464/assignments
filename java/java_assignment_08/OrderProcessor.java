//package java.java_assignment_08;

public class OrderProcessor {
    public static void orderProcess(String item, int requestedQty, int availableStock, double paymentAmt, double orderCost, boolean isPaymentExpired) throws InventoryException, PaymentException {
        if (requestedQty <= 0) {
            throw new InvalidQuantityException();
        }

        if(requestedQty > availableStock) {
            throw new OutOfStockException(requestedQty, availableStock);
        }

        if(isPaymentExpired) {
            throw new PaymentExpiredException();
        }

        if (paymentAmt < orderCost) {
            throw new PaymentDeclinedException();
        }

        System.out.println("Order successful! " + requestedQty + " x " + item + " confirmed.");

    }

    public static void main(String[] args) {
        try {
            orderProcess("Widget", 5, 2, 50.00, 50.00, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        System.out.println();

        try {
            orderProcess("Widget", -1, 10, 50.00, 50.00, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        System.out.println();
        
        try {
            orderProcess("Widget", 2, 10, 10.00, 50.00, false);
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        System.out.println();

        try {
            orderProcess("Widget", 2, 10, 50.00, 50.00, true);
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        System.out.println();

        try {
            orderProcess("Widget", 2, 10, 50.00, 50.00, false);
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

    }
}
