package com.crackware.erasmus.data.model;
public class Instructor {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
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
