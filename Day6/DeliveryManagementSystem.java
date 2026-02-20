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

        // Perform Delivery
        delivery.deliver();

        double cost = delivery.calculateCost();
        cost = delivery.applyDiscount(cost);

        // Payment Section
        System.out.println("\nChoose Payment Mode:");
        System.out.println("1. Cash");
        System.out.println("2. UPI");
        System.out.println("3. Card");
        System.out.println("4. Wallet");

        int paymentChoice = sc.nextInt();

        switch (paymentChoice) {
            case 1:
                System.out.println("Paid via Cash.");
                break;
            case 2:
                System.out.println("Paid via UPI.");
                break;
            case 3:
                System.out.println("Paid via Card.");
                break;
            case 4:
                System.out.println("Paid via Wallet.");
                break;
            default:
                System.out.println("Invalid payment option.");
        }

        ((Payable) delivery).makePayment(cost);

        delivery.showDetails(delivery.getClass().getSimpleName());

        sc.close();
    }
}