package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.Department;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
/**
 * Class which contains properties and functions for Instructor class
 */
public class Instructor extends BaseEntity{

    private Department department;

}
