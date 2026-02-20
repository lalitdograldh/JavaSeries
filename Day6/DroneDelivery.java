package Day6;

class DroneDelivery extends Delivery implements Trackable,Payable {
    public DroneDelivery(String customerName, double distance, double baseCost, double weight, String priority, boolean firstTimeCustomer) {
        super(customerName, distance, baseCost, weight, priority, firstTimeCustomer);
    }

    public double calculateCost() {
        if (distance > 100 || weight > 20) {
            System.out.println("Drone delivery not allowed (distance/weight limit).");
            updateStatus("Cancelled");
            return 0;
        }
        double cost =  baseCost + (distance * 8); // Base cost + 8 per km

        if (priority.equalsIgnoreCase("Express")) cost += 200; // Additional charge for express delivery 

        return cost;
    }

    public void calculateEstimatedTime() {
        estimatedHours = (int) Math.ceil(distance / 80.0); // Assuming drone travels 80 km/h
        if (priority.equalsIgnoreCase("Express")) estimatedHours -= 1; // Express delivery reduces time by 1 hour       
    }

    public void deliver() {
        if (status.equals("Cancelled")) return;
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
        System.out.println("Payment of Rs " + amount + " successful (Drone)");
    }
   
}
