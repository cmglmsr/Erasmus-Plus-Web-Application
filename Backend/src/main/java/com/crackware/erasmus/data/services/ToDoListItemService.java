package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.ToDoListItem;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ToDoListItemService extends CrudService<ToDoListItem, Long>{
    public void deleteAllByDescriptionAndDueDate(String description, String dueDate);
}
