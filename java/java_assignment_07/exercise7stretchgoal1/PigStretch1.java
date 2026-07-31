package stretch1.exercise7;

public class Pig extends Animal {
    int age;
    public Pig(String name, String color, String size, String noise) {
        super(name, color, size, noise);
    }
    public Pig(String name, String color, String size, String noise, int age) {
        super(name, color, size, noise);
        this.age = age;
    }
    public void describe() {
        super.describe();
        System.out.println("He is " + this.age + " years old");
    }
    public void makeSound() {
        super.makeSound();
    }
}
