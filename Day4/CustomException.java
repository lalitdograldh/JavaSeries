package Day4;
class InvalidAge extends Exception{
    public InvalidAge(String message){
        super(message);
    }
}
public class CustomException {
    public static void main(String[] args) {
        try{
            int age =17;
            if (age < 18) {
                throw new InvalidAge("Age should not be less then 18");
            }
            System.out.println("Your age:"+age);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("hey i am finally");
        }
    }
}
