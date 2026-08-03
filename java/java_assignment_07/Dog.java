public class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void describe() {
        System.out.println("The dog wags its tail excitedly and looks up at you.");
    }
}