package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.List;
import com.crackware.erasmus.data.repositories.ListRepository;
import com.crackware.erasmus.data.services.ListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of ListService interface
 */
public class ListServiceImpl implements ListService {

    private final ListRepository listRepository;

    // Constructor for ListServiceImpl class
    public ListServiceImpl(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    // Function which finds all List instances by ID
    public Set<List> findAll() {
        HashSet<List> lists = new HashSet<>();
        listRepository.findAll().forEach(lists::add);
        return lists;
    }

    @Override
    // Function which finds a List class instance by ID
    public List findById(Long aLong) {
        return listRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a List class instance to the system
    public List save(List object) {
        return listRepository.save(object);
    }

    @Override
    // Function which deletes a List class instance from the system
    public void delete(List object) {
        listRepository.delete(object);
    }

    @Override
    // Function which deletes a List class instance from the system by ID
    public void deleteById(Long aLong) {
        listRepository.deleteById(aLong);
    }
}
