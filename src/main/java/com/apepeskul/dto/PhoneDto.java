package com.apepeskul.dto;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class PhoneDto implements Serializable {
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String lastName;
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{2}-\\d{2}$")
    private String phone;

    public PhoneDto(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public PhoneDto() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
