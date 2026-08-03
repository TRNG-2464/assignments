
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String mode = args.length > 0 ? args[0].toLowerCase() : "basic";

        switch (mode) {
            case "history":
                System.out.println("Running Calculator with command history support.");
                calculator.runWithHistory();
                break;
            case "undo":
                System.out.println("Running Calculator with undo support.");
                calculator.runWithUndo();
                break;
            case "basic":
            default:
                System.out.println("Running basic Calculator.");
                calculator.run();
                break;
        }
    }

    private final Scanner scanner = new Scanner(System.in);
    private int total = 0;
    private boolean isRunning = true;
    private Deque<Integer> previousTotalsDeque = new ArrayDeque<Integer>();
    private List<String> previousCommands = new ArrayList<>();

    public void run(){

        while (this.isRunning){
            System.out.print("Please enter a command.");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()){
                continue;
            }

            String[] wholeCommand = input.split("\\s+");
            String command = wholeCommand[0].toLowerCase();

            switch (command){
                case "add":
                    if (wholeCommand.length != 2) {
                        System.out.println("Please use add with 1 number only");
                    } else{
                        try {
                            int toAdd = Integer.parseInt(wholeCommand[1]);
                            this.total += toAdd;
                            System.out.println("Added" + toAdd + ". Running total:" + this.total);
                        } catch (Exception e) {
                            System.out.println("Error: Add requires using 1 number");
                        }
                        
                    }
                    break;

                case "subtract":
                    if (wholeCommand.length != 2) {
                        System.out.println("Please use subtract with 1 number only");
                    } else{
                        try {
                            int toSubtract  = Integer.parseInt(wholeCommand[1]);
                            this.total -= toSubtract;
                            System.out.println("Subtracted" + toSubtract + ". Running total:" + this.total);
                        } catch (Exception e) {
                            System.out.println("Error: Subtract requires using 1 number");
                        }
                        
                    }
                    break;
                case "reset":
                    this.total = 0;
                    System.out.println("Running total has been reset to 0");
                    break;
                case "total":
                    System.out.println("Current total: " + this.total);
                    break;
                case "exit":
                    System.out.println("Goodbye! Final total: " + this.total);
                    this.isRunning = false;
                    this.total = 0;
                    this.scanner.close();
                    break;
                default:
                    System.err.println("Unrecognized Command: " + input) ;
            }

        }
        

    }

     public void runWithHistory(){

        while (this.isRunning){
            System.out.print("Please enter a command.");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()){
                continue;
            }

            String[] wholeCommand = input.split("\\s+");
            String command = wholeCommand[0].toLowerCase();

            switch (command){
                case "add":
                    if (wholeCommand.length != 2) {
                        System.out.println("Please use add with 1 number only");
                    } else{
                        try {
                            int toAdd = Integer.parseInt(wholeCommand[1]);
                            this.total += toAdd;
                            System.out.println("Added" + toAdd + ". Running total:" + this.total);
                            this.previousCommands.add(input);
                        } catch (Exception e) {
                            System.out.println("Error: Add requires using 1 number");
                        }
                        
                    }
                    break;

                case "subtract":
                    if (wholeCommand.length != 2) {
                        System.out.println("Please use subtract with 1 number only");
                    } else{
                        try {
                            int toSubtract  = Integer.parseInt(wholeCommand[1]);
                            this.total -= toSubtract;
                            System.out.println("Subtracted" + toSubtract + ". Running total:" + this.total);
                            this.previousCommands.add(input);
                        } catch (Exception e) {
                            System.out.println("Error: Subtract requires using 1 number");
                        }
                        
                    }
                    break;
                case "reset":
                    this.total = 0;
                    System.out.println("Running total has been reset to 0");
                    this.previousCommands.add(input);
                    break;
                case "total":
                    System.out.println("Current total: " + this.total);
                    this.previousCommands.add(input);
                    break;
                case "history":
                    System.out.println("The history of commands that were run so far that were valid were:");
                    for (String previousCommand: this.previousCommands){
                        System.out.println(previousCommand);
                    }
                    this.previousCommands.add(input);
                    break;
                case "exit":
                    System.out.println("Goodbye! Final total: " + this.total);
                    this.isRunning = false;
                    this.total = 0;
                    this.scanner.close();
                    break;
                default:
                    System.err.println("Unrecognized Command: " + input) ;
            }

        }
        

    }


    // Stretch Goal 2
    public void runWithUndo(){
        while (this.isRunning){
            System.out.print("Please enter a command.");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()){
                continue;
            }

            String[] wholeCommand = input.split("\\s+");
            String command = wholeCommand[0].toLowerCase();

            switch (command){
                case "add":
                    if (wholeCommand.length != 2) {
                        System.out.println("Please use add with 1 number only");
                    } else{
                        try {
                            int toAdd = Integer.parseInt(wholeCommand[1]);
                            this.previousTotalsDeque.push(this.total);
                            this.total += toAdd;
                            System.out.println("Added " + toAdd + ". Running total: " + this.total);
                        } catch (Exception e) {
                            System.out.println("Error: Add requires using 1 number");
                        }
                        
                    }
                    break;

                case "subtract":
                    if (wholeCommand.length != 2) {
                        System.out.println("Please use subtract with 1 number only");
                    } else{
                        try {
                            int toSubtract  = Integer.parseInt(wholeCommand[1]);
                            this.previousTotalsDeque.push(this.total);
                            this.total -= toSubtract;
                            System.out.println("Subtracted " + toSubtract + ". Running total: " + this.total);
                        } catch (Exception e) {
                            System.out.println("Error: Subtract requires using 1 number");
                        }
                        
                    }
                    break;
                case "reset":
                    this.previousTotalsDeque.push(this.total);
                    this.total = 0;
                    System.out.println("Running total has been reset to 0");
                    break;
                case "total":
                    System.out.println("Current total: " + this.total);
                    break;
                case "undo":
                    if (!this.previousTotalsDeque.isEmpty()){
                        this.total = this.previousTotalsDeque.pop();
                        System.out.println("Last command undone, Current total: " + this.total);
                    } else {
                        System.out.println("There was no last command run");
                    }
                    break;
                case "exit":
                    System.out.println("Goodbye! Final total: " + this.total);
                    this.previousTotalsDeque.clear();
                    this.total = 0;
                    isRunning = false;
                    this.scanner.close();
                    return;
                default:
                    System.err.println("Unrecognized Command: " + input) ;
            }

        }
        

    }
    
}
