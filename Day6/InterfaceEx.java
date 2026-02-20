package Day6;

interface Contract {
    // abstract method
    public void legacy();

    // java 8 we can have concrete method in interface with default keyword
    default void intro() {
        System.out.println("I am coming from interface.");
    }
}

interface Contract1 {
    public void work();
}

public class InterfaceEx implements Contract, Contract1 {
    public void legacy() {
        System.out.println("Let's make our customers happy ");
    }

    public void work() {
        System.out.println("I am software developer");
    }

    public static void main(String[] args) {
        InterfaceEx obj = new InterfaceEx();
        obj.legacy();
        obj.intro(); 
        obj.work();
    }
}
