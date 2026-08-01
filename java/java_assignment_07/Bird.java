public class Bird extends Animal {
    
    @Override
    void makeSound() {
        System.out.println("Chirp Chirp!");
    }

    @Override
    void describe() {
        System.out.println("Bird flaps its wings.");
    }

}
