package com.mycompany.app;

public class InvalidQuantityException extends InventoryException{
    public InvalidQuantityException(String message){
        super(message);
    }

    public InvalidQuantityException(){
        super("Order request is zero or negative");
    }
    
}
