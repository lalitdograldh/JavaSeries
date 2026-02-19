package Day5_2;

class OnlineFoodDelivery {
    enum OrderStatus {
        PENDING,
        PREPARING,
        ONTHEWAY,
        DELIVERED
    }

    private String orderId;
    private String customerName;
    private double totalAmount;

    private OrderStatus status;

    public OnlineFoodDelivery() {
        this.status = OrderStatus.PENDING;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getName() {
        return this.customerName;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }

    public void setOrderId(String newOrderId) {
        this.orderId = newOrderId;
    }

    public void setName(String newCustomerName) {
        this.customerName = newCustomerName;
    }

    public void setTotalAmount(double newTotalAmount) {
        if (newTotalAmount < 0) {
            //System.out.println("Total amount cannot be negative.");
            throw new IllegalArgumentException("Total amount cannot be negative.");
        } else {
            this.totalAmount = newTotalAmount;
        }
    }

    public void calculateTotalAmount(double price, int quantity, double deliveryFee, double taxPercent){
        if (price < 0 || quantity < 0 || deliveryFee < 0 || taxPercent < 0) {
            throw new IllegalArgumentException("Values cannot be negative.");
        }
        double subTotal = price * quantity;
        double taxAmount = subTotal * taxPercent / 100;
        this.totalAmount = subTotal + taxAmount + deliveryFee;
    }

    public void processOrder() {
        try {
            System.out.println("Order Status : "+status);

            Thread.sleep(3000);
            status = OrderStatus.PREPARING;
            System.out.println("Order Status : "+status);

            Thread.sleep(5000);
            status = OrderStatus.ONTHEWAY;
            System.out.println("Order Status :" + status);
            
            Thread.sleep(7000);
            status = OrderStatus.DELIVERED;
            System.out.println("Order Status :" + status);

        } catch (InterruptedException e) {
            System.out.println("Error occured");
        }
    }

    public void generateBill(){
        System.out.println("\n----- BILL -----");
        //calculateBill();
        System.out.println("orderId :" + orderId);
        System.out.println("Name :" + customerName);
        System.out.println("Total Amount :" + totalAmount);
        System.out.println("Order Status :" + status);
    }

}

public class OnlineFoodDeliveryEncapsulation {
    public static void main(String[] args) {
        OnlineFoodDelivery oDelivery = new OnlineFoodDelivery();
        oDelivery.setOrderId("ORD101");
        oDelivery.setName("Rahul");
        oDelivery.calculateTotalAmount(500, 2, 50, 5);
        oDelivery.processOrder();
        oDelivery.generateBill();

    }
}
