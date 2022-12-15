package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
