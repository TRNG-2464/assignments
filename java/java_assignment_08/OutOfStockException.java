public class OutOfStockException extends InventoryException {

    public OutOfStockException(int requested, int available) {
        super("Out of stock. Requested " + requested +
              ", but only " + available + " available.");
    }

}