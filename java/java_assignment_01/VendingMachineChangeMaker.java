import java.util.Scanner;

public class VendingMachineChangeMaker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.print("Enter price amount: $");
        double price = sc.nextDouble();
        System.out.print("Enter inserted amount: $");
        double amount = sc.nextDouble();

        System.out.printf("Input: price = $%.2f, amountInserted = $%.2f", price, amount);
        System.out.println();
        verifyPurchase(price, amount);

        sc.close();
        System.out.println();
    }

    public static void verifyPurchase(double price, double amountInserted) {
      double calculateChange = Math.abs((price - amountInserted));
        if (price < 0.0) {
          System.err.println("Invalid input: price cannot be negative!");
        } else if (amountInserted < 0.0) {
          System.err.println("Invalid input: amount inserted cannot be negative!");
        } else if (amountInserted < price) {
          System.out.printf("Insufficient funds! Please insert $%.2f more", calculateChange);
          System.err.println();
        } else {
          System.out.printf("Purchase successful! Change due: $%.2f", calculateChange);
          System.err.println();
        }
    }

}