package Day5_3;

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(int accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNumber, accountHolderName, balance);
        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative.");
        }
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdraw amount cannot be negative.");
        }
        if (amount > getBalance() + overdraftLimit) {
            throw new InsufficientBalanceException("Insufficient funds for withdrawal, including overdraft limit.");
        }
        // double newBalance = getBalance() - amount;
        updateBalance(-amount);
        System.out.println("Withdrawal successful using overdraft facility.");
    }

    public double getAvailableBalance() {
        return getBalance() + overdraftLimit;
    }
    public double getUsedOverdraft() {
        if (getBalance() < 0) {
            return Math.abs(getBalance());
        }
        return 0;
    }
}
