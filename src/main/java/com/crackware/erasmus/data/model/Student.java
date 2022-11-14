package com.crackware.erasmus.data.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Student extends BaseEntity{

    private Department department;

    private double cgpa;

    private int term;

    private Set<Language> languages;

}
