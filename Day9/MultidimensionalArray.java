package Day9;

public class MultidimensionalArray {
    public static void main(String[] args) {
        int[][] myNumbers = { {1, 4, 2}, {3, 6, 8, 5, 2} };
        for(int row = 0;row<myNumbers.length;row++){
            for(int col =0;col<myNumbers[row].length;col++){
                System.out.println("myNumbers[" + row + "][" + col + "] = " + myNumbers[row][col]);
            }
        }
        // for(int[] row :myNumbers){
        //     for(int num:row){
        //         System.out.println(num);
        //     }
        // }
    }
}