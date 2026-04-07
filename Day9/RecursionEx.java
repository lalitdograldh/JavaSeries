package Day9;

public class RecursionEx {
    static int sum(int k){
        if (k > 0) {
            System.out.print(k);
            if (k > 1) {
                System.out.print(" + ");
            }
            return k + sum(k -1);
        }else{
            return 0;
        }
    }
    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(" = " + result);
    }
}
