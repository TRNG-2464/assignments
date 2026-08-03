public class Cat extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public void describe() {
        System.out.println("The cat stretches and curls up for a nap.");
    }

}