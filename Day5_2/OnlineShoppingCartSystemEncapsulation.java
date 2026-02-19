package Day5_2;

public class OnlineShoppingCartSystemEncapsulation {

    public static void main(String[] args) {

        Product p1 = new Product(101, "Laptop", 50000, 1);
        Product p2 = new Product(102, "Mouse", 500, 2);

        ShoppingCart cart = new ShoppingCart(1, "Lalit");

        cart.addProduct(p1);
        cart.addProduct(p2);

        cart.displayCart();

        double total = cart.calculateTotalBill();
        System.out.println("\nTotal Bill: " + total);

        cart.removeProduct(p2);

        cart.displayCart();

        total = cart.calculateTotalBill();
        System.out.println("\nUpdated Total Bill: " + total);
    }
}
