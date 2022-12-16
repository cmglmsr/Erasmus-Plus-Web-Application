package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ToDoListItem;
import org.springframework.data.repository.CrudRepository;

public interface ToDoListItemRepository extends CrudRepository<ToDoListItem, Long> {
    public void deleteAllByDescriptionAndDueDate(String description, String dueDate);
}
