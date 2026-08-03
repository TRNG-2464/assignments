public class VendingMachine {

    // Base activity
    public String transaction(double itemPrice, double insertedAmount) {
        if (itemPrice < 0) {
            return "Invalid input: item price cannot be negative.";
        } else if (insertedAmount < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        } else if (insertedAmount < itemPrice) {
            double amountNeeded = itemPrice - insertedAmount;
            return String.format("Insufficient funds. Please insert $%.2f more.", amountNeeded);
        } else {
            double change = insertedAmount - itemPrice;
            return String.format("Purchase successful. Change due: $%.2f", change);
        }
    }

    // Stretch goal 1: multiple items / running total
    public String transactionMultipleItems(double[] itemPrices, double insertedAmount) {
        if (itemPrices == null) {
            return "Invalid input: item price list cannot be null.";
        }

        double totalCost = 0;

        for (double itemPrice : itemPrices) {
            if (itemPrice < 0) {
                return "Invalid input: item prices cannot be negative.";
            }
            totalCost += itemPrice;
        }

        if (insertedAmount < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        } else if (insertedAmount < totalCost) {
            double amountNeeded = totalCost - insertedAmount;
            return String.format(
                    "Insufficient funds. Total cost: $%.2f. Please insert $%.2f more.",
                    totalCost,
                    amountNeeded
            );
        } else {
            double change = insertedAmount - totalCost;
            return String.format(
                    "Purchase successful. Total cost: $%.2f. Change due: $%.2f",
                    totalCost,
                    change
            );
        }
    }

    // Stretch goal 2: transaction with denomination breakdown
    public String transactionWithChange(double itemPrice, double insertedAmount) {
        if (itemPrice < 0) {
            return "Invalid input: item price cannot be negative.";
        } else if (insertedAmount < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        } else if (insertedAmount < itemPrice) {
            double amountNeeded = itemPrice - insertedAmount;
            return String.format("Insufficient funds. Please insert $%.2f more.", amountNeeded);
        } else {
            double change = insertedAmount - itemPrice;
            return String.format("Purchase successful. Change due: $%.2f. %s", change, calculateChange(change));
        }
    }

    static String calculateChange(double change) {
        if (change < 0) {
            return "Invalid change amount.";
        }

        // Convert to cents first to avoid floating-point remainder problems.
        int remainingCents = (int) Math.round(change * 100);

        int ones = remainingCents / 100;
        remainingCents %= 100;

        int quarters = remainingCents / 25;
        remainingCents %= 25;

        int dimes = remainingCents / 10;
        remainingCents %= 10;

        int nickels = remainingCents / 5;
        int pennies = remainingCents % 5;

        return "Denominations: "
                + ones + " one-dollar bill(s), "
                + quarters + " quarter(s), "
                + dimes + " dime(s), "
                + nickels + " nickel(s), and "
                + pennies + " penny/pennies.";
    }

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        System.out.println("BASE ACTIVITY");
        System.out.println("1. Purchase with change:");
        System.out.println(machine.transaction(1.50, 2.00));

        System.out.println("\n2. Insufficient funds:");
        System.out.println(machine.transaction(1.50, 1.00));

        System.out.println("\n3. Exact payment:");
        System.out.println(machine.transaction(1.50, 1.50));

        System.out.println("\n4. Negative item price:");
        System.out.println(machine.transaction(-1.50, 2.00));

        System.out.println("\n5. Negative inserted amount:");
        System.out.println(machine.transaction(1.50, -1.00));

        System.out.println("\nSTRETCH GOAL 1: MULTIPLE ITEMS");
        double[] coveredItems = {1.25, 2.50, 0.75};
        System.out.println(machine.transactionMultipleItems(coveredItems, 5.00));

        double[] underpaidItems = {1.25, 2.50, 0.75};
        System.out.println(machine.transactionMultipleItems(underpaidItems, 4.00));

        double[] invalidItems = {2.00, -0.50, 1.00};
        System.out.println(machine.transactionMultipleItems(invalidItems, 5.00));

        System.out.println("\nSTRETCH GOAL 2: DENOMINATIONS");
        System.out.println(machine.transactionWithChange(1.59, 5.00));
        System.out.println(machine.transactionWithChange(1.50, 1.50));
    }
}
