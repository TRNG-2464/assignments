public class PaymentExpiredException extends PaymentException {

    public PaymentExpiredException() {
        super("Payment method expired.");
    }

}