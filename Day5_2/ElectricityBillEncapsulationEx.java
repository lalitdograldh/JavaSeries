package Day5_2;

class ElectricityBill{
    private String customerName;
    private double unitsConsumed;
    private double billAmount;

    public String getName(){
        return this.customerName;
    }
    public double getUnitConsumed(){
        return this.unitsConsumed;
    }
    public double getBillAmount(){
        return this.billAmount;
    }

    public void setName(String newCustomerName) {
        this.customerName = newCustomerName;
    }

    public void setUnitConsumed(double newUnitConsumed) {
        if (unitsConsumed < 0) {
            System.out.println("Invalid units!");
        }else{
            this.unitsConsumed = newUnitConsumed;
        }
    }
    public void calculateBill(){
        //double BillAmount = 0;
        if (unitsConsumed <=100) {
            billAmount = unitsConsumed * 5;
        }else if (unitsConsumed <=200) {
            billAmount = ( 100 * 5 ) + (unitsConsumed - 100) * 7;
        }else{
            billAmount = ( 100 * 5 ) + ( 100 * 7 ) + (unitsConsumed - 200) * 10;
        }

        if (billAmount > 2000) {
            billAmount +=billAmount * 0.05;
        }
        
    }
    public void generateBill(){
        calculateBill();
        System.out.println("Name :" + customerName);
        System.out.println("UnitConsumed :" + unitsConsumed);
        System.out.println("BillAmount :" + billAmount);
    }
}
public class ElectricityBillEncapsulationEx {
    public static void main(String[] args) {
        ElectricityBill oElectricityBill = new ElectricityBill();
        
        oElectricityBill.setName("Priya");
        oElectricityBill.setUnitConsumed(2005);

        oElectricityBill.generateBill();
    }
}
