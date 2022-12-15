package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Task;
import com.crackware.erasmus.data.repositories.TaskRepository;
import com.crackware.erasmus.data.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class TaskImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskImpl(TaskRepository scheduleRepository) {
        this.taskRepository = scheduleRepository;
    }


    @Override
    public Set<Task> findAll() {
        HashSet<Task> tasks = new HashSet<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    @Override
    public Task findById(Long aLong) {
        return taskRepository.findById(aLong).orElse(null);
    }

    @Override
    public Task save(Task object) {
        return taskRepository.save(object);
    }

    @Override
    public void delete(Task object) {
        taskRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        taskRepository.deleteById(aLong);
    }
}
