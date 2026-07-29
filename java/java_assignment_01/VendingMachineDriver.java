public class VendingMachineDriver {
    // javac VendingMachine.java VendingMachineDriver.java (or javac *.java)
    // cd to root dir (e.g. assignments) and run 'java java_assignment.assignment_01.VendingMachineDriver'
    public static void main(String[] args) {
        // Note: Ideally, the Vending machine should take in cash as cents, not decimals, due to arthmetic rounding issues.

        VendingMachine vm = new VendingMachine();
        // Example 1 — Successful purchase with change
        System.out.println(vm.insertMoney(1.25, 2.00));

        // Example 2 — Insufficient funds
        System.out.println(vm.insertMoney(2.00, 1.00));

        // Example 3 — Exact payment, no change
        System.out.println(vm.insertMoney(1.00, 1.00));

        // Example 4 — Invalid input
        System.out.println(vm.insertMoney(-1.0, 1.00));

        // Stretch goals
        double[] costs = {1.00, 2.00};
        System.out.println(vm.insertMoney(costs, 3.00));

        double[] costs2 = {3.00, 3.00};
        System.out.println(vm.insertMoney(costs2, 2.00));

        // Making Change in Denominations
        System.out.println(vm.getChange(5.27));
    }
}