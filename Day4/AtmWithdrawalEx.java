package Day4;
import java.util.Scanner;

class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
    
}
public class AtmWithdrawalEx {
    static int minus(int account_balance, int withdrawal_amount) {
        return account_balance - withdrawal_amount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int account_balance = 0;
        int withdrawal_amount = 0;
        try{
            System.out.println("ATM Withdrawal System");
            System.out.print("Enter Account Balance: ");
            account_balance = sc.nextInt();
            System.out.print("Enter Withdrawal Amount: ");
            withdrawal_amount = sc.nextInt();
            if (withdrawal_amount > account_balance) {
                throw new InsufficientBalanceException("Insufficient balance! Cannot withdraw.");
            }
            System.out.println("Remaining balance:"+minus(account_balance,withdrawal_amount));
            System.out.println("Withdrawal Successful!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{            
            sc.close();
        }
    }
    
}