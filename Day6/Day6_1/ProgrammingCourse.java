package Day6.Day6_1;

class ProgrammingCourse extends Course {
    private String language;

    public ProgrammingCourse( String title, int duration, String instructorName, double price, String language) {
        super(title, duration, instructorName, price);
        this.language = language;
    }

    public void calculateProgress(int hours) {
        completedHours += hours;
        if (completedHours > duration) completedHours = duration;
        progress = (completedHours * 100) / duration;
    }

    public void generateCertificate() {
        if (progress >= 80) {
            System.out.println("Certificate Generated: Programming in " + language);
        } else {
            System.out.println("Complete at least 80% to receive certificate.");
        }
    }

    public double calculatePrice() {
        return duration > 50 ? price * 0.9 : price; // 10% discount
    }

}
