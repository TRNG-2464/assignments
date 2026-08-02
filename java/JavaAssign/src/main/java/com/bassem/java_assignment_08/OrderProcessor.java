package com.bassem.java_assignment_08;

public class OrderProcessor {
    // make function to go through all hierarchy exception class
    public void processOrder(
            // all argument to check the errors
        String item,
        int requestedQuantity,
        int availableStock,
        double paymentAmount,
        double orderTotal,
        boolean payExpire
    ) throws InventoryException,PaymentException{ // parent Exception then go to child

        // check Quantity in
        if(requestedQuantity<=0){
            throw new InvalidQuantityException(
                    " Invalid quantity. Quantity must be greater than 0."
            );
        }

        // check stock available
        if(availableStock < requestedQuantity){
            throw new OutOfStockException(
                    "Out of stock. Request " + requestedQuantity
                    + ", only " + availableStock + " available."
            );
        }

        // check payment
         if(payExpire){
             throw new PaymentDeclinedException(
                     "Payment method expired."
             );
         }

        // 4. Check payment amount
        if (paymentAmount < orderTotal) {
            throw new PaymentDeclinedException(
                    "Payment declined. Insufficient funds."
            );
        }


        // Successful operation
        System.out.println(
                "Order Successfully! " + requestedQuantity
                        + " x " + item + " confirmed."
        );
    }
}
