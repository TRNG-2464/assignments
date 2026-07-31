import java.util.*;
public class exercise6 {
    public static void main(String[] args) {
        stretchGoal2();
    }
    public static void calculator() {
        Scanner sc = new Scanner(System.in);

        int running_value = 0;

        while (true) {
            System.out.println("Enter a command: ");
            String cmd = sc.nextLine();
            String[] command = cmd.split(" ");
            switch (command[0]) {
                case "add":
                    if (!command[1].matches("\\d+")) {
                        System.out.println("'add' requires a valid number. Please try again.");
                    } else {
                        running_value += Integer.parseInt(command[1]);
                        System.out.println("Added " + command[1] + ". Running total: " + running_value);
                    }
                    break;
                case "subtract":
                    if (!command[1].matches("\\d+")) {
                        System.out.println("'subtract' requires a valid number. Please try again.");
                    }
                    else {
                        running_value -= Integer.parseInt(command[1]);
                        System.out.println("Subtracted " + command[1] + ". Running total: " + running_value);
                    }
                    break;
                case "reset":
                    running_value = 0;
                    System.out.println("Running total has been reset to 0.");
                    break;
                case "total":
                    System.out.println("Current total: " + running_value);
                    break;
                case "exit":
                    System.out.println("Goodbye! Final total: " + running_value);
                    return;
                default:
                    System.out.print("Unrecognized command: " + command[0]);
                    System.out.print("\n");
                    break;
            }
            System.out.print("\n");
        }
    }
    public static void stretchGoal1() {
        Scanner sc = new Scanner(System.in);

        int running_value = 0;

        ArrayList<String> historyCommands = new ArrayList<>();

        while (true) {
            System.out.println("Enter a command: ");
            String cmd = sc.nextLine();
            String[] command = cmd.split(" ");
            historyCommands.add(cmd);
            switch (command[0]) {
                case "add":
                    if (!command[1].matches("\\d+")) {
                        System.out.println("'add' requires a valid number. Please try again.");
                    } else {
                        running_value += Integer.parseInt(command[1]);
                        System.out.println("Added " + command[1] + ". Running total: " + running_value);
                    }
                    break;
                case "subtract":
                    if (!command[1].matches("\\d+")) {
                        System.out.println("'subtract' requires a valid number. Please try again.");
                    }
                    else {
                        running_value -= Integer.parseInt(command[1]);
                        System.out.println("Subtracted " + command[1] + ". Running total: " + running_value);
                    }
                    break;
                case "reset":
                    running_value = 0;
                    System.out.println("Running total has been reset to 0.");
                    break;
                case "total":
                    System.out.println("Current total: " + running_value);
                    break;
                case "exit":
                    System.out.println("Goodbye! Final total: " + running_value);
                    return;
                case "history":
                    System.out.println(historyCommands);
                    break;
                default:
                    System.out.print("Unrecognized command: " + command[0]);
                    System.out.print("\n");
                    break;
            }
            System.out.print("\n");
        }
    }
    public static void stretchGoal2() {
        Scanner sc = new Scanner(System.in);

        int running_value = 0;

        int prev = 0;

        String prevCommand = "";
        while (true) {
            System.out.println("Enter a command: ");
            String cmd = sc.nextLine();
            String[] command = cmd.split(" ");
            switch (command[0]) {
                case "add":
                    if (!command[1].matches("\\d+")) {
                        System.out.println("'add' requires a valid number. Please try again.");
                    } else {
                        prev = running_value;
                        running_value += Integer.parseInt(command[1]);
                        System.out.println("Added " + command[1] + ". Running total: " + running_value);
                    }
                    break;
                case "subtract":
                    if (!command[1].matches("\\d+")) {
                        System.out.println("'subtract' requires a valid number. Please try again.");
                    }
                    else {
                        prev = running_value;
                        running_value -= Integer.parseInt(command[1]);
                        System.out.println("Subtracted " + command[1] + ". Running total: " + running_value);
                    }
                    break;
                case "reset":
                    prev = running_value;
                    running_value = 0;
                    System.out.println("Running total has been reset to 0.");
                    break;
                case "total":
                    System.out.println("Current total: " + running_value);
                    break;
                case "exit":
                    System.out.println("Goodbye! Final total: " + running_value);
                    return;
                case "undo":
                    if (prevCommand.isEmpty()) {
                        System.out.println("Invlaid: There's nothing to undo.");
                    } else {
                        running_value = prev;
                        System.out.println("Undid command " + prevCommand + ". Running value: " + running_value);
                    }
                    break;
                default:
                    System.out.print("Unrecognized command: " + command[0]);
                    System.out.print("\n");
                    break;
            }
            if (command[0].equals("add") || command[0].equals("subtract") || command[0].equals("reset")) {
                prevCommand = cmd;
            }
            System.out.print("\n");
        }
    }
}
