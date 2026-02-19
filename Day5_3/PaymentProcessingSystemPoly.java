package Day5_3;

import java.util.Scanner;
import java.util.UUID;

abstract class Payment {
    protected String transactionId;
    protected String status;

    public abstract void pay(double amount);

    protected void generateTransaction() {
        transactionId = UUID.randomUUID().toString();
        status = (Math.random() > 0.2) ? "Success" : "Failed";
    }

    protected void printCommonDetails(double finalAmount) {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Payment Status: " + status);
        System.out.println("Final Amount: Rs." + finalAmount);
        System.out.println("----------------------------- ");
    }

}

class CreditCardPayment extends Payment {
    @Override
    public void pay(double amount) {
        generateTransaction();
        double extraCharge = amount * 0.02; // 2% extra charge for credit card payments
        double finalAmount = amount + extraCharge;

        System.out.println("Processing credit card payment of Rs." + amount);
        System.out.println("2% Extra Charge: Rs." + extraCharge);

        printCommonDetails(finalAmount);

    }
}

class UPIPayment extends Payment {
    @Override
    public void pay(double amount) {

        generateTransaction();

        double cashback = 10; // 1% cashback for UPI payments
        double finalAmount = amount - cashback;

        System.out.println("Processing UPI payment of Rs." + amount);
        System.out.println("Cashback: Rs." + cashback);

        printCommonDetails(finalAmount);

    }
}

class NetBankingPayment extends Payment {
    @Override
    public void pay(double amount) {
        generateTransaction(); // Use the inherited method to generate transaction ID and status
        System.out.println("Processing net banking payment of Rs." + amount);

        printCommonDetails(amount); // No extra charge or cashback for net banking
    }
}

public class PaymentProcessingSystemPoly {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. Net Banking");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Exiting Payment Processing System.");
                break;
            }

            System.out.println("Enter Amount to Pay:");
            String input = sc.next();

            if (input.startsWith("0") && input.length() > 1) {
                System.out.println("Invalid amount! Leading zeros are not allowed.");
                continue;
            }
            double amount;

            try {
                amount = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numeric value.");
                continue;
            }
            if (amount < 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
                continue;
            }

            Payment payment;

            switch (choice) {
                case 1:
                    payment = new CreditCardPayment();
                    break;
                case 2:
                    payment = new UPIPayment();
                    break;
                case 3:
                    payment = new NetBankingPayment();
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
                    return;
            }

            payment.pay(amount);
        }
        sc.close();
    }
}
