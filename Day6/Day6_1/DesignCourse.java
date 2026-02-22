package Day6.Day6_1;

class DesignCourse extends Course {
    private String softwareUsed;

    public DesignCourse(String courseId, String title, int duration, String instructorName, double price,
            String softwareUsed) {
        super(courseId, title, duration, instructorName, price);
        this.softwareUsed = softwareUsed;
    }

    public void calculateProgress(int completedHours) {
        updateProgress(completedHours);
    }

    public void generateCertificate() {
        if (progress >= 70) {
            System.out.println("Certificate generated for Design Course using " + softwareUsed);
        } else {
            System.out.println("Progress below 70%. Certificate not eligible.");
        }
    }

    public double calculatePrice() {
        double discountedPrice = price - 500;
        return Math.max(discountedPrice, 0);
    }
}
