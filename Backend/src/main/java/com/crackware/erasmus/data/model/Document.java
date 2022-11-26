package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Document {
    private String name;
    private String type;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
