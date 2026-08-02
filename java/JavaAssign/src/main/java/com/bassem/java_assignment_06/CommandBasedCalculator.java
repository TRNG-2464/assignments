package com.bassem.java_assignment_06;

public class CommandBasedCalculator {
     // total initial by 0
    private int result = 0;
    public   String handleCommand(String input) {

        // split into array has 2 part as ["add", "5"
        String[] parts = input.split(" ");
        // first part is always command ex. "add"
        String command = parts[0];
        //Keep asking for commands until the user enters "exit"

        switch (command){
            // handle add,subtract
            case "add":

                if (parts.length < 2) {
                    return "'add' requires a valid number. Please try again";

                }
                try {
                    // parse number from string to int
                    int num = Integer.parseInt(parts[1]);
                    result += num;
                    // got suitable msg with either add/subtract.

                    return "Added " + num + ". Running total: " + result;
                }
                catch(NumberFormatException e){
                    return "'add' requires a valid number. Please try again.";
                }

            case "subtract":
                if (parts.length < 2) {

                    return "'subtract' requires a valid number. Please try again";

            }
                try {
                    // parse number from string to int
                    int num = Integer.parseInt(parts[1]);
                    result -= num;

                    // got suitable msg with either add/subtract.
                    return "Subtracted " + num + ". Running total: " + result;
                }
                catch(NumberFormatException e){
                    return "'subtract' requires a valid number. Please try again.";
                }

                // handel reset and total
                // Reset the running total back to zero
            case "reset":
                result = 0;
                return "Running total has been reset to 0.";
            case "total":
               return  "Current total: " + result;
            case "exit":
               return  "Goodbye! Final total: " + result;
            default:
                // these exp handle special input not number as letters
                return "Unrecognized command: '" + command + "'" ;
        }

    }
}
