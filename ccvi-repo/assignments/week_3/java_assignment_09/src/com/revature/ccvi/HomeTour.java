package com.revature.ccvi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Custom Exception for invalid direction moves
class InvalidDirectionException extends Exception {
    public InvalidDirectionException(String direction) {
        super("There is no exit to the " + direction.toLowerCase() + " from here.");
    }
}

// Custom Exception for missing entities in a room or inventory
class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String name) {
        super("There is no '" + name + "' here to interact with.");
    }
}

// Custom Exception for attempting to take an untakeable entity
class UntakeableEntityException extends Exception {
    public UntakeableEntityException(String name) {
        super("You cannot pick up the " + name + ".");
    }
}

// Entity modeled as a modern Java Record
record Entity(String name, String description, String interactionResponse, boolean isTakeable) {
    public String interact() {
        return interactionResponse;
    }
}

class Room {
    private final String name;
    private final String description;
    private final Map<String, Room> exits = new HashMap<>();
    private final List<Entity> entities = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction.toLowerCase(), neighbor);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    
    // Method to support removing items when taken
    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room nextRoom = exits.get(direction.toLowerCase());
        if (nextRoom == null) {
            throw new InvalidDirectionException(direction);
        }
        return nextRoom;
    }

    public Entity getEntity(String entityName) throws EntityNotFoundException {
        return entities.stream()
                .filter(e -> e.name().equalsIgnoreCase(entityName))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(entityName));
    }

    public void printRoomDetails() {
        System.out.println("You are in the " + name + ".");
        System.out.println(description);
        String entityList = entities.isEmpty() 
            ? "None" 
            : String.join(", ", entities.stream().map(Entity::name).toList());
        System.out.println("Interactable entities: " + entityList);
    }
}

public class HomeTour {
    public static void main(String[] args) {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up.");
        Room kitchen = new Room("Kitchen", "A bright kitchen with the smell of fresh coffee.");
        Room diningRoom = new Room("Dining Room", "A warm room with a long mahogany dining table.");
        Room livingRoom = new Room("Living Room", "A cozy area featuring a plush couch and television.");

        foyer.setExit("north", kitchen);
        foyer.setExit("up", livingRoom);

        kitchen.setExit("south", foyer);
        kitchen.setExit("east", diningRoom);

        diningRoom.setExit("west", kitchen);

        livingRoom.setExit("down", foyer);

        // Populate Entities with the 'isTakeable' boolean flag
        foyer.addEntity(new Entity("CoatRack", "An old coat rack", "You check the CoatRack. There's an old raincoat hanging on it.", false));
        foyer.addEntity(new Entity("Keys", "A set of brass keys", "You jingle the keys. They sound heavy.", true));
        
        kitchen.addEntity(new Entity("CoffeeMaker", "A coffee machine", " You check the CoffeeMaker. It brews a fresh cup of dark coffee!", false));
        kitchen.addEntity(new Entity("Apple", "A red apple", "You polish the apple. It looks delicious.", true));
        kitchen.addEntity(new Entity("Refrigerator", "A fridge", "You check the Refrigerator. Cold air drifts out, revealing a pitcher of lemonade.", false));
        
        diningRoom.addEntity(new Entity("Table", "A mahogany table", "You check the Table. It's set neatly for dinner.", false));
        
        livingRoom.addEntity(new Entity("Television", "A flat-screen TV", "You check the Television. It turns on to display static.", false));
        livingRoom.addEntity(new Entity("Remote", "A TV remote", "You press a button on the remote. A red LED blinks.", true));

        Room currentRoom = foyer;
        List<Entity> inventory = new ArrayList<>(); // Track the player's inventory

        currentRoom.printRoomDetails();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("\nEnter a command: ");
                if (!scanner.hasNextLine()) break;

                String input = scanner.nextLine().trim();
                if (input.isEmpty()) continue;

                String[] parts = input.split("\\s+", 2);
                String command = parts[0].toLowerCase();
                String argument = parts.length > 1 ? parts[1] : "";

                try {
                    switch (command) {
                        case "move" -> {
                            if (argument.isEmpty()) {
                                System.out.println("Error: Please specify a direction.");
                            } else {
                                currentRoom = currentRoom.getExit(argument);
                                currentRoom.printRoomDetails();
                            }
                        }
                        case "look" -> currentRoom.printRoomDetails();
                        case "interact" -> {
                            if (argument.isEmpty()) {
                                System.out.println("Error: Please specify an entity.");
                            } else {
                                Entity target;
                                try {
                                    // First attempt to find the entity in the current room
                                    target = currentRoom.getEntity(argument);
                                } catch (EntityNotFoundException e) {
                                    // If not in the room, fallback to checking the inventory
                                    target = inventory.stream()
                                            .filter(ent -> ent.name().equalsIgnoreCase(argument))
                                            .findFirst()
                                            .orElseThrow(() -> new EntityNotFoundException(argument));
                                }
                                System.out.println(target.interact());
                            }
                        }
                        case "take" -> {
                            if (argument.isEmpty()) {
                                System.out.println("Error: Please specify an item to take.");
                            } else {
                                Entity entity = currentRoom.getEntity(argument);
                                if (!entity.isTakeable()) {
                                    throw new UntakeableEntityException(entity.name());
                                }
                                currentRoom.removeEntity(entity);
                                inventory.add(entity);
                                System.out.println("You picked up the " + entity.name() + ".");
                            }
                        }
                        case "inventory" -> {
                            if (inventory.isEmpty()) {
                                System.out.println("You are not carrying anything.");
                            } else {
                                System.out.println("You are carrying:");
                                for (Entity e : inventory) {
                                    System.out.println("- " + e.name() + ": " + e.description());
                                }
                            }
                        }
                        case "exit", "quit" -> {
                            System.out.println("Thanks for visiting! Goodbye.");
                            return;
                        }
                        default -> System.out.println("Error: Unknown command.");
                    }
                } catch (InvalidDirectionException | EntityNotFoundException | UntakeableEntityException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
