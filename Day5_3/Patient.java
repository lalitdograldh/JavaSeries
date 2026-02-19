package Day5_3;

class Patient extends Person {
    private double doctorFee;
    private double medicineCharges;
    private double testCharges;
    private double nursingCharges;
    private int patientId;
    private String disease;
    private int admittedDays;

    public Patient(String name, int age, PersonGender gender, int patientId, String disease, int admittedDays,
            double doctorFee, double medicineCharges, double testCharges, double nursingCharges) {
        super(name, age, gender);

        setPatientId(patientId);
        this.disease = disease;
        setAdmittedDays(admittedDays);

        setDoctorFee(doctorFee);
        setMedicineCharges(medicineCharges);
        setTestCharges(testCharges);
        setNursingCharges(nursingCharges);
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDisease() {
        return disease;
    }

    public int getAdmittedDays() {
        return admittedDays;
    }

    public double getDoctorFee() {
        return doctorFee;
    }

    public double getMedicineCharges() {
        return medicineCharges;
    }

    public double getTestCharges() {
        return testCharges;
    }

    public double getNursingCharges() {
        return nursingCharges;
    }

    public void setDoctorFee(double doctorFee) {
        if (doctorFee < 0) {
            throw new IllegalArgumentException("Doctor fee cannot be negative.");
        }
        this.doctorFee = doctorFee;
    }

    public void setMedicineCharges(double medicineCharges) {
        if (medicineCharges < 0) {
            throw new IllegalArgumentException("Medicine charges cannot be negative.");
        }
        this.medicineCharges = medicineCharges;
    }

    public void setTestCharges(double testCharges) {
        if (testCharges < 0) {
            throw new IllegalArgumentException("Test charges cannot be negative.");
        }
        this.testCharges = testCharges;
    }

    public void setNursingCharges(double nursingCharges) {
        if (nursingCharges < 0) {
            throw new IllegalArgumentException("Nursing charges cannot be negative.");
        }
        this.nursingCharges = nursingCharges;
    }

    public void setPatientId(int patientId) {
        if (patientId <= 0) {
            throw new IllegalArgumentException("Patient ID must be positive.");
        }
        this.patientId = patientId;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setAdmittedDays(int admittedDays) {
        if (admittedDays < 0) {
            throw new IllegalArgumentException("Admitted days cannot be negative.");
        }
        this.admittedDays = admittedDays;
    }

    public double calculateBill() {
        double roomCharges = admittedDays * 2000; // Assuming a fixed rate of 2000 per day
        return roomCharges + doctorFee + medicineCharges + testCharges + nursingCharges;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();

        System.out.printf("Patient ID     : %d%n", patientId);
        System.out.printf("Disease        : %s%n", disease);
        System.out.printf("Admitted Days  : %d%n", admittedDays);
        System.out.println("------------------------------------------------------");
        System.out.println("---- ------------------Charges -----------------------");
        System.out.printf("Room Charges   : Rs. %.2f%n", admittedDays * 2000.0);
        System.out.printf("Doctor Fee     : Rs. %.2f%n", doctorFee);
        System.out.printf("Medicine       : Rs. %.2f%n", medicineCharges);
        System.out.printf("Tests          : Rs. %.2f%n", testCharges);
        System.out.printf("Nursing        : Rs. %.2f%n", nursingCharges);
        System.out.printf("Total Bill     : Rs. %.2f%n", calculateBill());
    }

}
