//package java.java_assignment_09;
import java.util.Locale;
import java.util.Scanner;

public class HomeTour {
    public static void main(String[] args) {
        Room curr = buildHouse();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            curr.display();
            while (running) {
                System.out.print("\nEnter a command: ");

                if (!scanner.hasNextLine()) {
                    System.out.println("No input detected. Exiting.");
                    break;
                }

                String input = scanner.nextLine().trim();

                if(input.isEmpty()) {
                    System.out.println("No input detected. Please enter a command.");
                    continue;
                }

                String[] parts = input.split("\\s+", 2);
                String command = parts[0].toLowerCase(Locale.ROOT);
                String argument = parts.length > 1 ? parts[1].trim() : "";

                try {
                    switch (command) {
                        case "move":
                            if (argument.isEmpty()) {
                                System.out.println("Please specify a direction to move.");
                            } else {
                                curr = curr.getExit(argument);
                                curr.display();
                            }
                            break;
                        case "look":
                            curr.display();
                            break;
                        case "interact":
                            if (argument.isEmpty()) {
                                System.out.println("Please specify an entity to interact with.");
                            } else {
                                Entity entity = curr.findEntity(argument);
                                System.out.println(entity.interact());
                            }
                            break;

                        case "exit":
                        case "quit":
                            running = false;
                            System.out.println("Exiting the home tour. Goodbye!");
                            break;
                        default:
                            System.out.println("Unknown command. Try move, look, interact, exit, or quit.");
                    }
                } catch (InvalidDirectionException | EntityNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        System.out.println("Thanks for visiting! Goodbye.");
    }

    private static Room buildHouse() {
        Room foyer = new Room("Foyer", "A small entryway with a coat rack and a stairway leading up.");
        Room kitchen = new Room("Kitchen", "A bright kitchen with the smell of fresh coffee.");
        Room livingRoom = new Room("Living Room", "A cozy living room with a fireplace and a comfy sofa.");
        Room bedRoom = new Room("Bedroom", "A peaceful upstairs bedroom with a large bed and a nightstand.");

        foyer.addExit("north", kitchen);
        kitchen.addExit("south", foyer);
        foyer.addExit("east", livingRoom);
        livingRoom.addExit("west", foyer);
        livingRoom.addExit("up", bedRoom);
        bedRoom.addExit("down", livingRoom);

        kitchen.addEntity(new Entity("CoffeeMaker", "A shiny coffee maker that seems to be brewing something.", "You take a sip of the freshly brewed coffee. It's delicious!"));
        kitchen.addEntity(new Entity("Fridge", "A large fridge humming quietly.", "You open the fridge and find some fresh fruit."));
        foyer.addEntity(new Entity("CoatRack", "A simple coat rack with a few coats hanging on it.", "You hang your coat on the rack."));
        livingRoom.addEntity(new Entity("Fireplace", "A warm fireplace with a gentle flame.", "You sit by the fireplace and feel the warmth."));
        livingRoom.addEntity(new Entity("Sofa", "A comfy sofa that looks perfect for lounging.", "You sink into the sofa and relax."));
        bedRoom.addEntity(new Entity("Bed", "A large bed with soft pillows.", "You lie down on the bed and take a short nap."));

        return foyer;
    }
}