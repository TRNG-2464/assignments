/**
 * Represents an interactable object that can be placed in a Room
 * (e.g. a CoatRack or a CoffeeMaker).
 *
 * Entity names are expected to be a single word so that command
 * parsing (splitting on whitespace) stays simple.
 */
public class Entity {

    private final String name;
    private final String description;
    private final String interactionResponse;

    public Entity(String name, String description, String interactionResponse) {
        this.name = name;
        this.description = description;
        this.interactionResponse = interactionResponse;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Produces the response shown to the player when they interact
     * with this entity.
     */
    public String interact() {
        return interactionResponse;
    }

    @Override
    public String toString() {
        return name;
    }
}
