package com.mycompany.app;

public class PaymentDeclinedException extends PaymentException{
    public PaymentDeclinedException(String message){
        super(message);
    }

    public PaymentDeclinedException(){
        super("Payment amount is less than total cost.");
    }
    
}
