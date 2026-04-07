package Day9;
public class PlusMethodOverloaded {
    static int plus(int a, int b) {
        return a + b;
    }
    static double plus(double a,double b) {
        return a + b;
    }
    static String plus(String a, String b) {
        return a + b;
    }
    public static void main(String[] args) {
        System.out.println(plus(5, 10)); // Output: 15
        System.out.println(plus(3.5, 2.5)); // Output: 6.0
        System.out.println(plus("Hello, ", "world!")); // Output: Hello, world!
    }

    
}