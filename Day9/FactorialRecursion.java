package Day9;

public class FactorialRecursion {
    static int factorial(int n){
        if(n > 1){
            return n * factorial(n - 1);
        }else{
            return 1;

        }
    }
    public static void main(String[] args) {
        int result = factorial(6);
        System.out.println(result);
    }
}
