//package java.java_assignment_07;

public class Bird extends Animal {
    public Bird(){
        super("Bird");
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet! Tweet!");
    }

    @Override
    public void describe() {
        System.out.println("The bird tilts its head and hops along its perch.");
    }

}
