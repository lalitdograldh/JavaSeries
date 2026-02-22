package Day6.Day6_1;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        // Pre-created courses
        courses.add(new ProgrammingCourse("CRS100","Java Mastery", 60, "Mr. Sharma", 10000, "Java"));
        courses.add(new DesignCourse("CRS101","UI/UX Design", 40, "Ms. Kapoor", 8000, "Figma"));
        courses.add(new ManagementCourse("CRS102","Business Strategy", 30, "Dr. Mehta", 12000, 10));

        while (true) {

            System.out.println("\n===== COURSE MENU =====");
            System.out.println("1. View All Courses");
            System.out.println("2. Enroll Student");
            System.out.println("3. Search Course");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    for (Course c : courses) {
                        c.showCourseDetails();
                    }
                    break;

                case 2:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    Student student = new Student(name, email);

                    System.out.println("Select Course Index:");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println(i + " - " + courses.get(i).title);
                    }

                    int index = sc.nextInt();

                    Enrollment enrollment =
                            new Enrollment(student, courses.get(index));

                    enrollment.enroll();
                    break;

                case 3:
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine().toLowerCase();

                    for (Course c : courses) {
                        if (c.title.toLowerCase().contains(keyword)) {

                            // instanceof filtering
                            if (c instanceof ProgrammingCourse) {
                                System.out.println("Programming Course Found:");
                            }
                            else if (c instanceof DesignCourse) {
                                System.out.println("Design Course Found:");
                            }
                            else if (c instanceof ManagementCourse) {
                                System.out.println("Management Course Found:");
                            }

                            c.showCourseDetails();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}