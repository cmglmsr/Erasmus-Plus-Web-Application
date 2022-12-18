package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
/**
 * Class which contains properties and functions for Application class
 */
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JsonIgnore
    private Student student;

    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToOne()
    private School school1;

    @OneToOne()
    private School school2;

    @OneToOne()
    private School school3;

    @OneToOne()
    private School school4;

    @OneToOne()
    private School school5;

    @OneToOne(cascade=CascadeType.ALL)
    private School finalSchool;

    @OrderColumn
    private double points;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String term;

    private Date date;
}
