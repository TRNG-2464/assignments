//Anmoldeep Excercise 1

public class VendingMachine {

    public static void main(String[] args) {

        System.out.println(processPurchase(1.50, 2.00));
        System.out.println(processPurchase(15.50, 1.00));
        System.out.println(processPurchase(1.50, 1.50));
        System.out.println(processPurchase(1.50, -1.00));

        System.out.println();

        // Stretch Goal 1: Multiple Items / Running Total
        double[] items = {1.25, 2.50, 0.75};
        System.out.println(processMultipleItems(items, 5.00));

        System.out.println();

        // Stretch Goal 2: Making Change in Denominations
        makeChange(3.41);
    }


// single item purchase
    public static String processPurchase(double price, double amountInserted) {

        // Invalid input checks
        if (price < 0) {
            return "Invalid input: item price cannot be negative.";
        }
        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        // Insufficient funds
        if (amountInserted < price) {
            double needed = price - amountInserted;
            return String.format(
                    "Insufficient funds. Please insert $%.2f more.",
                    needed
            );
        }
        // Successful purchase
        double change = amountInserted - price;
        return String.format(
                "Purchase successful. Change due: $%.2f",
                change
        );
    }

//Stretch Goal 1: Handles multiple item purchases.
    public static String processMultipleItems(double[] prices, double amountInserted) {

        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        double total = 0;
        // Calculate total price
        for (double price : prices) {
            if (price < 0) {
                return "Invalid input: item price cannot be negative.";
            }
            total += price;
        }
        // Check if enough money was inserted
        if (amountInserted < total) {
            double needed = total - amountInserted;
            return String.format(
                    "Insufficient funds. Please insert $%.2f more.",
                    needed
            );
        }
        // Successful purchase
        double change = amountInserted - total;
        return String.format(
                "Purchase successful. Change due: $%.2f",
                change
        );
    }

// Stretch Goal 2: Breaks change into the fewest bills and coins.
    public static void makeChange(double change) {

        // Convert dollars to cents
        int cents = (int) Math.round(change * 100);
        int dollars = cents / 100;
        cents %= 100;
        
        int quarters = cents / 25;
        cents %= 25;

        int dimes = cents / 10;
        cents %= 10;

        int nickels = cents / 5;
        cents %= 5;

        int pennies = cents;

        System.out.println("Change Breakdown");
        System.out.println("$1 Bills: " + dollars);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + pennies);
    }
}