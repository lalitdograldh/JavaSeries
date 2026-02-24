package Day6.Day6_2.StudentRecordManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n===== Student Record Manager =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    String roll = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Class: ");
                    String studentClass = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    String marks = sc.nextLine();

                    manager.addStudent(new Student(roll, name, studentClass, marks));
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    manager.searchStudent(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Roll No to update: ");
                    String updateRoll = sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Class: ");
                    String newClass = sc.nextLine();

                    System.out.print("Enter New Marks: ");
                    String newMarks = sc.nextLine();

                    manager.updateStudent(updateRoll,
                            new Student(updateRoll, newName, newClass, newMarks));
                    break;

                case 5:
                    System.out.print("Enter Roll No to delete: ");
                    manager.deleteStudent(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}