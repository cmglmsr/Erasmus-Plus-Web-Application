package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ToDoList;
import org.springframework.data.repository.CrudRepository;

public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {
}
