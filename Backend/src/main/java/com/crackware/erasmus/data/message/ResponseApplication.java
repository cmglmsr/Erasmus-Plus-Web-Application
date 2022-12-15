package com.crackware.erasmus.data.message;

import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.model.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
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
    public ResponseApplication(Application a) {
        Student s = new Student();
        if(a.getStudent() != null) {
            s = a.getStudent();
        }
        if(s.getName() != null) {
            this.fullname = s.getName();
        }
        if(s.getBilkentId() != null) {
            this.id = s.getBilkentId();
        }
        if(s.getCgpa() != null) {
            this.cgpa = s.getCgpa();
        }
        if(a.getFinalSchool() != null) {
            this.school = a.getFinalSchool().getName();
        }
        else {this.school = null;}
        if(a.getStatus() != null) {
            this.status = a.getStatus().toString();
        }

    }
}
