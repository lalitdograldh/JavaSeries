package Day9;

public class SumElements {
    public static void main(String[] args) {
         int [] numbers = {1, 5, 6, 25};
         int sum = 0;
         for(int i =0; i < numbers.length;i++){
             sum += numbers[i];
         }
         System.out.println("Sum of elements: " + sum);

    }
}
