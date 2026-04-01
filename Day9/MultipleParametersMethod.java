package Day9;

public class MultipleParametersMethod {
    static void myMethod(String fname, int age){
        System.out.println(fname + " is " + age + " years old.");
    }
    public static void main(String[] args) {
        myMethod("Aadvik", 3);
        myMethod("Vivaan", 7);
        myMethod("Babita", 37);
    }
}
