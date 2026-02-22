package Day6.Day6_1;

 class ManagementCourse extends Course{
    protected int caseStudiesCount;

    public ManagementCourse(String courseId, String title, int duration, String instructorName, double price,
            int caseStudiesCount) {
        super(courseId, title, duration, instructorName, price);
        this.caseStudiesCount = caseStudiesCount;
    }

    public void calculateProgress(int completedHours) {
        updateProgress(completedHours);
    }

    public void generateCertificate() {
       if (progress == 100) {
            System.out.println("Certificate generated for Management Course.");
        } else {
            System.out.println("Course not fully completed. No certificate.");
        }
    }

    public double calculatePrice (){
        return price;
    }

    public double applyDiscount(double percentage) {
       System.out.println("Discount not allowed for Management Course.");
        return price;
    }   
 } 
