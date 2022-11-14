package com.crackware.erasmus.data.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@Entity
public class Student extends BaseEntity{

    @Enumerated
    private Department department;

    private double cgpa;

    private int term;

    private Set<Language> languages;

}
