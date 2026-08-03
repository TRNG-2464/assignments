import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Room currentRoom = House.build();
        Scanner scanner = new Scanner(System.in);

        currentRoom.display();

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.print("Enter a command: ");

            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            switch (command) {
                case "move":
                    if (argument.isEmpty()) {
                        System.out.println("Error: Move where? Try 'move north'.");
                        break;
                    }
                    try {
                        currentRoom = currentRoom.getExit(argument);
                        System.out.println();
                        currentRoom.display();
                    } catch (InvalidDirectionException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "look":
                    currentRoom.display();
                    break;

                case "interact":
                    if (argument.isEmpty()) {
                        System.out.println("Error: Interact with what?");
                        break;
                    }
                    try {
                        Entity entity = currentRoom.getEntity(argument);
                        System.out.println(entity.interact());
                    } catch (EntityNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "exit":
                case "quit":
                    System.out.println("Thanks for visiting! Goodbye.");
                    running = false;
                    break;

                default:
                    System.out.println("Error: Unknown command '" + command + "'.");
                    break;
            }
        }

        scanner.close();
    }
}
