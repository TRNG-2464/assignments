package stretch1.exercise7;

public class Bird extends Animal {
    boolean canFly;
    public Bird(String name, String color, String size, String noise) {
        super(name, color, size, noise);
    }
    public Bird(String name, String color, String size, String noise, boolean canFly) {
        super(name, color, size, noise);
        this.canFly = canFly;
    }
    public void describe() {
        super.describe();
        if (this.canFly) {
            System.out.println("It can fly!");
        }
    }
    public void makeSound() {
        super.makeSound();
    }
}
