package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.ToDoList;
import com.crackware.erasmus.data.repositories.ToDoLIstRepository;
import com.crackware.erasmus.data.services.ToDoListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    private final ToDoLIstRepository toDoLIstRepository;

    public ToDoListServiceImpl(ToDoLIstRepository toDoLIstRepository) {
        this.toDoLIstRepository = toDoLIstRepository;
    }


    @Override
    public Set<ToDoList> findAll() {
        HashSet<ToDoList> toDoLists = new HashSet<>();
        toDoLIstRepository.findAll().forEach(toDoLists::add);
        return toDoLists;
    }

    @Override
    public ToDoList findById(Long aLong) {
        return toDoLIstRepository.findById(aLong).orElse(null);
    }

    @Override
    public ToDoList save(ToDoList object) {
        return toDoLIstRepository.save(object);
    }

    @Override
    public void delete(ToDoList object) {
        toDoLIstRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        toDoLIstRepository.deleteById(aLong);
    }
}
