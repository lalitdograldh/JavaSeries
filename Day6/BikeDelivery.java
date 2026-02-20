package Day6;

class BikeDelivery extends Delivery implements Trackable, Payable {
    public BikeDelivery(String customerName, double distance, double baseCost, double weight, String priority,
            boolean firstTimeCustomer) {
        super(customerName, distance, baseCost, weight, priority, firstTimeCustomer);
    }

    public double calculateCost() {
        if (weight > 50) {
            System.out.println("Weight exceeds 50 kg. Bike delivery not allowed.");
            updateStatus("Cancelled");
            return 0;
        }
        double cost = baseCost + (distance * 5); // Base cost + 5 per km

        if (weight > 20) {
            cost += 300; // Additional charge for long distances
        }
        if (priority.equalsIgnoreCase("Express"))
            cost += 200; // Additional charge for express delivery

        return cost;
    }

    public void calculateEstimatedTime() {
        estimatedHours = (int) Math.ceil(distance / 40.0); // Assuming bike travels 40 km/h
        if (priority.equalsIgnoreCase("Express")) {
            estimatedHours -= 1; // Express delivery reduces time by 1 hour
        }
    }

    public void deliver() {
        updateStatus("Packed");
        updateStatus("Out For Delivery");
        updateStatus("Delivered");
    }

    public void trackPackage() {
        System.out.println("Tracking ID: " + deliveryId + " | Status: " + status);
    }

    public String getTrackingId() {
        return deliveryId;
    }

    public void makePayment(double amount) {
        System.out.println("Payment of Rs " + amount + " successful (Bike)");
    }

}
