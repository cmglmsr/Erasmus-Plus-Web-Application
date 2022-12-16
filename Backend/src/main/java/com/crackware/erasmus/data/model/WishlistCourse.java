package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class WishlistCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String hostUniversityName;
    private String department;
    private String courseCode;
    private String link;
    private Status status;
}
