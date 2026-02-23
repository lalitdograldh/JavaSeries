package Day6.Day6_1;
import java.io.Serializable;
import java.util.UUID;
class Student implements Serializable { 
    private static final long serialVersionUID = 1L; // For serialization
    private String studentId;
    private String name;
    private String email;

    public Student(String name, String email) {

        this.studentId = UUID.randomUUID().toString(); // Generate unique student ID
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }

    public void showStudentDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
