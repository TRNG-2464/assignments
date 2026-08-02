package com.mycompany.app;

public class Cat extends Animal{

    @Override
    public String makeSound() {
        return "Meow!";
    }

    @Override
    public String describe() {
        return "It hunts mice.";
    }
    
}
