public class OrderProcessingSystem {
    public static void main(String[] args) {
        System.out.println();

        // Out of stock
        try {
            processOrder("PS5", 3, 1, 850.00, 847.39, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException | PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // Invalid quantity
        try {
            processOrder("PS5", -1, 5, 850.00, 847.39, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException | PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // Payment declined
        try {
            processOrder("PS5", 3, 5, 750.00, 847.39, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException | PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // Payment expired
        try {
            processOrder("PS5", 3, 5, 850.00, 847.39, true);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException | PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        

        // Successful order
        try {
            processOrder("PS5", 3, 5, 850.00, 847.39, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException | PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

    }

    public static void processOrder(String itemName, int requestedQty, int availableStock, 
        double paymentAmount, double orderCost, boolean isExpired) 
        throws InventoryException, PaymentException {
            if (requestedQty <= 0) {
                throw new InvalidQuantityException(requestedQty);
            }
            if (requestedQty > availableStock) {
                throw new OutOfStockException(itemName, requestedQty, availableStock);
            }

            if (isExpired) {
                throw new PaymentExpiredException();
            }
            if (paymentAmount < orderCost) {
                throw new PaymentDeclinedException();
            }

            System.out.println("Order successful! " + requestedQty + "x " + itemName + " confirmed.\n");

    }

}
