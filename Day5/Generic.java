package Day5;
class Intro<N,A,S>{
    N name;
    A age;
    S salary;
    Intro(N name,A age,S salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    public void myIntro(){
        System.out.println("My name is :"+name+ " and i am "+ age + " Years old and my salary is " +salary);
    }
    public <T> void arrayValue(T arr[]){
        for(T val:arr){
            System.out.println(val);
        }
    }
}

public class Generic{
    public static void main(String[] args) {
        Intro<String,Integer,String> obj = new Intro<>("Lalit",44,"54LPA");
        Intro<String,Integer,Integer> obj1 = new Intro<>("Vivaan",6,54);
        obj.myIntro();
        obj1.myIntro();
        Integer arr[] ={1,2,3};
        String str[] ={"Lalit","vivaan","aadvik"};
        obj.arrayValue(arr);
        obj.arrayValue(str);
    }
}