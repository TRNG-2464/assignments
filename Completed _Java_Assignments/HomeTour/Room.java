package HomeTour;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Entity> entities;

    public Room(String name, String description){
        this.name = name;
        this.description=description;
        exits = new HashMap<>();
        entities = new ArrayList<>();
    }

    public void addExit(String direction, Room room){
        exits.put(direction.toLowerCase(),room);
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public void display() {

        System.out.println(name);
        System.out.println(description);

        System.out.print("Interactable entities: ");

        if (entities.isEmpty()) {
            System.out.println("None");
            return;
        }

        for (Entity e : entities) {
            System.out.print(e.getEntityName() + " ");
        }

        System.out.println();
    }

    public Room getExit(String direction) throws InvalidDirectionException {
        Room next = exits.get(direction.toLowerCase());

        if (next == null) {
            throw new InvalidDirectionException("There is no exit that way.");
        }

        return next;
    }

    public Entity getEntity(String name)
        throws EntityNotFoundException{
        for(Entity e :entities){
            if(e.getEntityName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        throw new EntityNotFoundException(
                "No entity named " + name
        );
    }
}
