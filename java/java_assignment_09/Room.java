import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    private final String name;
    private final String description;
    private final Map<String, Room> exits;
    private final List<Entity> entities;

    public Room(String name, String description, List<Entity> entities) {
        this.name = name;
        this.description = description;
        this.entities = entities;
        this.exits = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    // Wires this room to another room in the given direction.
    // Direction is stored lowercase so lookups are case-insensitive.
    public void setExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room next = exits.get(direction.toLowerCase());
        if (next == null) {
            throw new InvalidDirectionException(direction);
        }
        return next;
    }

    public Entity getEntity(String entityName) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }
        throw new EntityNotFoundException(entityName);
    }

    // Displays name, description, and entities - used whenever the player enters a room.
    public void display() {
        System.out.println("You are in the " + name + ".");
        System.out.println(description);

        if (entities.isEmpty()) {
            System.out.println("Interactable entities: none");
        } else {
            StringBuilder names = new StringBuilder();
            for (int i = 0; i < entities.size(); i++) {
                names.append(entities.get(i).getName());
                if (i < entities.size() - 1) {
                    names.append(", ");
                }
            }
            System.out.println("Interactable entities: " + names);
        }
    }
}
