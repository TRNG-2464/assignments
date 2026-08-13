import java.util.HashMap;
import java.util.HashSet;

public class BathRoom extends Room {
    boolean sinkIsRunning;

    public BathRoom(String name, String description, boolean sinkIsRunning) {
        super(name, description);
        this.sinkIsRunning = sinkIsRunning;
    }

    public void interact(String entityName) {
        Entity entity = null;
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).name.equals(entityName)) {
                entity = entities.get(i);
                break;
            }
        }

        entity.interact();
    }
}
