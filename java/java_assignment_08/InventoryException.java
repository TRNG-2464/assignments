class InventoryException extends Exception {
    
    public InventoryException(String message) {
        super(message);
    }

}

class OutOfStockException extends InventoryException {

    public OutOfStockException(String itemName, int requestedQty, int availableStock) {
        super("Item '" + itemName + "' does not have enough stock! Requested " + requestedQty + 
            ", but only " + availableStock + " available.\n");
    }

}

class InvalidQuantityException extends InventoryException {

    public InvalidQuantityException(int requestedQty) {
        super("Invalid quantity of " + requestedQty + " requested! Must be greater than 0.\n");
    }

}
