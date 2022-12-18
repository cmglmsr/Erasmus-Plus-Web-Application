package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
/**
 * Class which contains properties and functions for ToDoList class
 */
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ToDoListItem> itemSet;

    // Function which add a ToDoListItem instance to a ToDoList instance
    public void addItem(ToDoListItem toDoListItem){
        if (itemSet != null){
            itemSet.add(toDoListItem);
        }
    }


}
