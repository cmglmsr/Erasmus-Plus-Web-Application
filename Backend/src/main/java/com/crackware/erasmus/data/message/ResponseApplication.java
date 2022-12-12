package com.crackware.erasmus.data.message;

public class ResponseApplication {
    private String fullname;
    private String id;
    private String cgpa;
    private String school;
    private String status;

    public ResponseApplication(String fullname, String id, String cgpa, String school, String status) {
        this.fullname = fullname;
        this.id = id;
        this.cgpa = cgpa;
        this.school = school;
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
