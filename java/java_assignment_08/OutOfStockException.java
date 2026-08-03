public class OutOfStockException extends InventoryException {

    // Stretch Goal 1: custom fields so callers can build a tailored message
    // without relying solely on the exception's message string.
    private final int requestedQuantity;
    private final int availableQuantity;

    // Used by the base processOrder method, which doesn't need the custom fields.
    public OutOfStockException(String message) {
        super(message);
        this.requestedQuantity = 0;
        this.availableQuantity = 0;
    }

    // Used by processOrderWithCustomFields (Stretch Goal 1).
    public OutOfStockException(String message, int requestedQuantity, int availableQuantity) {
        super(message);
        this.requestedQuantity = requestedQuantity;
        this.availableQuantity = availableQuantity;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }
}
