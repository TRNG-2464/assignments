public class Entity {
    String name;
    String description;

    public Entity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void interact() {
        System.out.printf("You check the %s. %s%n", name, description);
    }
}