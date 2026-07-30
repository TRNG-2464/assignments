package Zoo;

public class Bird extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Tweet! Tweet!");
    }

    @Override
    public void describe() {
        System.out.println("The bird tilts its head and hops along its perch.");
    }
}