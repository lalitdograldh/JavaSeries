package Day5_3;

class A{
    String money="5Lakhs";
}
class B extends A{
    String expense="2Lakhs";
}
public class Inheritence {
    public static void main(String[] args) {
        B oB = new B();
        System.out.println("Expense:" + oB.expense);
        System.out.println("Money:" + oB.money);
    }
}
