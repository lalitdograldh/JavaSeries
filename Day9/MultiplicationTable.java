package Day9;

public class MultiplicationTable {
    public static void main(String[] args) {
        int number = 25; // Change this to generate multiplication table for a different number
        System.out.println("Table of " + number);
        for(int i = 1; i<=10;i++){
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        System.out.println("\n--------------------------------------\n");
        for(int i = 1; i<=5;i++){
            for(int j = 1;j<=10;j++){
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println(); // Move to the next line after each row

        }
    }
}
