class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}

class PaymentDeclinedException extends PaymentException {
    public PaymentDeclinedException() {
        super("Order failed: Payment declined. Insufficient funds.");
    }
}

class PaymentExpiredException extends PaymentException {
    public PaymentExpiredException() {
        super("Order failed: Payment method expired.");
    }
}