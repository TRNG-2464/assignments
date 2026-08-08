package com.mycompany.app;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(){
        super("That is not a valid Entity");
    }
    
}
