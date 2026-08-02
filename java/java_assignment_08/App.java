
public class App {

    public static void main(String[] args) {

        try {
            order("video_tape", 1, 0, 5, 2, false);
        } catch (OutOfStockException | InvalidQuantityException | PaymentExpiredException | PaymentDeclinedException e) {
            System.err.println(e);
        }

        try {
            order("video_tape", 1, 1, 5, 2, true);
        } catch (OutOfStockException | InvalidQuantityException | PaymentExpiredException | PaymentDeclinedException e) {
            System.err.println(e);
        }

    }

    public static boolean order(String item,
            int requested_quantity,
            int available_stock,
            double payment_amount,
            double total_cost,
            boolean paymentExpired) throws InvalidQuantityException, PaymentExpiredException, OutOfStockException, PaymentDeclinedException {
        // Validate inventory rules first
        if (requested_quantity <= 0) {
            throw new InvalidQuantityException();
        }

        if (requested_quantity > available_stock) {
            throw new OutOfStockException();
        }

        // Validate payment related rules
        if (paymentExpired) {
            throw new PaymentExpiredException();
        }

        if (payment_amount < total_cost) {
            throw new PaymentDeclinedException();
        }

        return true;
    }

}
