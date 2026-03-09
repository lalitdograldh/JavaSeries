package Day8;

public class RealLifeEx {
    int items = 50;
    float costPerItem = 9.99f;
    float totalCost = items  * costPerItem;
    char currency = '$';
    public static void main(String[] args) {
        RealLifeEx rEx = new RealLifeEx();
        System.out.println("Number of items: " +rEx.items);
        System.out.println("Cost per items : " +rEx.currency + rEx.costPerItem);
        System.out.println("Total Cost : " +rEx.currency + rEx.totalCost );
    } 
}
