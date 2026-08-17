import java.util.Scanner;

public class HouseTour {

    public static void main(String[] args) {
        Room currentRoom = buildHouse();

        Scanner scanner = new Scanner(System.in);
        currentRoom.display();

        while (true) {
            System.out.print("\nEnter a command: ");
            String input = scanner.nextLine().trim();
            String[] tokens = input.split("\\s+");
            String command = tokens[0].toLowerCase();

            if (command.equals("exit") || command.equals("quit")) {
                System.out.println("Thanks for visiting! Goodbye.");
                break;

            } else if (command.equals("look")) {
                currentRoom.display();

            } else if (command.equals("move")) {
                if (tokens.length < 2) {
                    System.out.println("Move where?");
                    continue;
                }
                try {
                    currentRoom = currentRoom.getExit(tokens[1]);
                    currentRoom.display();
                } catch (InvalidDirectionException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (command.equals("interact")) {
                if (tokens.length < 2) {
                    System.out.println("Interact with what?");
                    continue;
                }
                try {
                    Entity entity = currentRoom.getEntity(tokens[1]);
                    System.out.println(entity.interact());
                } catch (EntityNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else {
                System.out.println("Unknown command. Try: move [direction], look, interact [entity], exit");
            }
        }

        scanner.close();
    }

    private static Room buildHouse() {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up.");
        Room kitchen = new Room("Kitchen", "A bright kitchen with the smell of fresh coffee.");
        Room livingRoom = new Room("LivingRoom", "A cozy living room with a couch facing the TV.");
        Room bedroom = new Room("Bedroom", "A quiet bedroom with a neatly made bed.");

        foyer.addExit("north", kitchen);
        kitchen.addExit("south", foyer);

        foyer.addExit("east", livingRoom);
        livingRoom.addExit("west", foyer);

        kitchen.addExit("up", bedroom);
        bedroom.addExit("down", kitchen);

        foyer.addEntity(new Entity("CoatRack", "A wooden rack by the door.",
                "You check the CoatRack. There's an old raincoat hanging on it."));

        kitchen.addEntity(new Entity("CoffeeMaker", "A drip coffee maker, still warm.",
                "You check the CoffeeMaker. It's brewing a fresh pot of coffee."));
        kitchen.addEntity(new Entity("Refrigerator", "A stainless steel fridge.",
                "You open the Refrigerator. There's leftovers and a carton of milk inside."));

        livingRoom.addEntity(new Entity("TV", "A flat-screen TV mounted on the wall.",
                "You turn on the TV. A rerun of an old sitcom is playing."));
        livingRoom.addEntity(new Entity("Bookshelf", "A tall bookshelf packed with novels.",
                "You browse the Bookshelf. Mostly mystery novels and a few cookbooks."));

        bedroom.addEntity(new Entity("Bed", "A neatly made queen-size bed.",
                "You check the Bed. It looks very comfortable."));
        bedroom.addEntity(new Entity("Closet", "A closet with sliding doors.",
                "You open the Closet. Just some clothes and an old shoebox."));

        return foyer;
    }
}
