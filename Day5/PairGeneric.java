package Day5;
class Pair<T,U>{
    T name;
    U age;
    Pair(T name, U age){
        this.name = name;
        this.age = age;
    }
    public void display(){
        System.out.println("First value :" +name);
        System.out.println("Second value :" +age);
        
    }
}
public class PairGeneric {
    public static void main(String[] args) {
        Pair<String,Integer> obj = new Pair<>("Age",25);
        Pair<Double,Boolean> obj1 = new Pair<>(99.5,true);
        obj.display();
        obj1.display();
        
    }
}
