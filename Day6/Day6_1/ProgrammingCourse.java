package Day6.Day6_1;

class ProgrammingCourse extends Course {
    private String language;

    public ProgrammingCourse(String courseId, String title, int duration, String instructorName, double price, String language) {
        super(courseId, title, duration, instructorName, price);
        this.language = language;
    }

    public void calculateProgress(int completedHours) {
        updateProgress(completedHours);
    }

    public void generateCertificate() {
        if (progress >= 80) {
            System.out.println("Certificate Generated: Programming in " + language);
        } else {
            System.out.println("Complete at least 80% to receive certificate.");
        }
    }

    public double calculatePrice() {
        if (duration > 50) {
            return price - (price * 0.10); // 10% discount for courses longer than 50 hours            
        }
        return price;
    }

}
