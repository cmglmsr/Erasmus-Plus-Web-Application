package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.Department;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
/**
 * Class which contains properties and functions for Coordinator class
 */
public class Coordinator extends BaseEntity {

    private Department department;

    private String signature; // String is used instead of string type

}
