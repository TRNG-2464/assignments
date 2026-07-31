import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    
    private String command = "";
    private int total = 0;
    private ArrayList<String> commandHistory = new ArrayList<>();
    private ArrayList<Integer> totalHistory = new ArrayList<>();    // could have multiple undos

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("exit")) {
            System.out.print("Enter a command: ");
            command = scanner.nextLine();
            String[] commandParts = command.split(" ");

            if (commandParts.length == 1) {
                if (commandParts[0].equals("exit")) {
                    System.out.println(String.format("Goodbye! Final total: %d%n", total));
                    commandHistory.add(command);
                } else if (commandParts[0].equals("total")) {
                    System.out.println(String.format("Current total: %d%n", total));
                    commandHistory.add(command);
                } else if (commandParts[0].equals("reset")) {
                    total = 0;
                    System.out.println(String.format("Running total has been reset to %d.%n", total));
                    commandHistory.add(command);
                    totalHistory.add(total);
                } else if (commandParts[0].equals("history")) {
                    System.out.println("History:");
                    for (int i = commandHistory.size() - 1; i >= 0; i--) {
                        System.out.println(commandHistory.get(i));
                    }
                    System.out.println("");
                } else if (commandParts[0].equals("undo")) {
                    handleUndo();
                } else {
                    System.out.println(String.format("Unrecognized command: '%s'%n", command));
                }
            } else if (commandParts.length == 2) {
                int number;
                try { 
                    number = Integer.parseInt(commandParts[1]);  
                } catch(NumberFormatException e){  
                    System.out.println("'add' requires a valid number. Please try again.%n");
                    continue;
                }  

                if (commandParts[0].equals("add")) {
                    total += number;
                    System.out.println(String.format("Added %d. Running total: %d%n", number, total));
                    commandHistory.add(command);
                    totalHistory.add(total);
                } else if (commandParts[0].equals("subtract")) {
                    total -= number;
                    System.out.println(String.format("Subtracted %d. Running total: %d%n", number, total));
                    commandHistory.add(command);
                    totalHistory.add(total);
                } else {
                    System.out.println(String.format("Unrecognized command: '%s'%n", command));
                }
            } else {
                System.out.println(String.format("Unrecognized command: '%s'%n", command));
            }
        }
        scanner.close();;
    }

    private void handleUndo() {
        if (commandHistory.size() == 0) {
            System.out.println("No previous operation to undo.");
        }
        String previousCommand = commandHistory.get(commandHistory.size() - 1);
        String[] commandParts = previousCommand.split(" ");

        if (commandParts.length == 1 && commandParts[0].equals("reset")) {
            totalHistory.remove(totalHistory.size() - 1);
            total = totalHistory.get(totalHistory.size() - 1);
            System.out.println(String.format("Running total has been reset to %d.%n", total));
            commandHistory.add(command);
        } else if (commandParts.length == 2) {
            int number;
            try { 
                number = Integer.parseInt(commandParts[1]);  
            } catch(NumberFormatException e){  
                System.out.println("'add' requires a valid number. Please try again.%n");
                return;
            }  

            if (commandParts[0].equals("add")) {
                totalHistory.remove(totalHistory.size() - 1);
                total = totalHistory.get(totalHistory.size() - 1);
                System.out.println(String.format("Undo Added %d. Running total: %d%n", number, total));
                commandHistory.add(command);
            } else if (commandParts[0].equals("subtract")) {
                totalHistory.remove(totalHistory.size() - 1);
                total = totalHistory.get(totalHistory.size() - 1);
                System.out.println(String.format("Undo Subtracted %d. Running total: %d%n", number, total));
                commandHistory.add(command);
            } else {
                System.out.println(String.format("Unrecognized command: '%s'%n", command));
            }
        } else {
            System.out.println(String.format("Unrecognized previous command: '%s'%n", previousCommand));
        }
    }
}
