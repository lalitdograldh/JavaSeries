package Day7;

import java.util.Scanner;

public class ArrayEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int arr[] = {10, 20, 30, 40, 50};
        // for (int i =0;i<arr.length;i++){
        // System.out.println(arr[i]);
        // }
        // foreach loop
        // for(int val:arr){
        // System.out.println(val);
        // }
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        char letters[] = new char[n];
        for (int ii = 0; ii < letters.length; ii++) {
            System.out.print("Enter character " + (ii + 1) + ": ");
            letters[ii] = sc.next().charAt(0);
        }
        System.out.println("Printing Characters:");
        for (char c : letters) {
            System.out.println("Character: " + c);
        }

        sc.close();
    }
}
