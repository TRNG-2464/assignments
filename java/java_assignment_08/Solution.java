// Top level exceptions:
class InventoryException extends Exception {
    public InventoryException(String message) {
        super(message);
    }
}
class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}

// Exceptions extending InventoryException
class OutOfStockException extends InventoryException {
    public OutOfStockException() {
        super("There are not enough items in stock to fulfill this request.");
    }
}
class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException() {
        super("An invalid (<= 0) number of items has been requested.");
    }
}

// Exceptions extending PaymentException
class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException() {
        super("The payment is not enough to fulfill the order cost.");
    }
}
class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException() {
        super("The payment method is marked as expired.");
    }
}


public class Solution {

    /**
     * Main assignment code. I may add the stretch goals later.
     * @param item
     * @param quant
     * @param avail
     * @param payment
     * @param cost
     * @param expired
     * @throws OutOfStockException
     * @throws InvalidQuantityException
     * @throws PaymentDeclinedException
     * @throws PaymentExpiredException
     */

    static void processOrder(String item, int quant, int avail, double payment, double cost, boolean expired) throws OutOfStockException, InvalidQuantityException, PaymentDeclinedException, PaymentExpiredException{
        if (quant <= 0){
            throw new InvalidQuantityException();
        }
        else if (quant > avail){
            throw new OutOfStockException();
        }
        else if (payment < cost){
            throw new PaymentDeclinedException();
        }
        else if (expired){
            throw new PaymentExpiredException();
        }
        System.out.println("Order successful! " + quant + "x " + item + " confirmed.");
    }

    static void runOrders() throws Exception{
        try{
            processOrder("shoe", -1, 2, 100, 10, false);
        }
        catch(InvalidQuantityException e){
            System.out.println("Order failed - quantity must be greater than zero");
        }

        try{
            processOrder("shoe", 4, 6, 100, 200, false);
        }
        catch(PaymentException e){
            System.out.println("Order failed. An error occurred processing payment.");
        }

        try{
            processOrder("shoe", 4, 6, 100, 100, false);
        }
        catch(Exception e){
            System.out.println("This is not supposed to print");
        }
    }
    public static void main(String[] args) throws Exception{
        runOrders();
    }   
}
