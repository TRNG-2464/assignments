
import java.util.*;

abstract class Entity {
    private String name;
    private String description;
    abstract public String interact();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Entity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

class Chair extends Entity {
    @Override
    public String interact() {
        return "You sit on the chair.";
    }

    public Chair() {
        super("Chair", "Wooden chair");
    }
}

class Apple extends Entity {
    @Override
    public String interact() {
        return "You take a bite.";
    }

    public Apple() {
        super("Apple", "Red rotten apple");
    }
}

class Fan extends Entity {
    @Override
    public String interact() {
        return "You stand in front of the fan. Feeling the breeze.";
    }

    public Fan() {
        super("Fan", "Dusty white fan");
    }
}

class Bed extends Entity {
    @Override
    public String interact() {
        return "You lay on the bed and take a nap.";
    }

    public Bed() {
        super("Bed", "Neatly made, king-sized bed");
    }
}

class Toilet extends Entity {
    @Override
    public String interact() {
        return "You flush the toilet.";
    }

    public Toilet() {
        super("Toilet", "White, round, one-piece toilet");
    }
}

class Sink extends Entity {
    @Override
    public String interact() {
        return "You wash your hands with.";
    }

    public Sink() {
        super("Sink", "White ceramic bathroom sink.");
    }
}

class Exit {
    String direction;
    Room room;

    Exit(String direction, Room room) {
        this.direction = direction;
        this.room = room;
    }
}

class Room {
    private String name;
    private String description;
    private List<Exit> exits;
    private List<Entity> entities;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new ArrayList<Exit>();
        this.entities = new ArrayList<Entity>();
    }

    public void addExit(Exit exit) {
        exits.add(exit);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public List<Entity> getEntities() {
        return this.entities;
    }
    public List<Exit> getExits() {
        return this.exits;
    }
}

class BadMoveException extends Exception {
    String direction;
    public BadMoveException(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}

class EntityNotFoundException extends Exception {
    String name;

    public EntityNotFoundException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class main {

    static Room currentRoom;
    static boolean running;

    static void move(Room room, String direction) throws BadMoveException {
        for (Exit exit : room.getExits()) {
            if (exit.direction.equals(direction)) {
                currentRoom = exit.room;
                return;
            }
        }

        throw new BadMoveException(direction);
    }

    static void interact(Room room, String name) throws EntityNotFoundException {
        List<Entity> entities = room.getEntities();
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            if (e.getName().toLowerCase().equals(name)) {
                System.out.println("You check the " + e.getName() + ". " + e.interact());
                return;
            }
        }

        throw new EntityNotFoundException(name);
    }

    public static void main(String[] args) {
        Room livingRoom = new Room("Living room", "A dim living room, with boarded up windows.");
        Room kitchen = new Room("Kitchen", "A disheveled kitchen.");
        Room bedroom = new Room("Bedroom", "A bright and clean bedroom.");
        Room garage = new Room("Garage", "A garage with a leaky ceiling and a flickering bulb.");
        Room bathroom = new Room("Bathroom", "A spotless bathroom.");

        kitchen.addEntity(new Apple());
        livingRoom.addEntity(new Chair());
        bedroom.addEntity(new Chair());
        bedroom.addEntity(new Bed());
        garage.addEntity(new Fan());
        bathroom.addEntity(new Sink());
        bathroom.addEntity(new Toilet());

        livingRoom.addExit(new Exit("north", kitchen));
        kitchen.addExit(new Exit("south", livingRoom));

        kitchen.addExit(new Exit("east", garage));
        garage.addExit(new Exit("west", kitchen));

        kitchen.addExit(new Exit("west", bedroom));
        bedroom.addExit(new Exit("east", kitchen));

        bedroom.addExit(new Exit("north", bathroom));
        bathroom.addExit(new Exit("south", bedroom));

        Scanner sc = new Scanner(System.in);

        running = true;
        currentRoom = livingRoom;
        boolean moved = true;

        while (running) {
            if (moved) {
                Room room = currentRoom;
                System.out.println("You are in the " + room.getName() + ".");
                System.out.println(room.getDescription());
                System.out.print("Interactable entities: ");
                List<Entity> entities = room.getEntities();
                for (int i = 0; i < entities.size(); i++) {
                    Entity e = entities.get(i);
                    System.out.print(e.getName());
                    if (i != entities.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
                moved = false;
            }

            System.out.print("Enter a command: ");

            String line = sc.nextLine();
            String[] tokens = line.toLowerCase().split(" ");

            String cmd = tokens[0];

            try {
                switch (cmd) {
                case "move": {
                    String direction = tokens[1];
                    move(currentRoom, direction);
                    moved = true;
                    break;
                }

                case "interact": {
                    String name = tokens[1];
                    interact(currentRoom, name);
                    break;
                }

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("Error: '" + cmd + "' is not a valid command.");
                    break;
                }
            } catch (BadMoveException e) {
                System.out.println("There is no exit to the " + e.getDirection() + " from here.");
            } catch (EntityNotFoundException e) {
                System.out.println("There is no '" + e.getName() + "' here to interact with.");
            }
        }
    }
}
