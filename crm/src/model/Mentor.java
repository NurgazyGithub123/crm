package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class Mentor extends User{

    private double salary;

    public Mentor() {
    }

    public Mentor(Long id, String firstName, String lastName, String email, String phoneNumber, LocalDate dob, double salary) {
        super(id, firstName, lastName, email, phoneNumber, dob);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                ", id=" + id +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
