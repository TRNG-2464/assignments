import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create rooms
        Room foyer = new Room(
                "Foyer",
                "A small entryway with a coat rack and a stairway leading up."
        );

        Room kitchen = new Room(
                "Kitchen",
                "A bright kitchen with the smell of fresh coffee."
        );

        Room livingRoom = new Room(
                "LivingRoom",
                "A comfortable living room with a large sofa and television."
        );

        Room bedroom = new Room(
                "Bedroom",
                "A quiet bedroom with a large bed and a window."
        );


        // Create entities
        Entity coatRack = new Entity(
                "CoatRack",
                "An old wooden coat rack.",
                "You check the CoatRack. There's an old raincoat hanging on it."
        );

        Entity coffeeMaker = new Entity(
                "CoffeeMaker",
                "A small coffee maker sitting on the counter.",
                "You turn on the CoffeeMaker. The smell of fresh coffee fills the room."
        );

        Entity refrigerator = new Entity(
                "Refrigerator",
                "A large white refrigerator.",
                "You open the Refrigerator. There are some leftovers inside."
        );

        Entity television = new Entity(
                "Television",
                "A large television in front of the sofa.",
                "You turn on the Television. A news channel is playing."
        );

        Entity sofa = new Entity(
                "Sofa",
                "A large comfortable sofa.",
                "You sit on the Sofa for a moment. It is very comfortable."
        );

        Entity bed = new Entity(
                "Bed",
                "A large comfortable bed.",
                "You sit on the Bed. It looks like a good place to sleep."
        );


        // Add entities to rooms
        foyer.addEntity(coatRack);

        kitchen.addEntity(coffeeMaker);
        kitchen.addEntity(refrigerator);

        livingRoom.addEntity(television);
        livingRoom.addEntity(sofa);

        bedroom.addEntity(bed);


        // Connect rooms

        // Foyer <-> Kitchen
        foyer.addExit("north", kitchen);
        kitchen.addExit("south", foyer);

        // Kitchen <-> Living Room
        kitchen.addExit("east", livingRoom);
        livingRoom.addExit("west", kitchen);

        // Foyer <-> Bedroom
        foyer.addExit("up", bedroom);
        bedroom.addExit("down", foyer);


        // Start in the Foyer
        Room currentRoom = foyer;

        System.out.println("=================================");
        System.out.println("        Welcome to Home Tour");
        System.out.println("=================================");

        currentRoom.displayRoom();


        // Command loop
        boolean running = true;

        while (running) {

            System.out.print("Enter a command: ");

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+");

            String command = parts[0].toLowerCase();


            try {

                // MOVE
                if (command.equals("move")) {

                    if (parts.length < 2) {

                        System.out.println(
                                "Please specify a direction."
                        );

                        continue;
                    }

                    String direction = parts[1].toLowerCase();

                    currentRoom = currentRoom.move(direction);

                    currentRoom.displayRoom();
                }


                // LOOK
                else if (command.equals("look")) {

                    currentRoom.displayRoom();
                }


                // INTERACT
                else if (command.equals("interact")) {

                    if (parts.length < 2) {

                        System.out.println(
                                "Please specify an entity."
                        );

                        continue;
                    }

                    String entityName = parts[1];

                    Entity entity =
                            currentRoom.findEntity(entityName);

                    System.out.println(entity.interact());
                    System.out.println();
                }


                // EXIT or QUIT
                else if (command.equals("exit")
                        || command.equals("quit")) {

                    System.out.println();
                    System.out.println(
                            "Thanks for visiting! Goodbye."
                    );

                    running = false;
                }


                // Unknown command
                else {

                    System.out.println(
                            "Unknown command. Try move, look, interact, or exit."
                    );
                }


            } catch (InvalidDirectionException e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );

            } catch (EntityNotFoundException e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }
        }

        scanner.close();
    }
}