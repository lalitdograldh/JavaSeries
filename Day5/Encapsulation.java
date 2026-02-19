package Day5;
//Intro class is an example of encapsulation
class Intro{
    private String name ="Hello World";
    //getter method :used to access private properties outside the class
    public String getName(){
        return this.name;
    }
    //setter method:used to update private properties outside the class
    public void setName(String newName){
        this.name = newName;
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        //Encapsulation obEncapsulation = new Encapsulation();
        Intro obIntro = new Intro();
        System.out.println(obIntro.getName());
        obIntro.setName("Student Learner");
        System.out.println(obIntro.getName());
    }
}
