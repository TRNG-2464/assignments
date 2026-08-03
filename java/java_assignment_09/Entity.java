//package java.java_assignment_09;

public class Entity {
    private final String name;
    private final String description;
    private final String interactionResponse;

    public Entity(String name, String description, String interactionResponse) {
        if (name == null || name.isBlank() || name.contains(" ")) {
            throw new IllegalArgumentException("Name cannot be null, blank, or contain spaces.");
        }
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
