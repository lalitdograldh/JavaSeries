package Day6.Day6_2.StudentRecordManager;

public class Student {
    private String rollNo;
    private String name;
    private String studentClass;
    private String marks;
    public Student(String rollNo, String name, String studentClass, String marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.studentClass = studentClass;
        this.marks = marks;
    }
    public String getRollNo() {
        return rollNo;
    }
    public String toFileString() {
        return rollNo + "," + name + "," + studentClass + "," + marks;
    }
    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Class: " + studentClass);
        System.out.println("Marks: " + marks);
        System.out.println("-------------------------");
    }
    
}
