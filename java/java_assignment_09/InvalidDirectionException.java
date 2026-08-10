public class InvalidDirectionException extends Exception {

    public InvalidDirectionException(String direction) {
        super("There is no exit to the " + direction + " from here.");
    }
}
