package com.apepeskul.domain;

import javax.persistence.*;

/**
 * Created by alex on 27.05.2014.
 */
@Entity

@Table(name = "Phone", uniqueConstraints = @UniqueConstraint(columnNames = {"firstName", "lastNAme"}))

public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String firstName;

    private String lastName;
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
