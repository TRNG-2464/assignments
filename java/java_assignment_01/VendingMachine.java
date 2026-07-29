public class VendingMachine {
    static int DOLLAR = 100;
    static int QUARTER = 25;
    static int DIME = 10;
    static int NICKEL = 5;
    static int PENNY = 1;

    public String insertMoney(double cost, double amount) {
        if (cost < 0) {
            return "Item price cannot be negative";
        }

        if (amount < 0) {
            return "Amount inserted cannot be negative";
        }

        if (amount < cost) {
            double remaining = cost - amount;
            return String.format("Insufficient funds. Please insert $%.2f more.", remaining);
        }

        double change = amount - cost;
        return String.format("Purchase successful. Change due: $%.2f", change);
    }
    
    // Stretch Goals
    // Multiple Items / Running Total
    public String insertMoney(double[] costs, double amount) {
        int totalCost = 0;
        for (int i = 0; i < costs.length; i++) {
            totalCost += costs[i];
        }

        if (totalCost < 0) {
            return "Item price cannot be negative";
        }

        if (amount < 0) {
            return "Amount inserted cannot be negative";
        }

        if (amount < totalCost) {
            double remaining = totalCost - amount;
            return String.format("Insufficient funds. Please insert $%.2f more.", remaining);
        }

        double change = amount - totalCost;
        return String.format("Purchase successful. Change due: $%.2f", change);
    }

    public String getChange(double amount) {
        int currentAmount = (int) amount * 100; // convert to cents
        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        dollars = currentAmount / VendingMachine.DOLLAR;
        currentAmount = currentAmount % VendingMachine.DOLLAR;

        quarters = currentAmount / VendingMachine.QUARTER;
        currentAmount = currentAmount % VendingMachine.QUARTER;

        dimes = currentAmount / VendingMachine.DIME;
        currentAmount = currentAmount % VendingMachine.DIME;

        nickels = currentAmount / VendingMachine.NICKEL;
        currentAmount = currentAmount % VendingMachine.NICKEL;

        pennies = currentAmount / VendingMachine.PENNY;
        currentAmount = currentAmount % VendingMachine.PENNY;

        return String.format("Dollars: %d\nQuarters: %d\nDimes: %d\nNickels: %d\nPennies: %d\n", dollars, quarters, dimes, nickels, pennies);
    }

}