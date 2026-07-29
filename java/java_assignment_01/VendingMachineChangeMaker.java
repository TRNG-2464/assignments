package com.mycompany.app;


public class VendingMachineChangeMaker {

    public static void main(String[] args) {
        System.out.println(vendingMachineChangeMaker(1.5, 2.00));
        System.out.println(vendingMachineChangeMaker(1.5, 1));
        System.out.println(vendingMachineChangeMaker(1.5, 1.5));
        System.out.println(vendingMachineChangeMaker(1.5, -1));
        System.out.println(vendingMachineChangeMaker(-1.5, -1));

    }

    public static String vendingMachineChangeMaker(double itemPrice, double moneyInserted) {
        if (itemPrice < 0) {
            return "Invalid input: item price cannot be negative";
        }

        if (moneyInserted < 0) {
            return "Invalid input: amount inserted cannot be negative";
        }

        double difference = moneyInserted - itemPrice;

        if (difference < 0) {
            return String.format(
                    "Insufficient funds. Please insert $%.2f more",
                    -difference
            );
        }

        return String.format(
                "Purchase successful. Change due: $%.2f",
                difference
        );
    }
}