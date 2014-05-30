package com.apepeskul.domain;

import javax.persistence.*;

@Entity

@Table(name = "Phone", uniqueConstraints = @UniqueConstraint(columnNames = {"firstName", "lastNAme"}))

public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Pattern(regexp = "^[a-zA-Z ]+$", message = "Letters and spaces allowed")
    private String firstName;
    //@Pattern(regexp = "^[a-zA-Z ]+$", message = "Letters and spaces allowed")
    private String lastName;
    //@Pattern(regexp = "^\\d{3}-\\d{3}-\\d{2}-\\d{2}$", message = "Digits with - separator allowed")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
