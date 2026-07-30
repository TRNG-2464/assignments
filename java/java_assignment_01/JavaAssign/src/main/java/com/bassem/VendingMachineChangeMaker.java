package com.bassem;

public class VendingMachineChangeMaker {

    public String countChange(double price,double amountIn){

        // ## invalid input check
          if(price <0)
              return "Invalid input :price cant be negative:";

        if(amountIn <0)
            return "Invalid input :amount given  cant be negative:";

        // check if not Enough money... short
        if(amountIn < price){
            double addCoin = price-amountIn;
            return String.format("insufficient funds. please add more: $%.2f", addCoin) ;
        }
        // successful
        double change = amountIn-price;
               // return change as two decimal places as .00
       return  String.format("transaction is ok. do not forget your change: $%.2f", change );
    }
}
