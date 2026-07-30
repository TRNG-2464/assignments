package Zoo;

public class AdvancedDog extends Dog {
    private final String breed;

    public AdvancedDog(String breed) {
        this.breed = breed;
    }

    @Override
    public void describe() {
        // Keeps original behavior and adds the new attribute safely
        super.describe();
        System.out.println("Fun Fact: This dog is a beautiful " + breed + ".");
    }
}