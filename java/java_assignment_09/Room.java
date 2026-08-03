import java.util.LinkedHashMap;
import java.util.Map;

public class Room {

    private final String name;
    private final String description;

    private final Map<String, Room> exits = new LinkedHashMap<>();


    private final Map<String, Entity> entities = new LinkedHashMap<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setExit(String direction, Room destination) {
        exits.put(direction.toUpperCase(), destination);
    }

    public void addEntity(Entity entity) {
        entities.put(entity.getName().toUpperCase(), entity);
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room destination = exits.get(direction.toUpperCase());
        if (destination == null) {
            throw new InvalidDirectionException(
                    "There is no exit to the " + direction.toLowerCase() + " from here.");
        }
        return destination;
    }

    public Entity getEntity(String entityName) throws EntityNotFoundException {
        Entity entity = entities.get(entityName.toUpperCase());
        if (entity == null) {
            throw new EntityNotFoundException(
                    "There is no '" + entityName + "' here to interact with.");
        }
        return entity;
    }

    public void display() {
        System.out.println("You are in the " + name + ".");
        System.out.println(description);
        if (entities.isEmpty()) {
            System.out.println("Interactable entities: (none)");
        } else {
            StringBuilder sb = new StringBuilder("Interactable entities: ");
            boolean first = true;
            for (Entity e : entities.values()) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(e.getName());
                first = false;
            }
            System.out.println(sb);
        }
    }
}
