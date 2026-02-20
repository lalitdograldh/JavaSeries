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
            estimatedHours = Math.max(1, estimatedHours - 1);
        }
    }
    public void deliver() {
        if (status.equals("Cancelled"))
            return;

        calculateEstimatedTime();
        try {
            updateStatus("Packed");
            Thread.sleep(10000); // Simulate packing time
            updateStatus("Out For Delivery");
            for (int i = 1; i < estimatedHours; i++) {
                System.out.println("Hour" + i + " completed...");
                Thread.sleep(5000); // Simulate each hour of delivery
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

    public void makePayment(double amount , String paymentMode) {
         System.out.println("Payment of Rs " + amount + " successful via " + paymentMode + " (Truck)");
    }

    
}
