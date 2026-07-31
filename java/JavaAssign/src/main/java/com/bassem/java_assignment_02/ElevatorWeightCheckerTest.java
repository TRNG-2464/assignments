package com.bassem.java_assignment_02;

public class ElevatorWeightCheckerTest {
    public static void main(String[] args){

        // case 1 overload
        System.out.println("1: Overload occurs");
        double[] passenger1 = {150, 200, 300, 250, 180};
        String result =ElevatorWeightChecker.checkWeightLimit(1000,passenger1);
        System.out.println(result);

        System.out.println( "2: All passengers board safely.");
        double[] passenger2 = {150, 200, 300};
        result =ElevatorWeightChecker.checkWeightLimit(1000,passenger2);
        System.out.println(result);

        System.out.println("3: Exact limit match counts as overload");
        double[] passenger3 = {200, 300};
        result = ElevatorWeightChecker.checkWeightLimit(500, passenger3);
        System.out.println(result);

        System.out.println("4: First passenger exceeds limit");
        double[] passenger4 = {150, 200};
        result = ElevatorWeightChecker.checkWeightLimit(100, passenger4);
        System.out.println(result);

        System.out.println("5: Empty passenger list");
        double[] passenger5 = {};
        result = ElevatorWeightChecker.checkWeightLimit(1000, passenger5);
        System.out.println(result);


    }
}
