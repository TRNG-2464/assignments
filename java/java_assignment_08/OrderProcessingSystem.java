import java.util.Scanner;


// Top-level Inventory exception
class InventoryException extends Exception {

    public InventoryException(String message) {
        super(message);
    }
}


// Inventory child exceptions
class OutOfStockException extends InventoryException {

    public OutOfStockException(String message) {
        super(message);
    }
}


class InvalidQuantityException extends InventoryException {

    public InvalidQuantityException(String message) {
        super(message);
    }
}


// Top-level Payment exception
class PaymentException extends Exception {

    public PaymentException(String message) {
        super(message);
    }
}


// Payment child exceptions
class PaymentDeclinedException extends PaymentException {

    public PaymentDeclinedException(String message) {
        super(message);
    }
}


class PaymentExpiredException extends PaymentException {

    public PaymentExpiredException(String message) {
        super(message);
    }
}


// Order processing class
public class OrderProcessingSystem {


    public static String processOrder(
            String itemName,
            int requestedQuantity,
            int availableStock,
            double paymentAmount,
            double orderCost,
            boolean isExpired
    ) throws InventoryException, PaymentException {


        // Inventory validation happens first
        if (requestedQuantity <= 0) {

            throw new InvalidQuantityException(
                    "Invalid quantity. Quantity must be greater than 0."
            );
        }


        if (requestedQuantity > availableStock) {

            throw new OutOfStockException(
                    "Out of stock. Requested "
                            + requestedQuantity
                            + ", but only "
                            + availableStock
                            + " available."
            );
        }


        // Payment validation happens second
        if (isExpired) {

            throw new PaymentExpiredException(
                    "Payment method expired."
            );
        }


        if (paymentAmount < orderCost) {

            throw new PaymentDeclinedException(
                    "Payment declined. Insufficient funds."
            );
        }


        // Successful order
        return "Order successful! "
                + requestedQuantity
                + " x "
                + itemName
                + " confirmed.";
    }


    // Helper method to demonstrate different catches
    public static void testOrder(
            String itemName,
            int quantity,
            int stock,
            double payment,
            double cost,
            boolean expired
    ) {

        try {

            System.out.println(
                    processOrder(
                            itemName,
                            quantity,
                            stock,
                            payment,
                            cost,
                            expired
                    )
            );


        } catch (InvalidQuantityException e) {

            // Specific inventory exception
            System.out.println(
                    "Order failed: " + e.getMessage()
            );


        } catch (InventoryException e) {

            // General inventory exception
            System.out.println(
                    "Inventory error: " + e.getMessage()
            );


        } catch (PaymentException e) {

            // General payment exception catches both payment types
            System.out.println(
                    "Payment error: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {


        // Test orders that trigger each possible outcome
        try {

            System.out.println(
                    processOrder(
                            "Widget",
                            5,
                            2,
                            50.00,
                            50.00,
                            false
                    )
            );


        } catch (OutOfStockException e) {

            // Specific subclass catch
            System.out.println(
                    "Order failed: " + e.getMessage()
            );

        } catch (InventoryException e) {

            // Broader parent catch
            System.out.println(
                    "Inventory problem: " + e.getMessage()
            );

        } catch (PaymentException e) {

            System.out.println(
                    "Payment problem: " + e.getMessage()
            );
        }



        testOrder(
                "Widget",
                -1,
                10,
                50.00,
                50.00,
                false
        );


        testOrder(
                "Widget",
                2,
                10,
                10.00,
                50.00,
                false
        );


        testOrder(
                "Widget",
                2,
                10,
                50.00,
                50.00,
                true
        );


        testOrder(
                "Widget",
                2,
                10,
                50.00,
                50.00,
                false
        );
    }
}