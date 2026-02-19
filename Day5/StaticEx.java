package Day5;
public class StaticEx {
    static String name = "Example";
    public static void intro(){
        System.out.println("Hello world");
    }
    public static void main(String[] args) {
        // StaticEx obj = new StaticEx();
        // System.out.println(obj.name);
        System.out.println(name);
        intro();
    }  
}
