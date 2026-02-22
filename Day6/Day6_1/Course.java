package Day6.Day6_1;

import java.util.UUID;

abstract class Course implements Trackable, Discountable, Rateable {
    enum CourseStatus {
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED
    }

    protected String courseId;
    protected String title;
    protected int duration; // in hours
    protected String instructorName;
    protected double price;
    protected int progress; // (0–100)
    protected int totalRating = 0;
    protected int ratingCount = 0;
    protected int completedHours;

    protected CourseStatus status; // Not Started, In Progress, Completed

    public Course(String courseId, String title, int duration, String instructorName, double price) {
        this.courseId = generateCourseId();
        this.title = title;
        this.duration = duration;
        this.instructorName = instructorName;
        this.price = price;
        this.completedHours = 0;
        this.progress = 0; // Default progress
        this.status = CourseStatus.NOT_STARTED; // Default status
    }

    public abstract void calculateProgress(int completedHours);

    public abstract void generateCertificate();

    public abstract double calculatePrice();

    public void enrollStudent(String studentName) {
        System.out.println(studentName + " has enrolled in " + title);
    }

    public void updateProgress(int hours) {
        if (hours <= 0)
            return;

        completedHours += hours;

        if (completedHours > duration) {
            completedHours = duration;
        }

        progress = (completedHours * 100) / duration;

        if (progress == 0) {
            status = CourseStatus.NOT_STARTED;
        } else if (progress < 100) {
            status = CourseStatus.IN_PROGRESS;
        } else {
            status = CourseStatus.COMPLETED;
        }
    }

    public int getProgress() {
        return progress;
    }

    private String generateCourseId() {
        return UUID.randomUUID().toString();
    }

    public double applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            return price;
        }
        return price - (price * (percentage / 100));
    }

    public void giveRating(int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5.");
            return;
        }
        totalRating += rating;
        ratingCount++;
    }

    public double getAverageRating() {
        if (ratingCount == 0)
            return 0;
        return (double) totalRating / ratingCount;
    }

    public void showCourseDetails() {
        System.out.println("\n===== COURSE DETAILS =====");
        System.out.println("Course ID      : " + courseId);
        System.out.println("Title          : " + title);
        System.out.println("Instructor     : " + instructorName);
        System.out.println("Duration       : " + duration + " hours");
        System.out.println("Completed Hours: " + completedHours);
        System.out.println("Progress       : " + progress + "%");
        System.out.println("Status         : " + status);
        System.out.println("Price          : Rs " + calculatePrice());
        System.out.println("==========================");
    }
}
