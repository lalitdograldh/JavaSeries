package Day8;

class StudentData {
    String studentName = "John";
    int studentID = 15;
    int studentAge = 23;
    float studentFee = 75.25f;
    char studentGrade = 'B';

    public static void main(String[] args) {
        StudentData student = new StudentData();
        System.out.println("Student name: " + student.studentName);
        System.out.println("Student id: " + student.studentID);
        System.out.println("Student age: " + student.studentAge);
        System.out.println("Student fee: " + student.studentFee);
        System.out.println("Student grade: " + student.studentGrade);

    }

}
