import java.util.Scanner;
import java.util.ArrayList;

// small helper class to relate commands and vals. Useful for parsing as well as for history later on.
class CommandEntry{
    String command;
    int val;
    int currVal;
    CommandEntry(String command, int val){
        this.command = command;
        this.val = val;
        this.currVal = 0;
    }
}

public class Solution{

    static Scanner sc = new Scanner(System.in);

    /**
     * Main Assignment Code
     * parses a string to check if it's valid, then constructs the command class appropriately.
     * @return a valid CommandEntry, or null
     */
    static CommandEntry parseString(){
        System.out.print("Enter a command: ");
        String input = sc.nextLine();

        String[] arr = input.split(" ");
        if (arr.length == 0){
            System.out.println("Blank command is not allowed.");
            return null;
        }

        int target_length;
        if (arr[0].equals("add") || arr[0].equals("subtract")){
            target_length = 2;
        }
        else if (arr[0].equals("reset") || arr[0].equals("total") || arr[0].equals("exit")){
            target_length = 1;
        }
        else{
            System.out.println("Command not recognized.");
            return null;
        }
        if (arr.length != target_length){
            System.out.println("Invalid number of arguments. Please enter the command and then a number, separated by spaces.");
            return null;
        }

        int val = 0;
        if (target_length == 2){
            try{
                val = Integer.parseInt(arr[1]);
            }
            catch(Exception e){
                System.out.println("Invalid value entered. Please input a valid integer.");
                return null;
            }
        }

        return new CommandEntry(arr[0], val);
    }

    /**
     * Main Assignment Code
     * Runs an infinite loop until "exit" is written, performing appropriate operations.
     */
    static void run(){
        int curr = 0;

        while (true){
            CommandEntry cmd = null;
            do{
                cmd = parseString();
            }
            while (cmd == null);

            switch (cmd.command){
                case "add":
                    curr += cmd.val; break;
                case "subtract":
                    curr -= cmd.val; break;
                case "total":
                    System.out.println("Current total: " + curr); break;
                case "reset":
                    curr = 0; break;
                default:
                    System.out.println("Goodbye!"); return;
            }
        }
    }

    /**
     * Stretch Goals 1 AND 2
     * I don't want to implement these methods with minor changes for each one, so I'm adding support for both!
     * @return a valid CommandEntry, or null
     */
    static CommandEntry parseStringExtended(){
        System.out.print("Enter a command: ");
        String input = sc.nextLine();

        String[] arr = input.split(" ");
        if (arr.length == 0){
            System.out.println("Blank command is not allowed.");
            return null;
        }

        int target_length;
        if (arr[0].equals("add") || arr[0].equals("subtract")){
            target_length = 2;
        }
        else if (arr[0].equals("reset") || arr[0].equals("total") || arr[0].equals("exit") || arr[0].equals("history") || arr[0].equals("undo")){
            target_length = 1;
        }
        else{
            System.out.println("Command not recognized.");
            return null;
        }
        if (arr.length != target_length){
            System.out.println("Invalid number of arguments. Please enter the command and then a number, separated by spaces.");
            return null;
        }

        int val = 0;
        if (target_length == 2){
            try{
                val = Integer.parseInt(arr[1]);
            }
            catch(Exception e){
                System.out.println("Invalid value entered. Please input a valid integer.");
                return null;
            }
        }

        return new CommandEntry(arr[0], val);
    }

    /**
     * Stretch Goals 1 AND 2
     * Runs an infinite loop until "exit" is written, performing appropriate operations.
     */
    static void runExtended(){
        int curr = 0;
        ArrayList<CommandEntry> list = new ArrayList<>();

        while (true){
            CommandEntry cmd = null;
            do{
                cmd = parseStringExtended();
            }
            while (cmd == null);

            // add to history for every command that's not undo
            
            if (!cmd.command.equals("undo")){
                cmd.currVal = curr;
                list.add(cmd);
            }

            switch (cmd.command){
                case "undo":
                    if (list.size() == 0){
                        System.out.println("No operations to undo!");
                        break;
                    }
                    curr = list.get(list.size() - 1).currVal;
                    list.remove(list.size() - 1);
                    break;

                case "exit":
                    System.out.println("Goodbye!"); return;

                case "history":
                    System.out.println("Calculator History:");
                    for (CommandEntry entry: list){
                        System.out.println(entry.command + " " + entry.val);
                    }
                    break;

                case "add":
                    curr += cmd.val; break;
                case "subtract":
                    curr -= cmd.val; break;
                case "total":
                    System.out.println("Current total: " + curr); break;
                case "reset":
                    curr = 0; break;
            }
        }
    }


    public static void main(String[] args){
        run();
    }
}