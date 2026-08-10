
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class HomeTour {
 
    public static void main(String[] args) {
        Room currentRoom = buildHouse();
        try (Scanner scanner = new Scanner(System.in)) {
            currentRoom.display();
            
            OUTER:
            while (true) {
                System.out.print("\nEnter a command: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    continue;
                }
                String[] parts = input.split("\\s+", 2);
                String command = parts[0].toLowerCase();
                String argument = parts.length > 1 ? parts[1] : "";
                switch (command) {
                    case "move":
                        try {
                            currentRoom = currentRoom.getExit(argument);
                            System.out.println();
                            currentRoom.display();
                        } catch (InvalidDirectionException e) {
                            System.out.println("Error: " + e.getMessage());
                        }   break;
                    case "look":
                        System.out.println();
                        currentRoom.display();
                        break;
                    case "interact":
                        try {
                            Entity entity = currentRoom.getEntity(argument);
                            System.out.println(entity.interact());
                        } catch (EntityNotFoundException e) {
                            System.out.println("Error: " + e.getMessage());
                        }   break;
                    case "exit":
                    case "quit":
                        System.out.println("Thanks for visiting! Goodbye.");
                        break OUTER;
                    default:
                        System.out.println("Error: Unknown command '" + command + "'.");
                        break;
                }
            }
        }
    }
 
    // Builds the 4 rooms, wires their exits together, and returns the starting room (Foyer).
    private static Room buildHouse() {
 
        List<Entity> foyerEntities = new ArrayList<>();
        foyerEntities.add(new Entity("CoatRack", "A wooden rack by the door.",
                "You check the CoatRack. There's an old raincoat hanging on it."));
 
        List<Entity> kitchenEntities = new ArrayList<>();
        kitchenEntities.add(new Entity("CoffeeMaker", "A stainless steel coffee maker.",
                "You brew a fresh cup of coffee. Smells great."));
        kitchenEntities.add(new Entity("Refrigerator", "A large refrigerator humming quietly.",
                "You open the fridge. It's mostly empty except for some leftovers."));
 
        List<Entity> livingRoomEntities = new ArrayList<>();
        livingRoomEntities.add(new Entity("TV", "A flat-screen TV mounted on the wall.",
                "You turn on the TV. Nothing but static."));
        livingRoomEntities.add(new Entity("Bookshelf", "A tall bookshelf stuffed with novels.",
                "You skim the bookshelf. Mostly mystery novels."));
 
        List<Entity> bedroomEntities = new ArrayList<>();
        bedroomEntities.add(new Entity("Bed", "A neatly made queen-sized bed.",
                "You sit on the bed for a moment. Very comfortable."));
        bedroomEntities.add(new Entity("Closet", "A closet with sliding doors.",
                "You slide open the closet. Mostly winter clothes."));
 
        Room foyer = new Room("Foyer",
                "A small entryway with a coat rack and a stairway leading up.", foyerEntities);
        Room kitchen = new Room("Kitchen",
                "A bright kitchen with the smell of fresh coffee.", kitchenEntities);
        Room livingRoom = new Room("Living Room",
                "A cozy living room with a couch facing the TV.", livingRoomEntities);
        Room bedroom = new Room("Bedroom",
                "A quiet bedroom with soft carpet underfoot.", bedroomEntities);
 
        // Foyer <-> Kitchen
        foyer.setExit("north", kitchen);
        kitchen.setExit("south", foyer);
 
        // Foyer <-> Living Room
        foyer.setExit("east", livingRoom);
        livingRoom.setExit("west", foyer);
 
        // Kitchen <-> Bedroom
        kitchen.setExit("east", bedroom);
        bedroom.setExit("west", kitchen);
 
        // Living Room <-> Bedroom
        livingRoom.setExit("north", bedroom);
        bedroom.setExit("south", livingRoom);
 
        return foyer;
    }
}
 