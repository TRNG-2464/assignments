//package java.java_assignment_08;

public class InvalidQuantityException extends InventoryException {
    public InvalidQuantityException() {
        super("Invalid quantity. Quantity must be greater than zero.");
    }
}