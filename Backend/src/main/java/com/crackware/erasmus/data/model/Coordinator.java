package com.example.demo.Coordinator;

import javax.swing.text.Document;

public class Coordinator {
    private String department;
    private String signature; // String is used instead of string type

    // Default constructor
    public Coordinator() {
    }

    // Parameter supplied constructor
    public Coordinator(String department, String signature) {
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

    public void viewApplication() {
    }

    public void finalizePlacements() {
        // Sign the string
    }

    public void setWaitingBin() {
        // Sign the string
    }

    public void nominateStudents() {
        // Sign the string
    }

    public void viewCourseWishlist() {
        // Sign the string
    }

    public void processLearningAgreement() {
        // Sign the string
    }

    public void finalCourseTransferForm() {
        // Sign the string
    }

    public void sign(String document) {
        // Sign the document
    }
}
