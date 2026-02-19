package Day3;

public class Conditional {
    public static void main(String[] args) {
        int age = 17;
        if (age >=18) {
            System.out.println("You are eligible to vote");
        }else{
            System.out.println("You are not eligible to vote");
        }
        //grading

        int marks = 33;
        if (marks>=90) {
            System.out.println("Grade A");
        }else if (marks>=80) {
            System.out.println("Grade A");
        }else if (marks>=70) {
            System.out.println("Grade C");
        }else if (marks>=60) {
            System.out.println("Grade D");
        }else if (marks>=50) {
            System.out.println("Grade E");
        }else{
            System.out.println("Grade F");
        }
        //switch case example
        String choice = "Mango";
        switch (choice) {
            case "Apple":
                System.out.println("Apple : Rs. 50");                
                break;
            case "Orange":
                System.out.println("Orange : Rs. 50");  
                break;
            case "Mango":
                System.out.println("Mango : Rs. 50");  
                break;      
            default:
                System.out.println("Invalid Input");
                break;
        }
    }
}
