//package java.java_assignment_08;

public class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException() {
        super("Payment method expired.");
    }
}