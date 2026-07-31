//package java.java_assignment_07;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        makeSound();
        describe();
    }

    public abstract void makeSound();
    public abstract void describe();
}
