package Day5;
class Maximum <T extends Comparable<T>> {
    
    @SafeVarargs
    public final T findMax(T... values){
        T max =values[0];

        for(T value : values){
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }
}

public class GenericMax {    
    public static void main(String[] args) {
        Maximum<Integer> obMaximum = new Maximum<>();
        Maximum<Double> dbMaximum = new Maximum<>();
        Maximum<String> strMaximum = new Maximum<>();
        
        System.out.println("Maximum Integer: " + obMaximum.findMax(10, 50, 30, 80, 25));
        System.out.println("Maximum Double: " + dbMaximum.findMax(10.5, 10.8, 10.2, 11.1));
        System.out.println("Maximum String: " + strMaximum.findMax("Apple", "Orange", "Banana", "Zebra"));
    }
}
