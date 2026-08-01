class InventoryException extends Exception {
    public InventoryException(String message) {
        super(message);
    }
}

class OutOfStockException extends InventoryException {

    int requestedQty;
    int availableStock;

    // e.getMessage() uses message field
    // or you can just print on catch {}
    public OutOfStockException(int requestedQty, int availableStock) {
        super(String.format("Order failed: Out of stock. Requested %d, but only %d available.", requestedQty, availableStock));
        this.requestedQty = requestedQty;
        this.availableStock = availableStock;
        // throw new OutOfStockException(requested, available);

        // or have caller define custom message
        // throw new OutOfStockException(String.format("Order failed: Out of stock. Requested %d, but only %d available.", requested, available));
    }

    public int getRequestedQty() {
        return requestedQty;
    }

    public int getAvailableStock() {
        return availableStock;
    }
}

class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException() {
        super("Order failed: Invalid quantity. Quantity must be greater than 0.");
    }
}