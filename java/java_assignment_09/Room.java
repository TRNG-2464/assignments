import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    private String name;
    private String description;

    private Map<String, Room> exits;
    private List<Entity> entities;

    public Room(String name, String description) {

        this.name = name;
        this.description = description;

        exits = new HashMap<>();
        entities = new ArrayList<>();
    }

    public void addExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public Room move(String direction)
            throws InvalidDirectionException {

        direction = direction.toLowerCase();

        Room nextRoom = exits.get(direction);

        if (nextRoom == null) {
            throw new InvalidDirectionException(
                    "There is no exit to the " + direction + " from here."
            );
        }

        return nextRoom;
    }

    public Entity findEntity(String entityName)
            throws EntityNotFoundException {

        for (Entity entity : entities) {

            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }

        throw new EntityNotFoundException(
                "There is no '" + entityName + "' here to interact with."
        );
    }

    public void displayRoom() {

        System.out.println();
        System.out.println("You are in the " + name + ".");
        System.out.println(description);

        System.out.print("Interactable entities: ");

        if (entities.isEmpty()) {

            System.out.println("None");

        } else {

            for (int i = 0; i < entities.size(); i++) {

                System.out.print(entities.get(i).getName());

                if (i < entities.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }
}