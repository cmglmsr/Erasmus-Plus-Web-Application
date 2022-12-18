package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.ToDoListItem;
import com.crackware.erasmus.data.repositories.ToDoListItemRepository;
import com.crackware.erasmus.data.services.ToDoListItemService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of ToDoListItemService interface
 */
public class ToDoListItemServiceImpl implements ToDoListItemService {

    private final ToDoListItemRepository toDoListItemRepository;

    // Constructor for ToDoListItemServiceImpl class
    public ToDoListItemServiceImpl(ToDoListItemRepository toDoListItemRepository) {
        this.toDoListItemRepository = toDoListItemRepository;
    }


    @Override
    // Function which finds all ToDoListItem instances by ID
    public Set<ToDoListItem> findAll() {
        HashSet<ToDoListItem> toDoListItems = new HashSet<>();
        toDoListItemRepository.findAll().forEach(toDoListItems::add);
        return toDoListItems;
    }

    @Override
    // Function which finds a ToDoListItem class instance by ID
    public ToDoListItem findById(Long aLong) {
        return toDoListItemRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a ToDoListItem class instance to the system
    public ToDoListItem save(ToDoListItem object) {
        return toDoListItemRepository.save(object);
    }

    @Override
    // Function which deletes a ToDoListItem class instance from the system
    public void delete(ToDoListItem object) {
        toDoListItemRepository.delete(object);
    }

    @Override
    // Function which deletes a ToDoListItem class instance from the system by ID
    public void deleteById(Long aLong) {
        toDoListItemRepository.deleteById(aLong);
    }

    @Override
    // Function which deletes all ToDoListItem class instances from the system by description and dueDate parameters
    public void deleteAllByDescriptionAndDueDate(String description, String dueDate) {
        toDoListItemRepository.deleteAllByDescriptionAndDueDate(description,dueDate);
    }
}
