package Day5_3;

public class HospitalManagementSystemInheritence {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Dr. Smith", 
        45, Person.PersonGender.MALE, 
        101, 
        "Cardiology", 
        150000);
        Patient patient = new Patient("John Doe", 
        30, Person.PersonGender.MALE, 
        201, "Flu", 
        5, 5000, 2000, 1500, 3000);
        Nurse nurse = new Nurse("Nurse Jane", 35, Person.PersonGender.FEMALE, 301, Nurse.NurseTiming.MORNING, 80000); 

        System.out.println("\n===== DOCTOR DETAILS =====");
        doctor.displayDetails();
        
        System.out.println("\n===== NURSE DETAILS =====");
        nurse.displayDetails();

        System.out.println("\n===== PATIENT DETAILS =====");
        patient.displayDetails();

        System.out.println("\n===== FINAL PATIENT DETAILS =====");
        System.out.printf("\nFinal Patient Bill: Rs. %.2f%n", patient.calculateBill());
    }
}
