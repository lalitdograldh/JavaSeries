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
        System.out.println("Payment of Rs " + amount +
                " successful via " + paymentMode + " (Bike)");
    }

}
