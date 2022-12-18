package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.ToDoList;
import com.crackware.erasmus.data.repositories.ToDoLIstRepository;
import com.crackware.erasmus.data.services.ToDoListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of ToDoListService interface
 */
public class ToDoListServiceImpl implements ToDoListService {

    private final ToDoLIstRepository toDoLIstRepository;
    // Constructor for ToDoListServiceImpl class
    public ToDoListServiceImpl(ToDoLIstRepository toDoLIstRepository) {
        this.toDoLIstRepository = toDoLIstRepository;
    }


    @Override
    // Function which finds all ToDoList instances by ID
    public Set<ToDoList> findAll() {
        HashSet<ToDoList> toDoLists = new HashSet<>();
        toDoLIstRepository.findAll().forEach(toDoLists::add);
        return toDoLists;
    }

    @Override
    // Function which finds a ToDoList class instance by ID
    public ToDoList findById(Long aLong) {
        return toDoLIstRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a ToDoList class instance to the system
    public ToDoList save(ToDoList object) {
        return toDoLIstRepository.save(object);
    }

    @Override
    // Function which deletes a ToDoList class instance from the system
    public void delete(ToDoList object) {
        toDoLIstRepository.delete(object);
    }

    @Override
    // Function which deletes a ToDoList class instance from the system by ID
    public void deleteById(Long aLong) {
        toDoLIstRepository.deleteById(aLong);
    }
}
