public class Dog  extends Animal {

    @Override
    void makeSound() {
        System.out.println("Woof Woof!");
    }

    @Override
    void describe() {
        System.out.println("Dog wags tail in excitement.");
    }

}
