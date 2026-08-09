import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HomeTour {

    public static void main(String[] args) {

        // Living Room
        List<Entity> livingroomEntities = new LinkedList<>();
        livingroomEntities.add(new Entity("Couch", "A place to sit down", "This is too comfy."));
        livingroomEntities.add(new Entity("TV", "Entertainment lives here", "Changing the volume."));

        // Kitchen
        List<Entity> kitchenEntities = new LinkedList<>();
        kitchenEntities.add(new Entity("CoffeeMaker", "Makes fresh coffee", "Fresh coffee is brewing."));

        // Bathroom
        List<Entity> bathroomEntities = new LinkedList<>();
        bathroomEntities.add(new Entity("Mirror", "A shiny mirror", "You look great today."));

        // Bedroom
        List<Entity> bedroomEntities = new LinkedList<>();
        bedroomEntities.add(new Entity("Bed", "A comfy bed", "Maybe it's time for a nap."));

        Map<String, Room> livingroomExits = new HashMap<>();
        Map<String, Room> kitchenExits = new HashMap<>();
        Map<String, Room> bathroomExits = new HashMap<>();
        Map<String, Room> bedroomExits = new HashMap<>();

        Room livingroom = new Room(
                "Living Room",
                "The central room of the house.",
                livingroomExits,
                livingroomEntities);

        Room kitchen = new Room(
                "Kitchen",
                "The tastiest room in the house.",
                kitchenExits,
                kitchenEntities);

        Room bathroom = new Room(
                "Bathroom",
                "When nature calls, you answer.",
                bathroomExits,
                bathroomEntities);

        Room bedroom = new Room(
                "Bedroom",
                "A quiet place to relax.",
                bedroomExits,
                bedroomEntities);

        // Connect rooms
        livingroom.setExit("north", kitchen);
        kitchen.setExit("south", livingroom);

        livingroom.setExit("east", bedroom);
        bedroom.setExit("west", livingroom);

        livingroom.setExit("west", bathroom);
        bathroom.setExit("east", livingroom);

        Room currentRoom = livingroom;

        Scanner scanner = new Scanner(System.in);

        getInfo(currentRoom);

        boolean running = true;

        while (running) {

            System.out.print("Enter a command: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit") ||
                input.equalsIgnoreCase("quit")) {

                System.out.println("Thanks for visiting! Goodbye.");
                running = false;
            }

            else if (input.equalsIgnoreCase("look")) {
                getInfo(currentRoom);
            }

            else if (input.toLowerCase().startsWith("move ")) {

                String direction = input.substring(5).trim();

                try {
                    currentRoom = currentRoom.getExit(direction);
                    getInfo(currentRoom);
                }
                catch (InvalidDirectionException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }

            else if (input.toLowerCase().startsWith("interact ")) {

                String entityName = input.substring(9).trim();

                try {
                    Entity entity = currentRoom.getEntity(entityName);
                    System.out.println(entity.interact());
                }
                catch (EntityNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }

            else {
                System.out.println("Unknown command.");
            }

        }

        scanner.close();

    }

    public static void getInfo(Room room) {

        System.out.println("\nYou are in the " + room.getName() + ".");
        System.out.println(room.getDescription());

        List<Entity> entities = room.getEntities();

        System.out.print("Interactable entities: ");

        if (entities.isEmpty()) {
            System.out.println("None");
            return;
        }

        for (int i = 0; i < entities.size(); i++) {

            System.out.print(entities.get(i).getName());

            if (i < entities.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\n");
    }
}