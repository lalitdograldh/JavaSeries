package Day5_3;

class Parent {
    public void display() {
        System.out.println("hey i am Parent class");
    }
}

public class Polymorphism extends Parent {
    // compile time polymorphism
    public int add(int a, int b) {
        return a + b;
    }

    public float add(int a, float b) {
        return a + b;
    }

    // this display method is overriding the display method of parent class this is
    // runtime polymorphism
    public void display() {
        System.out.println("hey i am Child class");
    }

    public static void main(String[] args) {
        Polymorphism p = new Polymorphism();
        System.out.println(p.add(1, 2));
        System.out.println(p.add(1, 2F));
        p.display();
    }
}
