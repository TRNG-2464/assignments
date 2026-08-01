class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}

class PaymentDeclinedException extends PaymentException {

    public PaymentDeclinedException() {
        super("Payment declined. Insufficient funds.\n");
    }


}

class PaymentExpiredException extends PaymentException {

    public PaymentExpiredException() {
        super("Payment method expired.\n");
    }

}
