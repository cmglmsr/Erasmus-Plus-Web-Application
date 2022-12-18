package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.ItemType;
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
/**
 * Class which contains properties and functions for ToDoListItem class
 */
public class ToDoListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dueDate;

    private ItemType itemType;

    private String description;

    private boolean done;
}
