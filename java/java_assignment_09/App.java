package com.mycompany.app;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // House

        // North room 
        ArrayList<Entity> northRoomEntities = new ArrayList<>();
        Entity redPhone = new Entity("Phone", "A red landline phone.");
        Entity pens = new Entity("Pens", "A small pile of pens.");
        northRoomEntities.add(redPhone);
        northRoomEntities.add(pens);
        LinkedHashSet<String> northExits = new LinkedHashSet<>();
        northExits.add("south");

        Room northRoom = new Room("North Room",
                "The north room",
                northExits,
                northRoomEntities);

        // East room 
        ArrayList<Entity> eastRoomEntities = new ArrayList<>();
        Entity vase = new Entity("Vase", "A ceramic vase.");
        Entity rug = new Entity("Rug", "A woven rug.");
        eastRoomEntities.add(vase);
        eastRoomEntities.add(rug);
        LinkedHashSet<String> eastExits = new LinkedHashSet<>();
        eastExits.add("west");

        Room eastRoom = new Room("East Room",
                "The east room",
                eastExits,
                eastRoomEntities);

        // South room 
        ArrayList<Entity> southRoomEntities = new ArrayList<>();
        Entity mirror = new Entity("Mirror", "A tall standing mirror.");
        Entity candle = new Entity("Candle", "A lit candle.");
        southRoomEntities.add(mirror);
        southRoomEntities.add(candle);
        LinkedHashSet<String> southExits = new LinkedHashSet<>();
        southExits.add("north");

        Room southRoom = new Room("South Room",
                "The south room",
                southExits,
                southRoomEntities);

        // West room 
        ArrayList<Entity> westRoomEntities = new ArrayList<>();
        Entity clock = new Entity("Clock", "An old grandfather clock.");
        Entity book = new Entity("Book", "A dusty book.");
        westRoomEntities.add(clock);
        westRoomEntities.add(book);
        LinkedHashSet<String> westExits = new LinkedHashSet<>();
        westExits.add("east");

        Room westRoom = new Room("West Room",
                "The west room",
                westExits,
                westRoomEntities);

        // Center room
        ArrayList<Entity> centerRoomEntities = new ArrayList<>();
        Entity nothing = new Entity("Nothing", "There is nothing here.");
        centerRoomEntities.add(nothing);
        LinkedHashSet<String> centerExits = new LinkedHashSet<>();
        centerExits.add("north");
        centerExits.add("south");
        centerExits.add("east");
        centerExits.add("west");

        Room centerRoom = new Room("Center Room",
                "The center room",
                centerExits,
                centerRoomEntities);

        // Start the player in the center room
        Room currentRoom = centerRoom;

        // Building the house
        // Connecting center to north room
        centerRoom.addConnection("north", northRoom);
        northRoom.addConnection("south", centerRoom);

        // Connecting center to east room
        centerRoom.addConnection("east", eastRoom);
        eastRoom.addConnection("west", centerRoom);

        // Connecting center to south room
        centerRoom.addConnection("south", southRoom);
        southRoom.addConnection("north", centerRoom);

        // Connecting center to west room
        centerRoom.addConnection("west", westRoom);
        westRoom.addConnection("east", centerRoom);

        // Game loop
        try (Scanner scanner = new Scanner(System.in)) {
            String input;
            do {
                System.out.print("Command: ");
                input = scanner.nextLine().trim().toLowerCase();

                String[] arguments = input.split(" ");

                // Handle the player's command
                switch (arguments[0]) {
                    case "look":
                        look(currentRoom);
                        break;
                    case "interact":
                        try {
                            interactObject(currentRoom, arguments[1]);
                        } catch (EntityNotFoundException e) {
                            System.err.println(e);
                        }
                        break;
                    case "move":
                        // Move in a direction
                        try {
                            currentRoom = moveRoom(currentRoom, arguments[1]);
                        } catch (InvalidDirectionException e) {
                            System.err.println(e);
                        }
                        
                        break;
                    case "quit":
                        // Exit the game
                        break;
                    default:
                        System.out.println("Unrecognized command");
                }

            } while (!input.equals("quit"));

        } catch (Exception e) {
        }

    }

    public static Room moveRoom(Room currentRoom, String direction) throws InvalidDirectionException{
        Room newRoom = currentRoom.getConnectingRoom(direction);
        if (newRoom == null) {
            System.err.println("Cant go " + direction);
            throw new InvalidDirectionException();
        }
        System.out.println("Moved " + direction + " to " + newRoom.getName());
        return newRoom;
    }

    public static boolean validateInput(String s) {
        String[] args = s.split(" ");
        if (args.length > 2) {
            System.out.println("Too many arguments.");
            return false;
        }

        boolean valid = true;

        if (args.length == 2) {
            if (!args[0].equals("move") && !args[0].equals("interact")) {
                System.out.println("Unrecognized command " + args[0]);
                valid = false;
            }

            if (args[0].equals("move")
                    && !args[1].equals("north") && !args[1].equals("south")
                    && !args[1].equals("east") && !args[1].equals("west")) {
                System.out.println("Unrecognized argument " + args[1]);
                valid = false;
            }
        } else if (!args[0].equals("quit") && !args[0].equals("look")) {
            System.out.println("Unrecognized command " + args[0]);
            valid = false;
        }

        return valid;

    }

    public static void look(Room room) {
        System.out.println("Current room ");
        System.out.println("Name:" + room.getName() + " Desc:" + room.getDescription());
        ArrayList<Entity> objects = room.getEntityObjects();
        System.out.println("Current Objects");
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i).getName());
        }
    }

    public static boolean interactObject(Room room, String name) throws EntityNotFoundException {
        ArrayList<Entity> objects = room.getEntityObjects();
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                System.out.println(objects.get(i).interact());
                return true;
            }
        }
        System.out.println("That is not an object in " + room.getName());
        throw new EntityNotFoundException();
    }

}
