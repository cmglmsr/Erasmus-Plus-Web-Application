package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ToDoListItem;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for ToDoListItem class
 */
public interface ToDoListItemRepository extends CrudRepository<ToDoListItem, Long> {
    // Abstract function which deletes a ToDoListItem class instance by description and dueDate parameters
    public void deleteAllByDescriptionAndDueDate(String description, String dueDate);
}
