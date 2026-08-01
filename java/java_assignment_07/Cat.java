public class Cat extends Animal {
    
    @Override
    void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    void describe() {
        System.out.println("Cat rubs up against a box.");
    }

}
