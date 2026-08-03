public class Exercise8 {

    // Processes one order
    public static void processOrder(String item, int quantity,
                                    int stock, double payment,
                                    double cost, boolean expired)
            throws InventoryException, PaymentException {

        // Check inventory first
        if (quantity <= 0) {
            throw new InvalidQuantityException();
        }
        if (quantity > stock) {
            throw new OutOfStockException(quantity, stock);
        }
        // Check payment next
        if (expired) {
            throw new PaymentExpiredException();
        }
        if (payment < cost) {
            throw new PaymentDeclinedException();
        }
        System.out.println("Order successful! " + quantity +
                " x " + item + " confirmed.");
    }

    public static void main(String[] args) {
        // Invalid quantity
        try {
            processOrder("Widget", -1, 10, 50, 50, false);
        } catch (InvalidQuantityException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Inventory error: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment error: " + e.getMessage());
        }

        // Out of stock
        try {
            processOrder("Widget", 5, 2, 50, 50, false);
        } catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Inventory error: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
        // Payment expired
        try {
            processOrder("Widget", 2, 10, 50, 50, true);
        } catch (InventoryException e) {
            System.out.println("Inventory error: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
        // Payment declined
        try {
            processOrder("Widget", 2, 10, 10, 50, false);
        } catch (InventoryException e) {
            System.out.println("Inventory error: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
        // Successful order
        try {
            processOrder("Widget", 2, 10, 50, 50, false);
        } catch (InventoryException e) {
            System.out.println("Inventory error: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
    }
}