package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Schedule;
import com.crackware.erasmus.data.model.ToDoList;
import com.crackware.erasmus.data.repositories.ScheduleRepository;
import com.crackware.erasmus.data.repositories.ToDoListRepository;
import com.crackware.erasmus.data.services.ToDoListService;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }


    @Override
    public Set<ToDoList> findAll() {
        HashSet<ToDoList> toDoLists = new HashSet<>();
        toDoListRepository.findAll().forEach(toDoLists::add);
        return toDoLists;
    }

    @Override
    public ToDoList findById(Long aLong) {
        return toDoListRepository.findById(aLong).orElse(null);
    }

    @Override
    public ToDoList save(ToDoList object) {
        return toDoListRepository.save(object);
    }

    @Override
    public void delete(ToDoList object) {
        toDoListRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        toDoListRepository.deleteById(aLong);
    }
}
