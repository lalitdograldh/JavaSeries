package Day5_3;

 class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative.");
        }
        this.interestRate = interestRate;
    } 
    
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }
    public void displayInterest(){
        System.out.println("Calculated interest: " + calculateInterest());
    }
    public void addInterest() throws InvalidAmountException {
        double interest = calculateInterest();
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }   
    
}
