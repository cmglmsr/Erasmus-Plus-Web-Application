package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ToDoList;
import org.springframework.data.repository.CrudRepository;

public interface ToDoLIstRepository extends CrudRepository<ToDoList, Long> {
}
