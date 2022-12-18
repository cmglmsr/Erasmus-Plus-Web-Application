package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ToDoList;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for ToDoList class
 */
public interface ToDoLIstRepository extends CrudRepository<ToDoList, Long> {
}
