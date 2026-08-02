package com.bassem.java_assignment_06;
import java.util.Scanner;
public class CommandBasedCalculatorTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CommandBasedCalculator calculator = new CommandBasedCalculator();


        while (true) {
            System.out.print("Enter a command");
            // all command to read as "add 5"
            String input = scanner.nextLine();
            String result= calculator.handleCommand(input);
            System.out.println(result);
            if (input.equals("exit")) {
                break;
            }

        }
             scanner.close();
    }
}



