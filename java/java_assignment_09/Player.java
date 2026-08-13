import java.util.HashSet;

public class Player {
    HashSet<Entity> inventory = new HashSet<>();
    Room currentRoom = null;

    public void interact(String entityName) throws EntityNotFoundException {
        for (int i = 0; i < currentRoom.entities.size(); i++) {
            if (currentRoom.entities.get(i).name.equals(entityName)) {
                Entity entity = currentRoom.entities.get(i);
                entity.interact();
                return;
            }
        }

        throw new EntityNotFoundException("Error: Entity not found " + entityName);
    }

    public void pickUp(String itemName) {
        for (int i = 0; i < currentRoom.entities.size(); i++) {
            if (currentRoom.entities.get(i).name.equals(itemName)) {
                Entity item = currentRoom.entities.remove(i);
                inventory.add(item);
                return;
            }
        }
    }

    public void displayInventory() {

    }

    public void move(Direction direction) throws InvalidDirectionException, MissingKeyException {
        if (currentRoom == null) {
            throw new InvalidDirectionException("Error: Player is not in a room" );
        }

        Room nextRoom = currentRoom.directions.get(direction);
        if (nextRoom == null) {
            throw new InvalidDirectionException("Error: There is no room in direction " + direction);
        }

        if (nextRoom instanceof TreasureRoom) {
            Entity key = getKey();
            if (key == null) {
                throw new MissingKeyException("Error: The room " + nextRoom.name + " requires a Key");
            }

            TreasureRoom lockedRoom = (TreasureRoom) nextRoom;
            lockedRoom.unlockRoom(key);
        }
        currentRoom = nextRoom;
    }

    public Entity getKey() {
        for (Entity entity : inventory) {
            if (entity.name.equals("Key")) {
                return entity;
            }
        }

        return null;
    }
}
