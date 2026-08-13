import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Room {
    String name;
    String description;
    HashMap<Direction, Room> directions = new HashMap<>();
    ArrayList<Entity> entities = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void printRoom() {
        System.out.printf("You are are in the %s%n", name);
        System.out.println(description);
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < entities.size(); i++) {
            sb.append(entities.get(i).name);
            if (i < entities.size() - 1) {
                sb.append(", ");
            }
        }

        System.out.printf("Interactable entities: %s%n%n", sb.toString());
    }
}