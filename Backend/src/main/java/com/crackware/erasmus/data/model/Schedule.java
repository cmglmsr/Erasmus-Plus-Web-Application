package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Task> tasks;

    public void addItem(Task task){
        if (tasks != null && !tasks.contains(task)){
            tasks.add(task);
        }
    }
}
