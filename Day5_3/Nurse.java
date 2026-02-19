package Day5_3;

class Nurse extends Person {
    enum NurseTiming {
        MORNING,
        AFTERNOON,
        NIGHT
    }

    private int nurseId;
    private NurseTiming shiftTiming;
    private double salary;

    public Nurse(String name, int age, PersonGender gender, int nurseId, NurseTiming shiftTiming, double salary) {
        super(name, age, gender);
        setNurseId(nurseId);
        this.shiftTiming = shiftTiming;
        setSalary(salary);
    }

    public int getNurseId() {
        return nurseId;
    }

    public NurseTiming getShiftTiming() {
        return shiftTiming;
    }

    public double getSalary() {
        return salary;
    }

    public void setNurseId(int nurseId) {
        if (nurseId <= 0) {
            throw new IllegalArgumentException("Nurse ID must be positive.");
        }
        this.nurseId = nurseId;
    }

    public void setShiftTiming(NurseTiming shiftTiming) {
        this.shiftTiming = shiftTiming;
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
        System.out.printf("Nurse ID       : %d%n", nurseId);
        System.out.printf("Shift Timing   : %s%n", shiftTiming);
        System.out.printf("Salary         : %.2f%n", salary);
    }
}