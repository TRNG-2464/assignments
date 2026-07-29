public class main {

    static void paySingle(double price, double amount) {
        if (price < 0) {
            System.out.println("Invalid input: price of item cannot be negative.");
        } else if (amount < 0) {
            System.out.println("Invalid input: amount inserted cannot be negative.");
        } else if (amount < price) {
            System.out.println("Insufficient funds. Plese insert $" + (price - amount) + " more.");
        } else if (amount >= price) {
            System.out.println("Purchase successful. Change due: $" + (amount - price));
        }
    }

    static void payItems(double[] prices, double amount) {
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }

        if (amount < sum) {
            System.out.println("Insufficient funds. Please insert $" + (sum - amount) + " more.");
        } else {
            System.out.println("Purchase successful. Change due $" + (amount - sum));
        }
    }

    static void getChange(double amount) {
        int dollars = 0, quarters = 0, dimes = 0, nickels = 0, pennies = 0;

        int cents = (int)(amount * 100.0);

        while (cents > 0) {
            if (cents >= 100) {
                dollars += 1;
                cents -= 100;
            } else if (cents >= 25) {
                quarters += 1;
                cents -= 25;
            } else if (cents >= 10) {
                dimes += 1;
                cents -= 10;
            } else if (cents >= 5) {
                nickels += 1;
                cents -= 5;
            } else if (cents >= 1) {
                pennies += 1;
                cents -= 1;
            }
        }

        System.out.println("$" + amount + " in change:");
        System.out.println("Dollars: " + dollars);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("pennies: " + pennies);
    }

    public static void main(String[] args) {
        paySingle(2, 2);

        payItems(new double[]{10.0, 20.0, 30.0}, 100.0);

        getChange(8.93);
    }
}
