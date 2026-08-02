package com.bassem.java_assignment_07;

public class  Cat extends Animal{

    @Override
    public void makeSound(){
        System.out.println("Meow! Meow!");
    }

    @Override
    public void describe(){
        System.out.println("The cat stretches lazily and looks around the room.");
    }
}
