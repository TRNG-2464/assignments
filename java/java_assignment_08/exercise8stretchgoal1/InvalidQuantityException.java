package exercise8stretch1.exercise8;

public class InvalidQuantityException extends InventoryException {
    int quantity;
    String message;
    public InvalidQuantityException(String message, int quantity) {
        super(message);
        this.message = message;
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    @Override
    public String getMessage() {
        return this.message + " You entered " + this.getQuantity();
    }
}
