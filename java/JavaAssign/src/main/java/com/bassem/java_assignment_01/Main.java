package com.bassem;

public class Main {
      public static void main(String[] args){
            VendingMachineChangeMaker machine = new VendingMachineChangeMaker();
            System.out.println(machine.countChange(1.50,2.00));
          System.out.println(machine.countChange(1.50,1.00));
          System.out.println(machine.countChange(1.50,1.50));
          System.out.println(machine.countChange(-2.00,5.00));
          System.out.println(machine.countChange(1.50,-1.00));

      }
}
