/**
 * Thrown when a "move" command specifies a direction that has no
 * exit from the player's current room.
 */
public class InvalidDirectionException extends Exception {

    public InvalidDirectionException(String message) {
        super(message);
    }
}
