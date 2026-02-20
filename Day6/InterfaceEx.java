package Day6;

interface Contract {
    //abstract method
    public void legacy();
    
}
public class InterfaceEx implements Contract{
    public void legacy(){
        System.out.println("Let's make our customers happy ");
    }
    public static void main(String[] args) {
     InterfaceEx obj = new InterfaceEx();
     obj.legacy();
    }    
}
