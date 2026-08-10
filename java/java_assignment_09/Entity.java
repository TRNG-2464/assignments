package exercise9;

public class Entity {
    private String name;
    private String description;

    public Entity(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public void interact(String message) {
        System.out.println(message);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Entity: ").append(this.name);
        sb.append(". Description: ").append(this.description);
        sb.append('}');
        return sb.toString();
    }
}
