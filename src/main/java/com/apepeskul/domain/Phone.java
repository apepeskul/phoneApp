package com.apepeskul.domain;

import javax.persistence.*;

/**
 * Created by alex on 27.05.2014.
 */
@Entity
@Table (name = "Phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

private String name;
private String phone;

    public Phone(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
