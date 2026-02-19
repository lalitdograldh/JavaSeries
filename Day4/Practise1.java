package Day4;
import java.util.Scanner;
public class Practise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n to print numbers between 1 to n");
        int n = sc.nextInt();
        System.out.println("value are :");
        for(int i=1;i<=n;i++){
            System.out.println(i);
        }
        System.out.println("Enter your name :");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("my name is:"+name);
        sc.close();
    }
}
