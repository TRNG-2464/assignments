package com.bassem.java_assignment_08;

public class OrderProcessorTest {
    public static void main(String[] args) {

        OrderProcessor process = new OrderProcessor();

        // check 1 . out of stock
        try {
            process.processOrder("Widget", 5, 2,
                 50.00,50.00,false );
        }catch (OutOfStockException e){
            System.out.println("Order failed:" +e.getMessage());
        } catch (InventoryException e) {
            System.out.println("Inventory problem: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment problem: " + e.getMessage());
        }

        // check 2 Quantity
           try {
               process.processOrder(
                       "Widget", -1, 10,
                       50.00, 50.00, false

               );
           }catch(InventoryException e){
               System.out.println("Order failed: " + e.getMessage());
           }catch (PaymentException e){
               System.out.println("Payment problem: " + e.getMessage());
           }
       // check 3 payment declined
        try {
            process.processOrder(
                    "Widget", 2, 10,
                    10.00, 50.00, false
            );
        } catch (InventoryException e) {
            System.out.println("Inventory problem: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
        // check 4 payment expired
        try {
            process.processOrder(
                    "Widget", 2, 10,
                    50.00, 50.00, true
            );
        } catch (InventoryException e) {
            System.out.println("Inventory problem: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        // check 5
        try {
            process.processOrder(
                    "Widget", 2, 10,
                    50.00, 50.00, false
            );
        } catch (InventoryException e) {
            System.out.println("Inventory problem: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment problem: " + e.getMessage());
        }

    }

}
