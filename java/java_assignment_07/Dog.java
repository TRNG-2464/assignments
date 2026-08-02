package com.mycompany.app;

public class Dog extends Animal{
    public Dog(){}
    @Override
    public String makeSound(){
        return "Woof!";

    }
    @Override
    public String describe(){
        return "Man\'s best friend.";
        
    }
    
}
