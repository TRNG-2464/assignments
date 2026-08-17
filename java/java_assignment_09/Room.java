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

    public void addExit(String direction, Room room) {
        exits.put(direction.toUpperCase(), room);
    }

    public void addEntity(Entity entity) {
        entities.put(entity.getName().toUpperCase(), entity);
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room room = exits.get(direction.toUpperCase());
        if (room == null) {
            throw new InvalidDirectionException("There is no exit to the " + direction.toLowerCase() + " from here.");
        }
        return room;
    }

    public Entity getEntity(String entityName) throws EntityNotFoundException {
        Entity entity = entities.get(entityName.toUpperCase());
        if (entity == null) {
            throw new EntityNotFoundException("There is no '" + entityName + "' here to interact with.");
        }
        return entity;
    }

    public void display() {
        System.out.println("You are in the " + name + ".");
        System.out.println(description);

        if (entities.isEmpty()) {
            System.out.println("Interactable entities: none");
        } else {
            StringBuilder names = new StringBuilder();
            for (Entity entity : entities.values()) {
                if (names.length() > 0) {
                    names.append(", ");
                }
                names.append(entity.getName());
            }
            System.out.println("Interactable entities: " + names);
        }
    }
}
