package Day6.Day6_1;
class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void enroll() {
        course.enrollStudent(student.getName());
    }

    public void showEnrollmentDetails() {
        System.out.println("\n--- Enrollment Details ---");
        student.showStudentDetails();
        course.showCourseDetails();
    }
    public Course getCourse() {
        return course;
    }
}