//package java.java_assignment_07;

public class Cat extends Animal {
    public Cat(){
        super("Cat");
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void describe() {
        System.out.println("The cat stretches lazily before settling down in your lap.");
    }
}
