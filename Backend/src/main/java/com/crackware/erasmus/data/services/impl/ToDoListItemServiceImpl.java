package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.ToDoListItem;
import com.crackware.erasmus.data.repositories.ToDoListItemRepository;
import com.crackware.erasmus.data.services.ToDoListItemService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ToDoListItemServiceImpl implements ToDoListItemService {

    private final ToDoListItemRepository toDoListItemRepository;


    public ToDoListItemServiceImpl(ToDoListItemRepository toDoListItemRepository) {
        this.toDoListItemRepository = toDoListItemRepository;
    }


    @Override
    public Set<ToDoListItem> findAll() {
        HashSet<ToDoListItem> toDoListItems = new HashSet<>();
        toDoListItemRepository.findAll().forEach(toDoListItems::add);
        return toDoListItems;
    }

    @Override
    public ToDoListItem findById(Long aLong) {
        return toDoListItemRepository.findById(aLong).orElse(null);
    }

    @Override
    public ToDoListItem save(ToDoListItem object) {
        return toDoListItemRepository.save(object);
    }

    @Override
    public void delete(ToDoListItem object) {
        toDoListItemRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        toDoListItemRepository.deleteById(aLong);
    }

    @Override
    public void deleteAllByDescriptionAndDueDate(String description, String dueDate) {
        toDoListItemRepository.deleteAllByDescriptionAndDueDate(description,dueDate);
    }
}
