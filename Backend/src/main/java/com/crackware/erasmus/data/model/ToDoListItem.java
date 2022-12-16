package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"dueDate", "description"})
)
public class ToDoListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dueDate;

    private String description;

    private boolean done;
}
