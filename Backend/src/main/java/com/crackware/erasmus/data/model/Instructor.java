package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Instructor extends BaseEntity{
    private String department;
    private String signature;

    // Default constructor
    public Instructor() {
    }

    // Parameter supplied constructor
    public Instructor(String department, String signature) {
        this.department = department;
        this.signature = signature;
    }

    public boolean processCourse(String course) {
        // Check the requirements
        return true;
    }

    public void sign(String document) {
        // Sign the document
    }
}
