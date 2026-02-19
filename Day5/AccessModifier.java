package Day5;
public class AccessModifier {
    public void publicData(){
        System.out.println("hey i am public data");
    }
    protected void protectedData(){
        System.out.println("hey i am protected data");
    }
    void defaultData(){
         System.out.println("hey i am default data");
    } 
    private void privateData(){
        System.out.println("hey i am private data");
    } 
    public static void main(String[] args) {
        System.out.println("this is coming from main method");
    }
}
