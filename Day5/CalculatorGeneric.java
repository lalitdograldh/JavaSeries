package Day5;
class Calculator<T extends Number>{
    T first;
    T second;
    Calculator(T first , T second){
        this.first = first;
        this.second = second;
    }
    public double add(){
        return first.doubleValue() + second.doubleValue();
    }
    public double subtract(){
        return first.doubleValue() - second.doubleValue();
    }
    
}
public class CalculatorGeneric {
    public static void main(String[] args) {
        Calculator<Integer> obCalculator = new Calculator<>(10, 20);
        System.out.println("Addition: " + obCalculator.add());
        System.out.println("Subtraction: " + obCalculator.subtract());

        Calculator<Double> doCalculator = new Calculator<>(5.5, 4.5);
        System.out.println("Addition: " + doCalculator.add());
        System.out.println("Subtraction: " + doCalculator.subtract());
        
    }
}
