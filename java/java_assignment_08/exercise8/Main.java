package exercise8;

public class Main {
    public static void main (String[] args) {
        try {
            order("Laptop", -2, 10, 600, 600, true);
        }
        catch (InvalidQuantityException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        catch (OutOfStockException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        catch (PaymentExpiredException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        catch (PaymentDeclinedException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        try {
            order("Laptop", 2, 10, 500, 600, true);
        }
        catch (InvalidQuantityException e) {
            System.out.println("Invalid quantity: " + e.getMessage());
        }
        catch (OutOfStockException e) {
            System.out.println("Stock error: " + e.getMessage());
        }
        catch (PaymentExpiredException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
        catch (PaymentDeclinedException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
    }
    public static void order(String name, int quantity, int available_stock, double payment, double cost, boolean payment_expired) throws InvalidQuantityException, OutOfStockException, PaymentExpiredException, PaymentDeclinedException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than 0.");
        }
        else if (quantity > available_stock) {
            throw new OutOfStockException("Quantity exceeds available stock.");
        }
        else if (payment_expired) {
            throw new PaymentExpiredException("Your payment has expired.");
        }
        else if (payment < cost) {
            throw new PaymentDeclinedException("You need to pay more.");
        } else {
            System.out.println("Order successful! " + quantity + " x " + name + " confirmed.");
        }
    }
}
