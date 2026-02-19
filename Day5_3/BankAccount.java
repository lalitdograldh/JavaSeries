package Day5_3;

import java.util.List;
import java.util.ArrayList;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private List<Double> transactions;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }
        balance += amount;
        transactions.add(amount);
        System.out.println("Amount deposited successfully. New balance: " + balance);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount < 0) {
            throw new InvalidAmountException("Withdraw amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
        transactions.add(-amount);
        System.out.println("Amount withdrawn successfully. New balance: " + balance);
    }

    public double getTotalDeposits() {
        double total = 0;

        for (double amount : transactions) {

            if (amount > 0) {
                total += amount;
            }
        }
        return total;
    }

    public double getTotalWithdrawals() {
        double total = 0;

        for (double amount : transactions) {

            if (amount < 0) {
                total += amount; // Convert to positive for total withdrawals
            }
        }
        return Math.abs(total);
    }

    public double getBalance() {
        return balance;
    }

    protected void updateBalance(double amount) {
        balance += amount;
        transactions.add(amount);
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
        System.out.println("Transactions: " + transactions);
    }

    public void analyzeAccount() {
        System.out.println("------ Account Analysis ------");
        System.out.println("Total Deposits: " + getTotalDeposits());
        System.out.println("Total Withdrawals: " + getTotalWithdrawals());
        System.out.println("Current Balance: " + getBalance());
    }

    public void displayTransactionGraph() {

        System.out.println("\n------ Transaction Graph ------");

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        int index = 1;

        for (double amount : transactions) {

            System.out.print("Transaction " + index + ": ");

            int units = (int) (Math.abs(amount) / 100);
            // Each 100 rupees = 1 symbol

            if (amount > 0) {
                System.out.print("Deposit   | ");
                for (int i = 0; i < units; i++) {
                    System.out.print("+");
                }
            } else {
                System.out.print("Withdraw  | ");
                for (int i = 0; i < units; i++) {
                    System.out.print("-");
                }
            }

            System.out.println(" (" + amount + ")");
            index++;
        }
    }

}
