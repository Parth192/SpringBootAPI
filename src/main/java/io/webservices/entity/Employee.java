package io.webservices.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Employee {

    @Id
    @Column ( columnDefinition = "VARCHAR(36)")
    private String id;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String emailId;

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

    public Employee() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", First name='" + firstName + '\'' +
                ", Last name='" + lastName + '\'' +
                ", EmailId='" + emailId + '\'' +
                '}';
    }
}
