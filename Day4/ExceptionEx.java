package Day4;

public class ExceptionEx {
    public static void main(String[] args)throws ArithmeticException {
        try{
            int a =10;
            int res = a/0;
            System.out.println(res);
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        /*
        int a =10;
        int res = a/0;
        System.out.println(res);
        /* */
        System.out.println("hey this is new code");
    }
}
