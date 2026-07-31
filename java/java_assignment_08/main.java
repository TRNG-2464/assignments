
class InventoryException extends Exception {
    private String message;
    public InventoryException(String message) {
        this.message = "Order failed: " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

class PaymentException extends Exception {
    private String message;
    public PaymentException(String message) {
        this.message = "Order failed: " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

class OutOfStockException extends InventoryException {
    private int quantity;
    private int available;

    public int getQuantity() {
        return quantity;
    }
    public int getAvailable() {
        return available;
    }

    public OutOfStockException(int requestedQuantity, int availableStock) {
        super("Out of stock.");
        quantity = requestedQuantity;
        available = availableStock;
        // super("Out of stock. Requested " + requestedQuantity + ", but only " + availableStock + " available.");
    }
}

class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException() {
        super("Invalid quantity. Quantity must be greater than 0.");
    }
}

class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException() {
        super("Payment declined. Insufficient funds.");
    }
}

class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException() {
        super("Payment method expired.");
    }
}

class Order {
    String name;
    int quantity;
    int available;
    int payment;
    int cost;
    boolean expired;
}

public class main {

    static void processOrder(String name, int requestedQuantity, int availableStock, double paymentAmount, double totalCost, boolean expired) throws InventoryException, PaymentException {
        if (requestedQuantity <= 0) {
            throw new InvalidQuantityException();
        }

        if (requestedQuantity > availableStock) {
            throw new OutOfStockException(requestedQuantity, availableStock);
        }

        if (expired) {
            throw new PaymentExpiredException();
        }

        if (paymentAmount < totalCost) {
            throw new PaymentDeclinedException();
        }

        System.out.println("Order successsful! " + requestedQuantity + " x " + name + " confirmed.");
    }

    static void processMultipleOrders(Order[] orders) {
        for (Order order : orders) {
            int failedOrderCount = 0, validOrderCount = 0;
            int outOfStockCount = 0, invalidQuantityCount = 0, paymentDeclinedCount = 0, paymentExpiredCount = 0;

            try {
                processOrder(order.name, order.quantity, order.available, order.payment, order.cost, order.expired);
                validOrderCount += 1;
            } catch (OutOfStockException e) {
                failedOrderCount += 1;
                outOfStockCount += 1;
            } catch (InvalidQuantityException e) {
                failedOrderCount += 1;
                invalidQuantityCount += 1;
            } catch (PaymentDeclinedException e) {
                failedOrderCount += 1;
                paymentDeclinedCount += 1;
            } catch (PaymentExpiredException e) {
                failedOrderCount += 1;
                paymentExpiredCount += 1;
            } catch (Exception e) {
            }

            System.out.println("Summary: ");
            System.out.println("Successful orders: " + validOrderCount);
            System.out.println("Failed orders: " + failedOrderCount);
            System.out.println("OutOfStock: " + outOfStockCount);
            System.out.println("InvalidQuantity: " + invalidQuantityCount);
            System.out.println("PaymentDeclined: " + paymentDeclinedCount);
            System.out.println("PaymentExpired: " + paymentExpiredCount);
        }
    }


    public static void main(String[] args) throws InventoryException, PaymentException {
        try {
            processOrder("Widget", -1, 10, 100.0, 20.0, false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Widget", 10, 1, 100.0, 20.0, false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Widget", 1, 1, 1.0, 20.0, false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Widget", 1, 1, 100.0, 20.0, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            processOrder("Widget", 1, 1, 20.0, 20.0, false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Widget", 10, 1, 20.0, 20.0, false);
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            processOrder("Widget", 20, 1, 20.0, 20.0, false);
        } catch (OutOfStockException  e) {
            System.out.println("Order failed: Requested " + e.getQuantity() + ", but only " + e.getAvailable() + " available.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
