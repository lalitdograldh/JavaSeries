package Day6;

class DroneDelivery extends Delivery implements Trackable, Payable {
    public DroneDelivery(String customerName, double distance, double baseCost, double weight, String priority,
            boolean firstTimeCustomer) {
        super(customerName, distance, baseCost, weight, priority, firstTimeCustomer);
    }

    public double calculateCost() {
        if (distance > 100 || weight > 20) {
            System.out.println("Drone delivery not allowed (distance/weight limit).");
            updateStatus("Cancelled");
            return 0;
        }
        double cost = baseCost + (distance * 8); // Base cost + 8 per km

        if (priority.equalsIgnoreCase("Express"))
            cost += 200; // Additional charge for express delivery

        return cost;
    }

    public void calculateEstimatedTime() {
        estimatedHours = (int) Math.ceil(distance / 80.0); // Assuming drone travels 80 km/h
        if (priority.equalsIgnoreCase("Express")) {
            estimatedHours = Math.max(1, estimatedHours - 1);
        }
    }

    public void deliver() {
        if (status.equals("Cancelled"))
            return;

        calculateEstimatedTime();
        try {
            updateStatus("Packed");
            Thread.sleep(1000); // Simulate packing time
            updateStatus("Out For Delivery");
            for (int i = 1; i < estimatedHours; i++) {
                System.out.println("Hour" + i + " completed...");
                Thread.sleep(500); // Simulate each hour of delivery
            }
            updateStatus("Delivered");
        } catch (InterruptedException e) {
            System.out.println("Delivery interrupted!");
        }
    }

    public void trackPackage() {
        System.out.println("Tracking ID: " + deliveryId + " | Status: " + status);
    }

    public String getTrackingId() {
        return deliveryId;
    }

    public void makePayment(double amount, String paymentMode) {
         System.out.println("Payment of Rs " + amount + " successful via " + paymentMode + " (Drone)");
    }

}
