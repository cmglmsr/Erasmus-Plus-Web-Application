package com.crackware.erasmus.data.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"date", "dueDate", "description"})
)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String dueDate;

    private String description;

    private boolean done;



}
