package com.mycompany.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Room {

    private String name, description;
    private LinkedHashSet<String> directionalExits;
    private ArrayList<Entity> entityObjects;

    // Additional functionality, stored references to connecting rooms
    private HashMap<String,Room> connections;

    public Room(String name,
            String description,
            LinkedHashSet<String> directionalExits,
            ArrayList<Entity> entityObjects) {
        this.name = name;
        this.description = description;
        this.directionalExits = directionalExits;
        this.entityObjects = entityObjects;
        this.connections = new HashMap<>();
    }

    public void addConnection(String direction,Room room) {
        connections.put(direction,room);
    }

    public Room getConnectingRoom(String direction) {
        return connections.get(direction);
    }

    public HashMap<String,Room> getConnections() {
        return connections;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LinkedHashSet<String> getDirectionalExits() {
        return directionalExits;
    }

    public ArrayList<Entity> getEntityObjects() {
        return entityObjects;
    }

}
