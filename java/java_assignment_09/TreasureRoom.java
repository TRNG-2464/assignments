public class TreasureRoom extends Room {

    boolean isLocked = true;

    public TreasureRoom(String name, String description) {
        super(name, description);
    }
    
    public void unlockRoom(Entity entity) {
        if (entity.name.equals("Key")) {
            isLocked = false;
        }
    }
}
