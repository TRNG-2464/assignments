package com.mycompany.app;

public class OutOfStockException extends InventoryException {

    public OutOfStockException(String message) {
        super(message);
    }

    public OutOfStockException() {
        super("Requested amount is larger than the available stock.");
    }

}
