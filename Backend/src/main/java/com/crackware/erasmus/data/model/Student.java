package com.crackware.erasmus.data.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Student extends BaseEntity{

    @Enumerated
    private Department department;

    private double cgpa;

    private int term;

    @ElementCollection(targetClass=Language.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="student_languages")
    @Column(name="languages")
    private Set<Language> languages;

    @OneToOne
    private Application application;

}
