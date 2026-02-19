package Day5_3;
/*
 * Project Title: SmartBank Account Analyzer
 * Description: A system to manage and analyze bank accounts.
 * Author: Lalit Dogra
 * Date: 19-02-2026
 */

public class BankAccountManagementSystem {
    public static void main(String[] args) {

        try {
            SavingsAccount sa = new SavingsAccount(101, "Lalit", 5000, 5);

            sa.deposit(2000);
            sa.withdraw(1000);
            sa.addInterest();

            sa.displayAccountDetails();
            sa.analyzeAccount();
            sa.displayTransactionGraph();

            System.out.println("\n----------------------\n");

            CurrentAccount ca = new CurrentAccount(202, "Rohit", 3000, 2000);

            ca.withdraw(4000); // uses overdraft
            ca.displayAccountDetails();
            ca.displayTransactionGraph();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
