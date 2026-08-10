package exercise9;

import java.util.HashMap;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private HashMap<String, String> adjacentRooms;
    private List<Entity> entities;

    public Room(String name, String description, HashMap<String, String> adjacentRooms, List<Entity> entities) {
        this.name = name;
        this.description = description;
        this.adjacentRooms = adjacentRooms;
        this.entities = entities;
    }

    public List<Entity> getEntities() {
        return this.entities;
    }
    public HashMap<String, String> getAdjacentRooms() {
        return this.adjacentRooms;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public void intro() {
        System.out.println("You are in the " + this.name);
        System.out.println(this.description);
        System.out.println("Entities: " + this.entities);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room{name='").append(this.name).append('\'');
        sb.append(", description='").append(this.description).append('\'');
        sb.append(", adjacentRooms=").append(this.adjacentRooms);
        sb.append(", entities=").append(this.entities);
        sb.append('}');
        return sb.toString();
    }

}
