package com.mycompany.app;

public class PaymentExpiredException extends PaymentException {

    public PaymentExpiredException(String message) {
        super(message);
    }

    public PaymentExpiredException() {
        super("Payment method marked as expired.");
    }

}
