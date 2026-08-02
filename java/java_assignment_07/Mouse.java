package com.mycompany.app;

public class Mouse extends Animal{

    @Override
    public String makeSound() {
        return "Squeak!";
    }

    @Override
    public String describe() {
        return "Natural enemy of the cat.";
    }
    
}
