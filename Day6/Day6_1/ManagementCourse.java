package Day6.Day6_1;

 class ManagementCourse extends Course{
    protected int caseStudiesCount;

    public ManagementCourse(String title, int duration, String instructorName, double price,
            int caseStudiesCount) {
        super(title, duration, instructorName, price);
        this.caseStudiesCount = caseStudiesCount;
    }

    public void calculateProgress(int hours) {
        completedHours += hours;
        if (completedHours > duration) completedHours = duration;
        progress = (completedHours * 100) / duration;
    }

    public void generateCertificate() {
       if (progress == 100) {
            System.out.println("Certificate generated for Management Course.");
        } else {
            System.out.println("Course not fully completed. No certificate.");
        }
    }

    public double calculatePrice() {
        return price;
    }
   
 } 
