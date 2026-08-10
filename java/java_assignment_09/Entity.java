public class Entity {

    private String name;
    private String description;
    private String interactionResponse;

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