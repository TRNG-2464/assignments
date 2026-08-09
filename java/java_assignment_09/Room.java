import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private List<Entity> entities;

    public Room(String name, String description, Map<String, Room> exits, List<Entity> entities) {
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.entities = entities;
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }
    public void setEntity(Entity entity) {
        if (entities != null) {
            entities.add(entity);
        }
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room nextRoom = exits.get(direction.toLowerCase());
        if (nextRoom == null) {
            throw new InvalidDirectionException("There is no exit to the " + direction + " from here.");
        }
        return nextRoom;
    }
    public Entity getEntity(String entityName) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }
        throw new EntityNotFoundException("There is no '" + entityName + "' here to interact with.");
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
}
