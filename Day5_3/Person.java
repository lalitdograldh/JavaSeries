package Day5_3;

class Person {
    enum PersonGender {
        MALE,
        FEMALE,
        OTHER
    }

    private String name;
    private int age;

    private PersonGender gender;

    public Person(String name, int age, PersonGender gender) {
        this.name = name;
        setAge(age);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public PersonGender getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }

        this.age = age;
    }

    public void setGender(PersonGender gender) {
        this.gender = gender;
    }

    public void displayDetails() {
        System.out.printf("Person Details%n");
        System.out.printf("---------------%n");
        System.out.printf("Name   : %s%n", name);
        System.out.printf("Age    : %d%n", age);
        System.out.printf("Gender : %s%n", gender);
    }

}