package Encapsulation.P01SortByNameAndAge;

public class Person1 {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Constructor
    public Person1(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void increaseSalary(double percentage) {
        if (this.getAge() < 30) {
            this.setSalary(this.getSalary() +
                    (this.getSalary() * percentage / 200));
        } else {
            this.setSalary(this.getSalary() +
                    (this.getSalary() * percentage / 100));
        }
    }

    // Override toString() method
    @Override
    public String toString() {
        return String.format("%s %s gets %s leva.",
                this.getFirstName(),
                this.getLastName(),
                this.getSalary());
    }
}


