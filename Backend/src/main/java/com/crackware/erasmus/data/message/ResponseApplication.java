package com.crackware.erasmus.data.message;

import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.model.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
/**
 * Class which contains properties and functions for response of Application class
 */
public class ResponseApplication {
    private String fullname;
    private String id;
    private String cgpa;
    private String school;
    private String status;
    private String pref1;
    private String pref2;
    private String pref3;
    private String pref4;
    private String pref5;
    private String timePeriod;
    private Long uid;

    // Default constructor
    public ResponseApplication() {}

    // Parameter supplied constructor
    public ResponseApplication(String fullname, String id, String cgpa, String school, String status) {
        this.fullname = fullname;
        this.id = id;
        this.cgpa = cgpa;
        this.school = school;
        this.status = status;
    }
    // Constructor which takes an Application instance
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
        if(a.getTerm()!=null){
            this.timePeriod = a.getTerm();
        }

        if(a.getSchool1() != null) {
            this.pref1 = a.getSchool1().getName();
        }
        if(a.getSchool2() != null) {
            this.pref2 = a.getSchool2().getName();
        }
        if(a.getSchool3() != null) {
            this.pref3 = a.getSchool3().getName();
        }
        if(a.getSchool4() != null) {
            this.pref4 = a.getSchool4().getName();
        }
        if(a.getSchool5() != null) {
            this.pref5 = a.getSchool5().getName();
        }
        this.uid = a.getId();

    }
}
