package Day6;

abstract class Parent{
    abstract void legency();
    public void Intro(){
        System.out.println("I am the parent class");
    }
    public void money(){
        System.out.println("1cr rupees");
    }
    public Parent(){
        System.out.println("This is the constructor of parent class");
    }
}
public class AbstractionEx extends Parent{
    public void legency(){
        System.out.println("Be Kind to everyone");
    }
    public static void main(String[] args) {
     AbstractionEx obj = new AbstractionEx();
     obj.Intro();
     obj.money();
     obj.legency();
    }
    
}
