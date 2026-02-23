package Day6.Day6_1;

class DesignCourse extends Course {
    private String softwareUsed;

    public DesignCourse(String title, int duration, String instructorName, double price,
            String softwareUsed) {
        super(title, duration, instructorName, price);
        this.softwareUsed = softwareUsed;
    }

    public void calculateProgress(int hours) {
        completedHours += hours;
        if (completedHours > duration) completedHours = duration;
        progress = (completedHours * 100) / duration;
    }

    public void generateCertificate() {
        if (progress >= 70) {
            System.out.println("Certificate generated for Design Course using " + softwareUsed);
        } else {
            System.out.println("Progress below 70%. Certificate not eligible.");
        }
    }

    public double calculatePrice() {
        return Math.max(price - 500, 0);
    }
}
