package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.Task;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TaskService extends CrudService<Task, Long>{
    public void deleteAllByDescriptionAndDueDate(String description, String dueDate);
}
