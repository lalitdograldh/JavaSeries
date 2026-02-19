package Day5_3;

class Doctor extends Person {
    private int doctorId;
    private String specialization;
    private double salary;

    public Doctor(String name, int age, PersonGender gender, int doctorId, String specialization, double salary) {
        super(name, age, gender);
        this.doctorId = doctorId;
        this.specialization = specialization;
        setSalary(salary);
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getSalary() {
        return salary;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }
        this.salary = salary;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Doctor ID      : %d%n", doctorId);
        System.out.printf("Specialization : %s%n", specialization);
        System.out.printf("Salary         : %.2f%n", salary);
    }
}
