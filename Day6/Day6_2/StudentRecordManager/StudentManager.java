package Day6.Day6_2.StudentRecordManager;

import java.io.*;

public class StudentManager {

    private static final String FILE_NAME = "students.txt";

    // Constructor - create file if not exists
    public StudentManager() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Error creating file.");
        }
    }

    // ================= ADD =================
    public void addStudent(Student student) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)));
            pw.println(student.toFileString());
            pw.close();
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding student.");
        }
    }

    // ================= VIEW =================
    public void viewStudents() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 4) {
                    Student student = new Student(data[0], data[1], data[2], data[3]);
                    student.display();
                }
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    // ================= SEARCH =================
    public void searchStudent(String rollNo) {
        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 4 && data[0].equals(rollNo)) {
                    Student student = new Student(data[0], data[1], data[2], data[3]);
                    student.display();
                    found = true;
                    break;
                }
            }

            br.close();

            if (!found) {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            System.out.println("Error searching file.");
        }
    }

    // ================= UPDATE =================
    public void updateStudent(String rollNo, Student updatedStudent) {

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 4 && data[0].equals(rollNo)) {
                    pw.println(updatedStudent.toFileString());
                    found = true;
                } else {
                    pw.println(line);
                }
            }

            br.close();
            pw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (found) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            System.out.println("Error updating student.");
        }
    }

    // ================= DELETE =================
    public void deleteStudent(String rollNo) {

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 4 && data[0].equals(rollNo)) {
                    found = true; // skip this line
                } else {
                    pw.println(line);
                }
            }

            br.close();
            pw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (found) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting student.");
        }
    }
}