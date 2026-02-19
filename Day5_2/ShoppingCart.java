package Day5_2;
import java.util.ArrayList;;

class ShoppingCart{
    private int cartId;
    private String customerName;
    private double totalAmount;
    private ArrayList<Product> products;

    public ShoppingCart(int cartId, String customerName){
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new ArrayList<>();

        System.out.println("Shopping cart created for " + customerName);
    }
    
    public void addProduct(Product product){
        products.add(product);
        System.out.println(product.getProductName() + " added to cart");
    }
    public void removeProduct(Product product){
        products.remove(product);
        System.out.println(product.getProductName() + " removed from cart");
    }
    public double calculateTotalBill(){
        totalAmount = 0.0;
        for(Product p : products){
            totalAmount +=p.calculateTotalPrice();
        }
        return totalAmount;
    }
    public void displayCart() {
        System.out.println("\nCart ID: " + cartId);
        System.out.println("Customer: " + customerName);
        System.out.println("Products in Cart:");

        for (Product p : products) {
            System.out.println("- " + p.getProductName());
        }
    }
}

