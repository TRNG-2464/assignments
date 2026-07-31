//package java.java_assignment_08;

public class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException() {
        super("Payment method declined. Insufficient funds.");
    }
    
}
