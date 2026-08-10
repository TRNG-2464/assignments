package exercise8;

public class OutOfStockException extends InventoryException {
    public OutOfStockException(String message) {
        super(message);
    }
}
