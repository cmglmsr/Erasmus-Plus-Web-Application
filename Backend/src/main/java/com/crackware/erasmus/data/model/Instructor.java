package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Instructor extends BaseEntity{
    private String department;

    // Default constructor
    public Instructor() {
    }

    // Parameter supplied constructor
    public Instructor(String department) {
        this.department = department;
    }

}
