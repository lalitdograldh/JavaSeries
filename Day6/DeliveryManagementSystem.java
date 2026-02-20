package Day6;

import java.util.Scanner;

public class DeliveryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Customer Name:");
        String name = sc.nextLine();

        System.out.println("Enter Distance (km):");
        double distance = sc.nextDouble();

        System.out.println("Enter Package Weight (kg):");
        double weight = sc.nextDouble();

        sc.nextLine(); // Clear buffer

        System.out.println("Enter Priority (Normal / Express):");
        String priority = sc.nextLine();

        System.out.println("Is First-Time Customer? (true/false):");
        boolean firstTime = sc.nextBoolean();

        System.out.println("\nChoose Delivery Type:");
        System.out.println("1. Bike");
        System.out.println("2. Truck");
        System.out.println("3. Drone");

        int choice = sc.nextInt();

        Delivery delivery = null;

        switch (choice) {
            case 1:
                delivery = new BikeDelivery(name, distance, 500, weight, priority, firstTime);
                break;
            case 2:
                delivery = new TruckDelivery(name, distance, 1000, weight, priority, firstTime);
                break;
            case 3:
                delivery = new DroneDelivery(name, distance, 300, weight, priority, firstTime);
                break;
            default:
                System.out.println("Invalid delivery type!");
                sc.close();
                return;
        }

        // Step 1: Calculate Cost
        double cost = delivery.calculateCost();

        // Step 2: Check if delivery cancelled
        if (cost == 0 && delivery.status.equals("Cancelled")) {
            System.out.println("Delivery cannot proceed due to restrictions.");
            delivery.showDetails(delivery.getClass().getSimpleName());
            sc.close();
            return;
        }

        // Step 3: Apply Discount & Store Final Cost
        delivery.finalCost = delivery.applyDiscount(cost);

        // Step 4: Perform Delivery
        delivery.deliver();

        // Step 5: Payment Section
        System.out.println("\nChoose Payment Mode:");
        System.out.println("1. Cash");
        System.out.println("2. UPI");
        System.out.println("3. Card");
        System.out.println("4. Wallet");

        int paymentChoice = sc.nextInt();
        String paymentMode = "";

        switch (paymentChoice) {
            case 1:
                paymentMode = "Cash";
                break;
            case 2:
                paymentMode = "UPI";
                break;
            case 3:
                paymentMode = "Card";
                break;
            case 4:
                paymentMode = "Wallet";
                break;
            default:
                System.out.println("Invalid payment option.");
                sc.close();
                return;
        }

        ((Payable) delivery).makePayment(delivery.finalCost, paymentMode);

        // Step 6: Show Final Details
        delivery.showDetails(delivery.getClass().getSimpleName());

        sc.close();
    }
}