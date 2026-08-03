public class asgn_08 {
    public static void main(String[] args) {
        // I'm assuming that we are supposed to put hardcoded orders based on this:
        // In your driving code (e.g., main), call this method with several different simulated orders, each designed to trigger a different outcome (each type of exception, as well as at least one successful order).

        // catch: outOfStockException
        try {
            processOrder("Widget", 5, 2, 50.00, 50.00, false);
        } catch (outOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (invException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (payException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // catch: invalidQtyException
        try {
            processOrder("Widget", -1, 10, 50.00, 50.00, false);
        } catch (invalidQtyException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (invException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (payException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // catch: payException
        try {
            processOrder("Widget", 2, 10, 10.00, 50.00, false);
        } catch (invException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (payException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // catch: invException
        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, true);
        } catch (invException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (payException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // Successful order
        try {
            processOrder("Widget", 2, 10, 50.00, 50.00, false);
        } catch (invException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (payException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }

    public static void processOrder(
            String itemName,
            int requestedQty,
            int availableStock,
            double paymentAmount,
            double orderCost,
            boolean isExpired
    ) throws invException, payException {
        if (requestedQty <= 0) {
            throw new invalidQtyException("Invalid quantity. Quantity must be greater than 0.");
        }
        if (requestedQty > availableStock) {
            throw new outOfStockException(
                "Out of stock. Requested " + requestedQty + ", but only " + availableStock + " available."
            );
        }
        if (isExpired) {
            throw new payExpException("Payment method expired.");
        }
        if (paymentAmount < orderCost) {
            throw new payDeclinedException("Payment declined. Insufficient funds.");
        }

        System.out.println("Order successful! " + requestedQty + " x " + itemName + " confirmed.");
    }
}

class invException extends Exception {
    public invException(String message) {
        super(message);
    }
}

class payException extends Exception {
    public payException(String message) {
        super(message);
    }
}

class outOfStockException extends invException {
    public outOfStockException(String message) {
        super(message);
    }
}

class invalidQtyException extends invException {
    public invalidQtyException(String message) {
        super(message);
    }
}

class payDeclinedException extends payException {
    public payDeclinedException(String message) {
        super(message);
    }
}

class payExpException extends payException {
    public payExpException(String message) {
        super(message);
    }
}
