package Day5_2;

class InvalidAge extends Exception {
    public InvalidAge(String message) {
        super(message);
    }
}

class InvalidInput extends Exception {
    public InvalidInput(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private int age;
    private double marks;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getMarks() {
        return this.marks;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(int newage) throws InvalidAge {
        try {
            if (newage > 0) {
                this.age = newage;
            } else {
                // System.out.println("Age must be greater than 0!");
                throw new InvalidAge("Age must be greater than 0!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setMarks(double newMarks) throws InvalidInput {
        try {
            if (newMarks >= 0 && newMarks <= 100) {
                this.marks = newMarks;
            } else {
                // System.out.println("Invalid Input");
                throw new InvalidInput("Invalid Input");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayDetails() {
        String grade;
        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 75) {
            grade = "B";
        } else if (marks >= 50) {
            grade = "C";
        } else {
            grade = "Fail";
        }
        System.out.println("Name :" + name);
        System.out.println("Age :" + age);
        System.out.println("Marks :" + marks);
        System.out.println("Grade :" + grade);
    }

    public void isPassed() {
        // return marks >= 50;
        String Passed;
        if (marks >= 50) {
            Passed = "YES";
        } else {
            Passed = "NO";
        }
        System.out.println("Passed: " + Passed);
    }
}

public class StudentEncapsulationEx {
    public static void main(String[] args) {
        Student obStudent = new Student();

        obStudent.setName("Priya");
        // System.out.println(obStudent.getName());

        try {
            obStudent.setAge(25);
            obStudent.setMarks(49.4);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // System.out.println(obStudent.getAge());        
        // System.out.println(obStudent.getMarks());
        obStudent.displayDetails();
        obStudent.isPassed();
        // System.out.println("Passed: " + (obStudent.isPassed() ? "YES" : "NO"));
        ;
    }
}
