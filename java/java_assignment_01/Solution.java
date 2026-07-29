import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;
import java.util.ArrayList;

public class Solution{
    /**
     * Main assignment method. Takes in a price and the amount of money inserted, printing out the remaining change as well as handling all failure cases.
     * @param price the price of the item
     * @param input the money inserted
     */

     static String handlePurchase(double price, double input){
        if (input < 0){
            return "Invalid input: cannot put in negative money.";

        }
        else if (price < 0){
            return "Invalid input: price cannot be negative.";
        }
        double remainder = input - price;
        if (remainder < 0){
            return "Insufficient funds. Please insert $" + -remainder + " more.";
        }
        else{
            return "Purchase successful. Your change is $" + remainder + ".";
        }
    }

    /**
     * Stretch Goal 1: very similar to the handlePurchase method, except that we sum up all the prices (while ensuring each price is individually valid).
     * @param prices the array of item prices
     * @param input the money inserted
     */
    static String handlePurchaseList(double[] prices, double input){
        if (input < 0){
            return "Invalid input: cannot put in negative money.";
        }
        double priceTotal = 0;
        for (double price: prices){
            if (price < 0){
                return "Invalid input: price cannot be negative.";
            }
            priceTotal += price;
        }

        // once we've summed up the price of all the items we can handle it identically to our first method

        double remainder = input - priceTotal;
        if (remainder < 0){
            return "Insufficient funds. Please insert $" + -remainder + " more.";
        }
        else{
            return "Purchases successful. Your change is $" + remainder + ".";
        }
    }

    /**
     * Stretch Goal 2: break down money into the fewest possible bills and coins, reporting values for each denomination.
     * My strategy here is to work downwards.
     * @param input the amount of money to break down into change
     */
    static void makeChange(double input){
        int counter = 0;
        int intInput = (int)Math.round(input * 100);

        // take as many 1 dollar bills as we can
        while (intInput >= 100){
            counter++;
            intInput -= 100;
        }
        System.out.println(counter + " 1$ bills.");
        counter = 0;

        // take as many quarters as we can
        while (intInput >= 25){
            counter++;
            intInput -= 25;
        }
        System.out.println(counter + " quarters.");
        counter = 0;

        // take as many dimes as we can
        while (intInput >= 10){
            counter++;
            intInput -= 10;
        }
        System.out.println(counter + " dimes.");
        counter = 0;

        // take as many nickels as we can
        while (intInput >= 5){
            counter++;
            intInput -= 5;
        }
        System.out.println(counter + " nickels.");
        counter = 0;

        System.out.println(intInput + " pennies.");
    }

    public static void main(String[] args){
        System.out.println(handlePurchase(0, 0)); // Output: Purchase successful. Your change is $0.0.
        System.out.println(handlePurchase(-1, 1)); // Output: Invalid input: price cannot be negative.
        System.out.println(handlePurchase(1, -1)); // Output: Invalid input: cannot put in negative money.
        System.out.println(handlePurchase(2.5, 1.5)); // Output: Insufficient funds. Please insert $1.0 more.
        System.out.println(handlePurchase(1.5, 2.5)); // Output: Purchase successful. Your change is $1.0.
        System.out.println(handlePurchase(2.5, 2.5)); // Output: Purchase successful. Your change is $0.0.
    }
}