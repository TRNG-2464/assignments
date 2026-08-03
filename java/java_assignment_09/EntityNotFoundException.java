/**
 * Thrown when an "interact" command references an entity name that
 * does not exist in the player's current room.
 */
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
