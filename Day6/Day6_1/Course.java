package Day6.Day6_1;

import java.io.Serializable;
import java.util.UUID;
abstract class Course implements Serializable {
    // enum CourseStatus {
    //     NOT_STARTED,
    //     IN_PROGRESS,
    //     COMPLETED
    // }

    protected String courseId;
    protected String title;
    protected int duration; // in hours
    protected String instructorName;
    protected double price;

    protected int completedHours = 0;
    protected int progress = 0; // (0–100)

    //protected int totalRating = 0;
    //protected int ratingCount = 0;

    //protected CourseStatus status; // Not Started, In Progress, Completed

    public Course(String title, int duration, String instructorName, double price) {
        this.courseId = UUID.randomUUID().toString(); // Generate unique course ID
        this.title = title;
        this.duration = duration;
        this.instructorName = instructorName;
        this.price = price;
        //this.completedHours = 0;
        //this.progress = 0; // Default progress
        //this.status = CourseStatus.NOT_STARTED; // Default status
    }

    public String getTitle() {
        return title;
    }

    public void enrollStudent(Student student) {
        System.out.println(student.getName() + " enrolled in " + title);
    }

    public void showCourseDetails() {
        System.out.println("\n--- Course Details ---");
        System.out.println("ID       : " + courseId);
        System.out.println("Title    : " + title);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Duration : " + duration + " hours");
        System.out.println("Price    : Rs " + price);
        System.out.println("Progress : " + progress + "%");
    }
    public abstract void calculateProgress(int hours);
    public abstract void generateCertificate();
    public abstract double calculatePrice();
}
