package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.model.enums.Status;
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
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)
    private Student student;

    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToOne(cascade=CascadeType.ALL)
    private School school1;

    @OneToOne(cascade=CascadeType.ALL)
    private School school2;

    @OneToOne(cascade=CascadeType.ALL)
    private School school3;

    @OneToOne(cascade=CascadeType.ALL)
    private School school4;

    @OneToOne(cascade=CascadeType.ALL)
    private School school5;

    @OneToOne(cascade=CascadeType.ALL)
    private School finalSchool;

    @OrderColumn
    private double points;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Date date;
}
