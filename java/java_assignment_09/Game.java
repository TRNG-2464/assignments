import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Game {
    public static void main(String[] args) {
        startGame();
    }

    static void startGame() {
        Room livingRoom = new LivingRoom(
            "Living Room",
            "You are in the Living Room. There is a key. There is a room to the right.",
            false
        );
        
        Room bathRoom = new BathRoom(
            "BathRoom",
            "You are in the bathroom. There is a door north and west. There is a sink.", 
            false
        );

        Room treasureRoom = new TreasureRoom(
            "Treasure Room",
            "You are in the treasure room. There is a chest. There is a room south."
        );

        Room bossRoom = new BossRoom(
            "Boss Room",
            "You are in the boss room. There is a giant slime. Sneak pass the boss and go down the stairs"
        );

        Room basement = new Basement(
            "Basement",
            "You are in the basement. Congrats, you reached the end!",
            false
        );

        livingRoom.directions.put(Direction.EAST, bathRoom);
        livingRoom.entities.add(new Entity("Key", "An item to unlock a door."));
        
        bathRoom.directions.put(Direction.WEST, livingRoom);
        bathRoom.directions.put(Direction.NORTH, treasureRoom);
        bathRoom.directions.put(Direction.EAST, bossRoom);

        treasureRoom.directions.put(Direction.SOUTH, bathRoom);
        treasureRoom.entities.add(new Entity("Chest", "A chest that contains items"));

        bossRoom.directions.put(Direction.WEST, bathRoom);
        bossRoom.directions.put(Direction.DOWN, basement);
        bossRoom.entities.add(new Entity("Slime", "A giant blue slime."));

        basement.directions.put(Direction.UP, bossRoom);
        basement.entities.add(new Entity("Cake", "A vanilla birthday cake."));

        Player player = new Player();
        player.currentRoom = livingRoom;

        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")) {
            player.currentRoom.printRoom();
            System.out.print("Enter a command: ");
            command = scanner.nextLine();
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "move": // move [direction]
                    if (parts.length != 2) {
                        System.out.println("Error: please specify direction");
                        break;
                    }
                    
                    Optional<Direction> direction = Direction.fromString(parts[1]);
                    if (!direction.isPresent()) {
                        System.out.println("Error: Invalid direction " + parts[1]);
                        break;
                    }

                    try {
                        player.move(direction.get());
                    } catch(InvalidDirectionException e) {
                        System.out.println(e.getMessage());
                    } catch (MissingKeyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "look":
                    player.currentRoom.printRoom();
                    break;
                case "interact": // interact [entity name]
                    if (parts.length != 2) {
                        System.out.println("Error: Please specifiy entity name");
                        break;
                    }
                    String entityName = parts[1];
                    try {
                        player.interact(entityName);
                    } catch(EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "take":
                    if (parts.length != 2) {
                        System.out.println("Error: Please specifiy item name");
                        break;
                    }
                    String itemName = parts[1];
                    player.pickUp(itemName);
                    break;
                case "exit":
                    break;
            }
        }

    }
}
