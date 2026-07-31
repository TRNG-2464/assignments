public class OrderProcessor {

    private static void processOrder(String item, int requestedQty, int availableStock,
                                      double paymentAmount, double orderCost, boolean isExpired)
            throws InventoryException, PaymentException {

        if (requestedQty <= 0) {
            throw new InvalidQuantityException("Invalid quantity. Quantity must be greater than 0.");
        }
        if (requestedQty > availableStock) {
            throw new OutOfStockException(
                    "Out of stock. Requested " + requestedQty + ", but only " + availableStock + " available.");
        }

        if (isExpired) {
            throw new PaymentExpiredException("Payment method expired.");
        }
        if (paymentAmount < orderCost) {
            throw new PaymentDeclinedException("Payment declined. Insufficient funds.");
        }

        System.out.println("Order successful! " + requestedQty + " x " + item + " confirmed.");
    }

    public static void main(String[] args) {

        // Example 1: Out of stock (specific catch)
        try {
            processOrder("Widget", 5, 2, 50.00, 50.00, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed due to an inventory issue: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed due to a payment issue: " + e.getMessage());
        }

        try {
            processOrder("Widget", -1, 10, 50.00, 50.00, false);
        } catch (InventoryException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed due to a payment issue: " + e.getMessage());
        }

        try {
            processOrder("Widget", 2, 10, 10.00, 50.00, false);
        } catch (PaymentDeclinedException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed due to a payment issue: " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed due to an inventory issue: " + e.getMessage());
        }

        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, true);
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Order failed due to an inventory issue: " + e.getMessage());
        }

        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, false);
        } catch (InventoryException | PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }
    
}

class InventoryException extends Exception {
    public InventoryException(String message) {
        super(message);
    }
}


class OutOfStockException extends InventoryException {
    public OutOfStockException(String message) {
        super(message);
    }
}

/**
 * Thrown when an order requests a zero or negative quantity of an item.
 */
class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

/**
 * Top-level exception for problems related to payment.
 */
class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}

/**
 * Thrown when a simulated payment amount is less than the order's total cost.
 */
class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException(String message) {
        super(message);
    }
}

/**
 * Thrown when a simulated payment method is marked as expired.
 */
class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException(String message) {
        super(message);
    }
}



