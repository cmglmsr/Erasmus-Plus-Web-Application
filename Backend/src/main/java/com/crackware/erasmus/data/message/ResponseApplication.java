package com.crackware.erasmus.data.message;

import lombok.Getter;
import lombok.Setter;

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
