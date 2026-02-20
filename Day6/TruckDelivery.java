package Day6;

class TruckDelivery extends Delivery implements Trackable, Payable{
    public TruckDelivery(String customerName, double distance, double baseCost, double weight, String priority, boolean firstTimeCustomer) {
        super(customerName, distance, baseCost, weight, priority, firstTimeCustomer);
    }

    public double calculateCost() {
        double cost = baseCost + (distance * 10); // Base cost + 10 per km
        if (weight > 20) cost += 300;
        if (priority.equalsIgnoreCase("Express")) cost += 200; // Additional charge for express delivery
        return cost;
    }

    public void calculateEstimatedTime() {
        estimatedHours = (int) Math.ceil(distance / 60.0); // Assuming truck travels 60 km/h
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
        System.out.println("Payment of Rs " + amount + " successful (Truck)");
    }

    
}
