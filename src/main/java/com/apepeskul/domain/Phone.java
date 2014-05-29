package com.apepeskul.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity

@Table(name = "Phone", uniqueConstraints = @UniqueConstraint(columnNames = {"firstName", "lastNAme"}))

public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String lastName;
    @Pattern(regexp = "^\\d{3}-\\d{3}\\d{2}\\d{2}$")
    private String phone;

    public Phone() {
    }

    public Phone(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
