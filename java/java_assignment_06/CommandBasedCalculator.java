
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommandBasedCalculator {

    public static void main(String[] args) {
        Scanner std_in = new Scanner(System.in);
        String input = new String();
        int total = 0;
        try {
            do {

                System.out.print("Enter a command:");
                input = std_in.nextLine().trim();

                if (validateInput(input)) {
                    String arguments[] = input.split(" ");
                    String command = arguments[0];

                    int val = 0;
                    if (arguments.length > 1) {
                        val = Integer.parseInt(arguments[1]);
                    }

                    switch (command) {
                        case "reset":
                            total = 0;
                            System.out.println("Running total has been reset to " + total);
                            break;
                        case "total":
                            System.out.println("Current total: " + total);
                            break;
                        case "add":
                            total += val;
                            System.out.println("Added " + val + ". Running total: " + total);
                            break;
                        case "subtract":
                            total -= val;
                            System.out.println("Subtracted " + val + ". Running total: " + total);
                            break;
                        case "exit":
                            System.out.println("Final total: " + total);

                    }

                }

            } while (!input.equals("exit"));
        } finally {
            std_in.close();
        }

    }

    public static Boolean validateInput(String command) {

        if (command.isEmpty()) {
            System.out.println("No arguments provided.");
            return false;
        }

        Set<String> valid_commands = new HashSet<>();
        valid_commands.add("exit");
        valid_commands.add("add");
        valid_commands.add("subtract");
        valid_commands.add("reset");
        valid_commands.add("total");

        String[] split_command = command.split(" ");

        Boolean validate = true;

        // Check command valid
        if (!valid_commands.contains(split_command[0])) {
            System.out.println("Command " + split_command[0] + " not recognized");
            validate = false;
        }

        // add sub checks
        Boolean add_sub = split_command[0].equals("add") || split_command[0].equals("subtract");

        // Check more than two args
        if (add_sub && split_command.length > 2) {
            System.out.println("More than one argument provided");
            validate = false;
        }

        // Check second argument is numeric 
        if (add_sub && !split_command[1].matches("^-?\\d+$")) {
            System.out.println("Argument " + split_command[1] + " is not number");
            validate = false;

        }
        return validate;
    }

}
