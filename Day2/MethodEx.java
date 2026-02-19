package Day2;

public class MethodEx {
    void add(int a,int b){
        System.out.println(a+b);
    }
    int multiple (int a,int b){
        return a*b;
    }
    public static void main(String[] args){
        MethodEx obj = new MethodEx();
        obj.add(5, 6);
        obj.add(55, 6);
        obj.add(35, 6);
        int multiplication = obj.multiple(5, 4) ;
        obj.add(multiplication,multiplication);
        System.out.println("multiplication:"+multiplication);      
    }
}
