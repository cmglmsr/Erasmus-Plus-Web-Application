package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.model.enums.School;
import com.crackware.erasmus.data.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
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

    @ElementCollection(targetClass= School.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="application_schools")
    @Column(name="schools")
    private Set<School> schools;

    private double points;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private School admittedSchool;

    private Date date;
}
