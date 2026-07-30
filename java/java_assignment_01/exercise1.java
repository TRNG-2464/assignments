public class exercise1 {
    public static void main(String [] args) {
        System.out.print(stretchGoal2(12, 13.43));
    }
    public static String invalidOrValid(double price, double paid) {
        if (price < 0) {
            return "Invalid input: price cannot be negative.";
        }
        if (paid < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        if (paid < price) {
            return "Insufficient funds. Please insert $" + (price-paid) + " more";
        }
        return "Purchase successful. Change due: $" + (paid-price);
    }
    public static String stretchGoal1(double[] prices, double paid) {
        double price = 0;
        for (double i : prices) {
            if (i < 0) {
                return "Invalid input: price cannot be negative.";
            }
            price += i;
        }
        if (paid < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        if (paid < price) {
            return "Insufficient funds. Please insert $" + (price-paid) + " more";
        }
        return "Purchase successful. Change due: $" + (paid-price);
    }

    public static String stretchGoal2(double price, double paid) {
        if (price < 0) {
            return "Invalid input: price cannot be negative.";
        }
        if (paid < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }
        double amountOwed = Math.max(price, paid) - Math.min(price, paid);
        StringBuilder denominations = new StringBuilder();
        if (amountOwed >= 1) {
            int ones = (int) Math.floor(amountOwed);
            denominations.append(ones).append(" dollar bills, ");
            amountOwed -= ones;
        }
        int quarters = (int) Math.floor(amountOwed / 0.25);
        if (quarters > 0) {
            denominations.append(quarters).append(" quarters, ");
            amountOwed -= quarters * 0.25;
        }
        int dimes = (int) Math.floor(amountOwed / 0.10);
        if (dimes > 0) {
            denominations.append(dimes).append(" dimes, ");
            amountOwed -= dimes * 0.10;
        }
        int nickels = (int) Math.floor(amountOwed / 0.05);
        if (nickels > 0) {
            denominations.append(nickels).append(" nickels, ");
            amountOwed -= nickels * 0.05;
        }
        int pennies = (int) Math.round(amountOwed * 100);
        if (pennies > 0) {
            denominations.append(pennies).append(" pennies");
        }
        if (paid < price) {
            return "Insufficient funds. Please insert " + denominations + " more";
        }
        return "Purchase successful. Change due: " + denominations;
    }
}