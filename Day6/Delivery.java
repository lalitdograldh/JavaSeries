package Day6;

import java.util.UUID;

abstract class Delivery {
    protected String deliveryId;
    protected String customerName;
    protected double distance;// in kilometers
    protected double baseCost;
    protected double weight;// in kg
    protected int estimatedHours;
    protected String status;
    protected String priority;
    protected boolean firstTimeCustomer;

    public Delivery(String customerName, double distance, double baseCost, double weight, String priority,
            boolean firstTimeCustomer) {
        this.customerName = customerName;
        this.distance = distance;
        this.baseCost = baseCost;
        this.weight = weight;
        this.priority = priority;
        this.firstTimeCustomer = firstTimeCustomer;
        this.status = "Pending";

        generateDeliveryId();// Auto-generate delivery ID when a new delivery is created
    }

    // Abstract methods to be implemented by subclasses
    public abstract double calculateCost();

    public abstract void deliver();

    public abstract void calculateEstimatedTime();

    // Concrete method to generate a unique delivery ID
    public void generateDeliveryId() {
        this.deliveryId = "DLV-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Delivery status updated to: " + newStatus);
    }

    public double applyDiscount(double cost) {
        if (priority.equalsIgnoreCase("Express")) {
            System.out.println("Express Delivery - No Discount Applied");
            return cost;
        }
        if (firstTimeCustomer) {
            cost = cost - (cost * 0.20);
            System.out.println("20% First-Time Customer Discount Applied!");
        } else if (cost > 5000) {
            cost = cost - (cost * 0.15);
            System.out.println("15% Premium Discount Applied!");
        }
        return cost;
    }

    public void showDetails(String deliveryType) {
        double cost = calculateCost();
        cost = applyDiscount(cost);
        calculateEstimatedTime();
        System.out.println("\n========= DELIVERY DETAILS =========");
        System.out.println("Delivery ID: " + deliveryId);
        System.out.println("Customer: " + customerName);
        System.out.println("Delivery Type: " + deliveryType);
        System.out.println("Priority: " + priority);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Cost: Rs" + cost);
        System.out.println("Estimated Delivery Time: " + estimatedHours + " hours");
        System.out.println("Final Status: " + status);
        System.out.println("======================================");
    }
}
