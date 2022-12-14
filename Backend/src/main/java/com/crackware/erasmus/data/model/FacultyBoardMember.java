package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.Document;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class FacultyBoardMember extends BaseEntity{
    @OneToOne
    private Document signature;
}
