package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class Student extends User{

    //private Group group;


    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                ", id=" + id +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
