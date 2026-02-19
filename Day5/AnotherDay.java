package Day5_1;
import Day5.AccessModifier;
public class AnotherDay extends AccessModifier {
    public static void main(String[] args) {
        AccessModifier obj = new AccessModifier();
        AnotherDay objAD = new AnotherDay();
        obj.publicData();
        objAD.protectedData();
        //obj.defaultData();
        //obj.privateData();
    }
}
