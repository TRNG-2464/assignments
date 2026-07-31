//package java.java_assignment_08;

public class OutOfStockException extends InventoryException {
    public OutOfStockException(int requestedQty, int availableStock) {
        super("Out of stock. Requested " + requestedQty + ", but only " + availableStock + " available.");
    }
}