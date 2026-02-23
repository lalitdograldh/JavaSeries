package Day6.Day6_1;
import java.io.Serializable;
class Enrollment implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization
    
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void enroll() {
        course.enrollStudent(student);
    }

    public void showEnrollmentDetails() {
        System.out.println("\n--- Enrollment Details ---");
        student.showStudentDetails();
        course.showCourseDetails();
    }
    public String getStudentEmail() {
        return student.getEmail();
    }
}