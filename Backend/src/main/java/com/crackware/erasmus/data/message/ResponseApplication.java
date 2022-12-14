package com.crackware.erasmus.data.message;

import com.crackware.erasmus.data.model.School;
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
}
