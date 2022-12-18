package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.ToDoListItem;
import org.springframework.transaction.annotation.Transactional;

@Transactional
/**
 * Interface which acts as a service for ToDoListItem class
 */
public interface ToDoListItemService extends CrudService<ToDoListItem, Long>{
    // Function which deletes a ToDoListItem class instance from the system by description and dueDate parameters
    public void deleteAllByDescriptionAndDueDate(String description, String dueDate);
}
