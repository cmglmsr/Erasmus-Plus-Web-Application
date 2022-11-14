package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.Document;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class FacultyBoardMember extends BaseEntity{
    private Document signature;
}
