//package java.java_assignment_09;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

public class Room {
    private final String name;
    private final String description;
    private final List<Entity> entities;
    private final Map<String, Room> exits;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.entities = new ArrayList<>();
        this.exits = new LinkedHashMap<>();
    }

    public void addExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room exit = exits.get(direction.toLowerCase());
        if (exit == null) {
            throw new InvalidDirectionException("There is no exit to the " + direction.toLowerCase() + " from here.");
        }
        return exit;
    }

    public Entity findEntity(String entityName) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }
        throw new EntityNotFoundException("There is no '" + entityName + "' here to interact with.");
    }

    public void display() {
        System.out.println();
        System.out.println("You are in the " + name + ".");
        System.out.println(description);

        if (entities.isEmpty()) {
            System.out.println("Interactable Entities: None");
        }
        else{
            System.out.print("Interactable Entities: ");
            for (int i = 0; i < entities.size(); i++) {
                System.out.print(entities.get(i).getName());
                if (i < entities.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();

            for (Entity entity : entities) {
                System.out.println("- " + entity.getName() + ": " + entity.getDescription());
            }
        
        }

        System.out.println("Exits: " + String.join(", ", exits.keySet()));
    }
}
