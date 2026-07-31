package stretch1.exercise7;

public class Horse extends Animal {
    boolean isShowPony;
    public Horse(String name, String color, String size, String noise) {
        super(name, color, size, noise);
    }
    public Horse(String name, String color, String size, String noise, boolean isShowPony) {
        super(name, color, size, noise);
        this.isShowPony = isShowPony;
    }
    public void describe() {
        super.describe();
        if (this.isShowPony) {
            System.out.println("It's a show pony!");
        }
    }
    public void makeSound() {
        super.makeSound();
    }
}
