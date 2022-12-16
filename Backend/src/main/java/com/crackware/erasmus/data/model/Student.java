package com.crackware.erasmus.data.model;


import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.model.enums.Language;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Student extends BaseEntity{

    @Enumerated
    private Department department;

    private String gender;

    private String nationalID;
    private String cgpa;
    private String eng101grade;
    private String eng102grade;

    private String bilkentId;

    private int term;

    private String address;

    private String phoneNumber;

    @ElementCollection(targetClass= Language.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="student_languages")
    @Column(name="languages")
    private Set<Language> languages;

    @OneToOne
    @Nullable
    private Application application;

    public double calculatePoints() {
        double total = 0; double eng101 = 0; double eng102 = 0;
        switch(eng101grade) {
            case("A+"): eng101 = 25; break;
            case("A"): eng101 = 25; break;
            case("A-"): eng101 = 23.125; break;
            case("B+"): eng101 = 20.625; break;
            case("B"): eng101 = 18.75; break;
            case("B-"): eng101 = 16.875; break;
            case("C+"): eng101 = 14.375; break;
            case("C"): eng101 = 12.5; break;
            case("C-"): eng101 = 10.625; break;
            case("D+"): eng101 = 8.125; break;
            case("D"): eng101 = 6.25; break;
            case("F"): eng101 = 0; break;
            case("FX"): eng101 = 0; break;
            case("FZ"): eng101 = 0; break;
        }
        switch(eng102grade) {
            case("A+"): eng102 = 25; break;
            case("A"): eng102 = 25; break;
            case("A-"): eng102 = 23.125; break;
            case("B+"): eng102 = 20.625; break;
            case("B"): eng102 = 18.75; break;
            case("B-"): eng102 = 16.875; break;
            case("C+"): eng102 = 14.375; break;
            case("C"): eng102 = 12.5; break;
            case("C-"): eng102 = 10.625; break;
            case("D+"): eng102 = 8.125; break;
            case("D"): eng102 = 6.25; break;
            case("F"): eng102 = 0; break;
            case("FX"): eng102 = 0; break;
            case("FZ"): eng102 = 0; break;
        }
        double thsCgpa = Double.parseDouble(this.cgpa);
        total = eng101 + eng102 + ((thsCgpa/4)*50);
        System.out.println("eng101 grade "+ eng101);
        System.out.println("eng102 grade "+ eng102);
        System.out.println("total: " + total);
        return total;
    }
}
