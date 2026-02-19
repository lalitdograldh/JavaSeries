package Day4;

import java.util.InputMismatchException;
import java.util.Scanner;
class MinimumBalanceException extends Exception {
        public MinimumBalanceException(String message){
            super(message);
        }    
}
public class MinimumBankBalanceEx {
    static int minus(int account_balance,int withdrawal_amount){
        return account_balance - withdrawal_amount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int account_balance =0;
        int withdrawal_amount =0;
        try {
            System.out.println("Bank Info");
            System.out.println("Account holder name:");
            String name = sc.nextLine();
            System.out.println("Enter Account Balance:");
            account_balance = sc.nextInt();
            System.out.println("Enter Withdrawal Balance:");
            withdrawal_amount = sc.nextInt();
            int balance = minus(account_balance, withdrawal_amount);
            if (balance < 1000) {
                throw new MinimumBalanceException("Minimum balance of 1000 must be maintained!");
            }
            System.out.println("Hello:"+name);
            System.out.println("Remaining balance:"+balance);
            System.out.println("Withdrawal Successful!");
        }catch(InputMismatchException e){
            System.out.println("Invalid input! Please enter numbers only.");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            sc.close();
        }
    }
}