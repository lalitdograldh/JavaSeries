package Day4;
import java.util.Scanner;

public class Userinput {
    public static void main(String[] args) {
        // String str = args[0];
        // int val = args[0].charAt(0)-1;
        // System.out.println(str);
        // System.out.println(val);
        Scanner sc = new Scanner(System.in);
        int a =sc.nextInt();
        byte b = sc.nextByte();
        char c = sc.next().charAt(0);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        sc.close();
    }
}
