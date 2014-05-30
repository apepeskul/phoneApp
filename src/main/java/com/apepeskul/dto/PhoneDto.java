package com.apepeskul.dto;

import com.apepeskul.domain.Phone;
import com.apepeskul.service.validator.UniqueColumn;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
//@UniqueColumn(properties = {"lastName", "phone"})
public class PhoneDto implements Serializable {
    private Long id;
    @Pattern(regexp = "^[a-zA-Z ]+$",  message = "Letters and spaces allowed")
    @UniqueColumn(entity = Phone.class, property = "firstName")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z ]+$",  message = "Letters and spaces allowed")
    @UniqueColumn(entity = Phone.class, property = "lastName")
    private String lastName;
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{2}-\\d{2}$", message = "Digits with - separator allowed")
    @UniqueColumn(entity = Phone.class, property = "phone")
    private String phone;



    public PhoneDto(long id, String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
