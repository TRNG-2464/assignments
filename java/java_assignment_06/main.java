import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class main {
    boolean running = true;
    int total = 0;

    void runCalculator() {
        Scanner sc = new Scanner(System.in);

        while (running) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            String command = tokens[0];
            int argCount = tokens.length - 1;

            String arg = "";
            if (argCount > 0) {
                arg = tokens[1];
            }

            switch (command) {
                default:
                    System.out.println("Unrecognized command: '" + command + "'");
                    break;
                case "add":
                    if (argCount == 0) {
                        System.out.println("'add' requires an argument. Please try again.");
                        break;
                    }
                    try {
                        int amount = Integer.parseInt(arg);
                        total += amount;
                        System.out.println("Added " + amount + ". Running total: " + total);
                    } catch (NumberFormatException e) {
                        System.out.println("'add' requires a valid number. Please try again.");
                    }
                    break;

                case "sub":
                    if (argCount == 0) {
                        System.out.println("'sub' requires an argument. Please try again.");
                        break;
                    }
                    try {
                        int amount = Integer.parseInt(arg);
                        total -= amount;
                        System.out.println("Subtracted " + amount + ". Running total: " + total);
                    } catch (NumberFormatException e) {
                        System.out.println("'sub' requires a valid number. Please try again.");
                    }
                    break;

                case "reset":
                    total = 0;
                    System.out.println("Running total has been reset to 0.");
                    break;
                case "total":
                    System.out.println("Current total: " + total);
                    break;
                case "exit":
                    System.out.println("Goodbye! Final total: " + total);
                    running = false;
                    break;
            }
        }

        sc.close();
    }

    void runCalculatorHistory() {
        List<String> history = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (running) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            String command = tokens[0];
            int argCount = tokens.length - 1;

            String arg = "";
            if (argCount > 0) {
                arg = tokens[1];
            }

            boolean valid = true;

            switch (command) {
                default:
                    System.out.println("Unrecognized command: '" + command + "'");
                    valid = false;
                    break;
                case "add":
                    if (argCount == 0) {
                        System.out.println("'add' requires an argument. Please try again.");
                        valid = false;
                        break;
                    }
                    try {
                        int amount = Integer.parseInt(arg);
                        total += amount;
                        System.out.println("Added " + amount + ". Running total: " + total);
                    } catch (NumberFormatException e) {
                        System.out.println("'add' requires a valid number. Please try again.");
                        valid = false;
                    }
                    break;

                case "sub":
                    if (argCount == 0) {
                        System.out.println("'sub' requires an argument. Please try again.");
                        valid = false;
                        break;
                    }
                    try {
                        int amount = Integer.parseInt(arg);
                        total -= amount;
                        System.out.println("Subtracted " + amount + ". Running total: " + total);
                    } catch (NumberFormatException e) {
                        System.out.println("'sub' requires a valid number. Please try again.");
                        valid = false;
                    }
                    break;

                case "reset":
                    total = 0;
                    System.out.println("Running total has been reset to 0.");
                    break;
                case "total":
                    System.out.println("Current total: " + total);
                    break;
                case "exit":
                    System.out.println("Goodbye! Final total: " + total);
                    running = false;
                    break;

                case "history":
                    System.out.println("history:");
                    for (String his : history) {
                        System.out.println(his);
                    }
            }

            if (valid) {
                history.add(line);
            }
        }

        sc.close();
    }

    void runCalculatorUndo() {
        Integer lastTotal = null;
        Scanner sc = new Scanner(System.in);

        while (running) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            String command = tokens[0];
            int argCount = tokens.length - 1;

            String arg = "";
            if (argCount > 0) {
                arg = tokens[1];
            }

            switch (command) {
                default:
                    System.out.println("Unrecognized command: '" + command + "'");
                    break;
                case "add":
                    if (argCount == 0) {
                        System.out.println("'add' requires an argument. Please try again.");
                        break;
                    }
                    try {
                        int amount = Integer.parseInt(arg);
                        lastTotal = total;
                        total += amount;
                        System.out.println("Added " + amount + ". Running total: " + total);
                    } catch (NumberFormatException e) {
                        System.out.println("'add' requires a valid number. Please try again.");
                    }
                    break;

                case "sub":
                    if (argCount == 0) {
                        System.out.println("'sub' requires an argument. Please try again.");
                        break;
                    }
                    try {
                        int amount = Integer.parseInt(arg);
                        lastTotal = total;
                        total -= amount;
                        System.out.println("Subtracted " + amount + ". Running total: " + total);
                    } catch (NumberFormatException e) {
                        System.out.println("'sub' requires a valid number. Please try again.");
                    }
                    break;

                case "reset":
                    lastTotal = total;
                    total = 0;
                    System.out.println("Running total has been reset to 0.");
                    break;
                case "total":
                    System.out.println("Current total: " + total);
                    break;
                case "exit":
                    System.out.println("Goodbye! Final total: " + total);
                    running = false;
                    break;

                case "undo":
                    if (lastTotal == null) {
                        System.out.println("Cannot undo. No previous command to add, subtract, or reset the running total.");
                    } else {
                        total = lastTotal;
                        System.out.println("Last command undone. Running total: " + total);
                    }
                    break;
                }
        }

        sc.close();
    }

    public static void main(String[] args) {
        main a = new main();
        a.runCalculatorUndo();
    }
}
