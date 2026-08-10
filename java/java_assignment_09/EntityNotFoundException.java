public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String entityName) {
        super("There is no '" + entityName + "' here to interact with.");
    }
}
