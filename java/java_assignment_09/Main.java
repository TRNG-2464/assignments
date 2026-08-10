package exercise9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws invalidDirection, invalidEntity {
        HashMap<String, String> kitchenAdjRooms = new HashMap<>();
        HashMap<String, String> livingRoomAdjRooms = new HashMap<>();
        HashMap<String, String> bedroomAdjRooms = new HashMap<>();
        HashMap<String, String> bathroomAdjRooms = new HashMap<>();

        kitchenAdjRooms.put("north", "livingRoom");
        kitchenAdjRooms.put("east", "bathroom");

        livingRoomAdjRooms.put("south", "kitchen");
        livingRoomAdjRooms.put("east", "bedroom");

        bedroomAdjRooms.put("west", "livingRoom");
        bedroomAdjRooms.put("south", "bathroom");

        bathroomAdjRooms.put("west", "kitchen");
        bathroomAdjRooms.put("north", "bedroom");

        List<Entity> kitchenEntities = new ArrayList<>();
        List<Entity> livingRoomEntities = new ArrayList<>();
        List<Entity> bedroomEntities = new ArrayList<>();
        List<Entity> bathroomEntities = new ArrayList<>();

        Entity food = new Entity("Food", "Some canned lasagna");
        kitchenEntities.add(food);
        Entity table = new Entity("Table", "The dining room table");
        kitchenEntities.add(table);
        Entity couch = new Entity("Couch", "A leather love seat");
        livingRoomEntities.add(couch);
        Entity bed = new Entity("Bed", "A king sized mattress");
        bedroomEntities.add(bed);
        Entity lamp = new Entity("Lamp", "A table lamp");
        bedroomEntities.add(lamp);
        Entity toilet = new Entity("Toilet", "A golden toilet");
        bathroomEntities.add(toilet);
        Entity soap = new Entity("Soap", "Dove soap");
        bathroomEntities.add(soap);
        Entity shower = new Entity("Shower", "A small shower");
        bathroomEntities.add(shower);

        Room kitchen = new Room("Kitchen", "A clean and modern room with a modern design.", kitchenAdjRooms, kitchenEntities);
        Room livingRoom = new Room("LivingRoom", "A nice open space with a lot of natural light.", livingRoomAdjRooms, livingRoomEntities);
        Room bedroom = new Room("Bedroom", "A small, sparse area.", bedroomAdjRooms, bedroomEntities);
        Room bathroom = new Room("Bathroom", "A cramped space with tiled floors.", kitchenAdjRooms, kitchenEntities);

        HashMap<String, Room> allRooms = new HashMap<>();
        allRooms.put(kitchen.getName().toLowerCase(), kitchen);
        allRooms.put(livingRoom.getName().toLowerCase(), livingRoom);
        allRooms.put(bedroom.getName().toLowerCase(), bedroom);
        allRooms.put(bathroom.getName().toLowerCase(), bathroom);

        Scanner sc = new Scanner(System.in);
        Room currRoom = kitchen;

        currRoom.intro();
        while (true) {
            String action = sc.nextLine().trim();
            String lowerAction = action.toLowerCase();
            try {
                if (lowerAction.equals("move north") || lowerAction.equals("move east")
                        || lowerAction.equals("move south") || lowerAction.equals("move west")) {
                    String direction = lowerAction.split(" ")[1]; // "north" / "east" / "south" / "west"
                    if (currRoom.getAdjacentRooms().containsKey(direction)) {
                        String nextRoomName = currRoom.getAdjacentRooms().get(direction);
                        Room nextRoom = allRooms.get(nextRoomName.toLowerCase());
                        if (nextRoom != null) {
                            currRoom = nextRoom;
                            currRoom.intro();
                        } else {
                            throw new invalidDirection("Invalid room.");
                        }
                    } else {
                        throw new invalidDirection("Invalid direction.");
                    }

                } else if (lowerAction.startsWith("interact")) {
                    String[] parts = action.split(" ", 2);
                    String entityName = parts[1].trim();
                    List<Entity> entities = currRoom.getEntities();
                    boolean found = false;
                    for (Entity entity : entities) {
                        if (entity.getName().equalsIgnoreCase(entityName)) {
                            found = true;
                            entity.interact("Hi! I'm a " + entity.getName());
                        }
                    }
                    if (!found) {
                        throw new invalidEntity("Invalid entity choice.");
                    }
                } else if (lowerAction.equals("look")) {
                    currRoom.intro();
                } else if (lowerAction.equals("exit") || lowerAction.equals("quit")) {
                    System.exit(0);
                } else {
                    System.out.println("Invalid input.");
                }
            } catch (invalidDirection | invalidEntity e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
