package HomeTour;

import java.util.Scanner;

public class HomeTour {
    public static void main(String[] args){
        Room foyer = new Room(
                "Foyer",
                "A small entryway."
        );

        Room kitchen = new Room(
                "Kitchen",
                "Smells like coffee."
        );

        Room bedroom = new Room(
                "Bedroom",
                "A cozy bedroom."
        );

        Room living = new Room(
                "Living Room",
                "A comfy couch."
        );
        foyer.addExit("north", kitchen);
        kitchen.addExit("south", foyer);

        kitchen.addExit("east", living);
        living.addExit("west", kitchen);

        foyer.addExit("up", bedroom);
        bedroom.addExit("down", foyer);
        Entity coffee =
                new Entity(
                        "CoffeeMaker",
                        "A coffee maker.",
                        "You make a hot cup of coffee."
                );

        Entity coat =
                new Entity(
                        "CoatRack",
                        "A wooden coat rack.",
                        "An old raincoat hangs there."
                );
        kitchen.addEntity(coffee);

        foyer.addEntity(coat);
        Room currentRoom = foyer;
        currentRoom.display();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            String[] parts = input.trim().split("\\s+");
            String command = parts[0].toLowerCase();

            try {

                if (command.equals("move")) {
                    if (parts.length < 2) {
                        System.out.println("Usage: move <direction>");
                        continue;
                    }
                    currentRoom = currentRoom.getExit(parts[1]);
                    currentRoom.display();

                } else if (command.equals("look")) {

                    currentRoom.display();

                } else if (command.equals("interact")) {
                    if (parts.length < 2) {
                        System.out.println("Usage: interact <entity>");
                        continue;
                    }
                    Entity e = currentRoom.getEntity(parts[1]);
                    System.out.println(e.interactWithEntity());

                } else if (command.equals("exit")|| command.equals("quit")) {
                    System.out.println("Thanks for visiting! Goodbye.");
                    break;
                }else {
                    System.out.println("Unknown command.");
                }

            } catch (InvalidDirectionException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (EntityNotFoundException e) {

                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
