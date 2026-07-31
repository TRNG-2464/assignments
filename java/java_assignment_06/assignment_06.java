//package java.java_assignment_06;

import java.util.Scanner;

public class assignment_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;

        while (true) {
            System.out.print("Enter a command: ");
            String command = scanner.next();
            int num = 0;
            if (command.equalsIgnoreCase("exit")) {
                String finalMessage = "Goodbye! Final total: " + total;
                System.out.println(finalMessage);
                break;
            }
            if(command.equalsIgnoreCase("reset")){
                total = 0;
                System.out.println("Running total has been reset to 0.");
                continue;
            }
            if(command.equalsIgnoreCase("total")){
                System.out.println("Current total: " + total);
                continue;
            }
            if (!command.equalsIgnoreCase("add") && !command.equalsIgnoreCase("subtract")) {
                String invalidCommand = "Unrecognized command: '" + command + "'";;
                System.out.println(invalidCommand);
                scanner.nextLine(); // Clear the invalid input
                continue;
            }
            if(scanner.hasNextInt()){
                num = scanner.nextInt();
            }
            else{
                String invalidInput = "'" + command + "' requires a valid number. Please try again.";
                System.out.println(invalidInput);
                scanner.nextLine(); // Clear the invalid input
                continue;
            }
            if (command.equalsIgnoreCase("add")) {
                total += num;
                String sumMessage = "Added " + num + ". Running total: " + total;
                System.out.println(sumMessage);
            }
            else if (command.equalsIgnoreCase("subtract")){
                total -= num;
                String diffMessage = "Subtracted " + num + ". Running total: " + total;
                System.out.println(diffMessage);
            }
        }
        scanner.close();    
    }

}
