package Day6.Day6_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagementSystem {

    private static final String DATA_FILE = "enrollments.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Enrollment> enrollments = loadEnrollments();

        // Dynamic courses
        courses.add(new ProgrammingCourse("Java Mastery", 60, "Mr. Sharma", 10000, "Java"));
        courses.add(new DesignCourse("UI/UX Design", 40, "Ms. Kapoor", 8000, "Figma"));
        courses.add(new ManagementCourse("Business Strategy", 30, "Dr. Mehta", 12000, 10));

        while (true) {
            System.out.println("\n===== COURSE MENU =====");
            System.out.println("1. View All Courses");
            System.out.println("2. Enroll Student");
            System.out.println("3. Search Course");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.hasNextInt() ? sc.nextInt() : -1;
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewCourses(courses);
                    break;
                case 2:
                    enrollStudent(sc, courses, enrollments);
                    break;
                case 3:
                    searchCourse(sc, courses);
                    break;
                case 4:
                    saveEnrollments(enrollments);
                    System.out.println("Exiting system...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewCourses(ArrayList<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("\nCourse Index: " + i);
            courses.get(i).showCourseDetails();
        }
    }

    private static void enrollStudent(Scanner sc, ArrayList<Course> courses, ArrayList<Enrollment> enrollments) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        // Check unique email
        for (Enrollment e : enrollments) {
            if (e.getStudentEmail().equalsIgnoreCase(email)) {
                System.out.println("Email already exists. Cannot enroll.");
                return;
            }
        }

        Student student = new Student(name, email);

        System.out.println("Select Course Index:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + " - " + courses.get(i).getTitle());
        }

        int index = sc.hasNextInt() ? sc.nextInt() : -1;
        sc.nextLine();

        if (index < 0 || index >= courses.size()) {
            System.out.println("Invalid course index!");
            return;
        }

        Enrollment enrollment = new Enrollment(student, courses.get(index));
        enrollment.enroll();
        enrollments.add(enrollment);
        System.out.println("Enrollment successful!");
    }

    private static void searchCourse(Scanner sc, ArrayList<Course> courses) {
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;
        for (Course c : courses) {
            if (c.getTitle().toLowerCase().contains(keyword)) {
                found = true;
                System.out.println("\nCourse Found:");
                c.showCourseDetails();
            }
        }

        if (!found) System.out.println("No matching course found.");
    }

    private static void saveEnrollments(ArrayList<Enrollment> enrollments) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(enrollments);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static ArrayList<Enrollment> loadEnrollments() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (ArrayList<Enrollment>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>(); // file not found or empty
        }
    }
}