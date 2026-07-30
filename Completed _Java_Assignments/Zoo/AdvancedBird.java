package Zoo;

public class AdvancedBird extends Bird {
    private final boolean canFly;

    public AdvancedBird(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public void describe() {
        super.describe();
        if (canFly) {
            System.out.println("Fun Fact: This bird loves soaring through the open skies!");
        } else {
            System.out.println("Fun Fact: This is a flightless bird that prefers running on land.");
        }
    }
}