package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.Department;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Instructor extends BaseEntity{

    private Department department;

}
