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

    public String interact() {
        return interactionResponse;
    }
}
