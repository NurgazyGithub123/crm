package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class User extends BaseEntity{
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    protected LocalDate dob;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String phoneNumber, LocalDate dob) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.dateCreated = LocalDateTime.now();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
