/**
 * Builds the house layout: a set of connected Room instances,
 * populated with Entities. Kept separate from Main to keep the
 * command loop focused on parsing/dispatching commands.
 */
public class House {

    /**
     * Builds and wires up the rooms, and returns the room the player
     * should start in.
     */
    public static Room build() {
        Room foyer = new Room("Foyer",
                "A small entryway with a coat rack and a stairway leading up.");
        Room kitchen = new Room("Kitchen",
                "A bright kitchen with the smell of fresh coffee.");
        Room livingRoom = new Room("LivingRoom",
                "A cozy living room with a couch and an old television.");
        Room basement = new Room("Basement",
                "A dim, unfinished basement. It smells faintly of sawdust.");
        Room backyard = new Room("Backyard",
                "A small backyard with a wood pile stacked against the fence.");

        // Entities
        foyer.addEntity(new Entity("CoatRack",
                "A wooden rack by the door.",
                "You check the CoatRack. There's an old raincoat hanging on it."));

        kitchen.addEntity(new Entity("CoffeeMaker",
                "A drip coffee maker, still warm.",
                "You pour yourself a cup of fresh coffee. It smells wonderful."));
        kitchen.addEntity(new Entity("Refrigerator",
                "A humming refrigerator covered in magnets.",
                "You open the Refrigerator. There's leftover pizza and some milk."));

        livingRoom.addEntity(new Entity("Couch",
                "A worn but comfortable couch.",
                "You sink into the Couch for a moment. Very relaxing."));
        livingRoom.addEntity(new Entity("Television",
                "An old television with a thick layer of dust.",
                "You turn on the Television. It's just static."));

        backyard.addEntity(new Entity("Woodpile",
                "A stack of firewood next to the fence.",
                "You look over the Woodpile. Good, dry firewood for winter."));

        // Basement has no entities to start with, demonstrating the
        // "(none)" case in Room.display().

        // Exits (wired both directions so the layout is consistent)
        foyer.setExit("north", kitchen);
        kitchen.setExit("south", foyer);

        foyer.setExit("east", livingRoom);
        livingRoom.setExit("west", foyer);

        kitchen.setExit("down", basement);
        basement.setExit("up", kitchen);

        kitchen.setExit("east", backyard);
        backyard.setExit("west", kitchen);

        return foyer;
    }
}
