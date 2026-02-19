package Day5_2;

class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;

        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }

    public double calculateTotalPrice() {
        return price * quantity;
    }

}