import java.util.*;


public class VendingMachineChangeMaker {

    public static String processPurchase(double price, double amountInserted) {

        // Check for invalid inputs first
        if (price < 0 && amountInserted < 0) {
            return "Invalid input: item price and amount inserted cannot be negative.";
        } else if (price < 0) {
            return "Invalid input: item price cannot be negative.";
        } else if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        // Check whether more money is needed
        if (amountInserted < price) {
            double amountNeeded = price - amountInserted;

            return "Insufficient funds. Please insert $" + amountNeeded;
        }

        // Successful purchase
        double change = amountInserted - price;

        return "Purchase successful. Change due: $" + change;
    }


    // Stretch Goal 1:
    // Accepts multiple item prices and one amount inserted
    public static String processMultipleItems(
            double[] itemPrices,
            double amountInserted
    ) {

        if (itemPrices == null) {
            return "Invalid input: item price list cannot be null.";
        }

        if (amountInserted < 0) {
            return "Invalid input: amount inserted cannot be negative.";
        }

        double totalPrice = 0;

        for (double price : itemPrices) {
            if (price < 0) {
                return "Invalid input: item prices cannot be negative.";
            }

            totalPrice += price;
        }

        if (amountInserted < totalPrice) {
            double amountNeeded = totalPrice - amountInserted;

            return "Insufficient funds. Total cost: $ " + totalPrice + "\nPlease insert $ " + amountNeeded;
        }

        double change = amountInserted - totalPrice;

        return "Purchase successful. Total cost: $" + totalPrice + "Change due: $ " + change;
    }


    // Stretch Goal 2:
    // Breaks change into the fewest standard denominations
    public static String makeChange(double changeAmount) {

        if (changeAmount < 0) {
            return "Invalid input: change amount cannot be negative.";
        }

        // Convert dollars to cents to avoid most floating-point issues
        int remainingCents = (int) Math.round(changeAmount * 100);

        int oneDollarBills = remainingCents / 100;
        remainingCents %= 100;

        int quarters = remainingCents / 25;
        remainingCents %= 25;

        int dimes = remainingCents / 10;
        remainingCents %= 10;

        int nickels = remainingCents / 5;
        remainingCents %= 5;

        int pennies = remainingCents;

        return "Change breakdown for $ " + changeAmount + "\n$1 bills: " + oneDollarBills + "\nQuarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies;
    }


    // Program testing
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

    System.out.println("Vending Machine Change Maker");
    System.out.println("1. Purchase one item");
    System.out.println("2. Purchase multiple items");
    System.out.println("3. Make change");

    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();

    if (choice == 1) {

        // Call the base method
        System.out.print("Enter the item price: $");
        double price = scanner.nextDouble();

        System.out.print("Enter the amount inserted: $");
        double amountInserted = scanner.nextDouble();

        System.out.println(
                processPurchase(price, amountInserted)
        );

    } else if (choice == 2) {

        // Call the multiple-items stretch method
        System.out.print("How many items are being purchased? ");
        int numberOfItems = scanner.nextInt();

        double[] itemPrices = new double[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            System.out.print(
                    "Enter the price of item " + (i + 1) + ": $"
            );

            itemPrices[i] = scanner.nextDouble();
        }

        System.out.print("Enter the amount inserted: $");
        double amountInserted = scanner.nextDouble();

        System.out.println(
                processMultipleItems(itemPrices, amountInserted)
        );

    } else if (choice == 3) {

        // Call the change-denomination stretch method
        System.out.print("Enter the amount of change: $");
        double changeAmount = scanner.nextDouble();

        System.out.println(
                makeChange(changeAmount)
        );

    } else {

        System.out.println("Invalid menu choice.");
    }

    scanner.close();
    }  
}