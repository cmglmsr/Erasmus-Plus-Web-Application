package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.WaitList;
import com.crackware.erasmus.data.repositories.WaitListRepository;
import com.crackware.erasmus.data.services.WaitListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of WaitListService interface
 */
public class WaitListServiceImpl implements WaitListService {

    private final WaitListRepository waitListRepository;
    // Constructor for WaitListServiceImpl class
    public WaitListServiceImpl(WaitListRepository waitListRepository) {
        this.waitListRepository = waitListRepository;
    }

    @Override
    // Function which finds all WaitList instances by ID
    public Set<WaitList> findAll() {
        HashSet<WaitList> waitLists = new HashSet<>();
        waitListRepository.findAll().forEach(waitLists::add);
        return waitLists;
    }

    @Override
    // Function which finds a WaitList class instance by ID
    public WaitList findById(Long aLong) {
        return waitListRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a WaitList class instance to the system
    public WaitList save(WaitList object) {
        return waitListRepository.save(object);
    }

    @Override
    // Function which deletes a WaitList class instance from the system
    public void delete(WaitList object) {
        waitListRepository.delete(object);
    }

    @Override
    // Function which deletes a WaitList class instance from the system by ID
    public void deleteById(Long aLong) {
        waitListRepository.deleteById(aLong);
    }

    @Override
    // Function which deletes all WaitList class instances from the system
    public void deleteAll() {
        waitListRepository.deleteAll();
    }


}
