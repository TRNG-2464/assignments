public class InvalidQuantityException extends InventoryException {

    public InvalidQuantityException() {
        super("Invalid quantity. Quantity must be greater than 0.");
    }

}