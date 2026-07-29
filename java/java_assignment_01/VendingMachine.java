public class VendingMachine {

    public static String processPurchase(double price, double amountInserted) {
        if (price < 0) {
            return "Invalid input: item price cannot be negative.";
        }
        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        if (amountInserted < price) {
            double needed = price - amountInserted;
            return String.format("Insufficient funds. Please insert $%.2f more.", needed);
        }

        double change = amountInserted - price;
        return String.format("Purchase successful. Change due: $%.2f", change);
    }

    public static void main(String[] args) {
        System.out.println(processPurchase(1.50, 2.00)); 
        System.out.println(processPurchase(1.50, 1.00));
        System.out.println(processPurchase(1.50, 1.50));
        System.out.println(processPurchase(1.50, -1.00));
        System.out.println(processPurchase(-5.00, 10.00));
    }
}
