package com.bassem.java_assignment_07;

public class Dog extends Animal {
    @Override
    public void makeSound(){
        System.out.println("Woof! Woof!");
    }
    @Override
    public void describe(){
        System.out.println("The dog wags its tail excitedly and looks up to you.");
    }
}
