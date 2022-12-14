package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.WaitList;
import com.crackware.erasmus.data.repositories.WaitListRepository;
import com.crackware.erasmus.data.services.WaitListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class WaitListServiceImpl implements WaitListService {

    private final WaitListRepository waitListRepository;

    public WaitListServiceImpl(WaitListRepository waitListRepository) {
        this.waitListRepository = waitListRepository;
    }

    @Override
    public Set<WaitList> findAll() {
        HashSet<WaitList> waitLists = new HashSet<>();
        waitListRepository.findAll().forEach(waitLists::add);
        return waitLists;
    }

    @Override
    public WaitList findById(Long aLong) {
        return waitListRepository.findById(aLong).orElse(null);
    }

    @Override
    public WaitList save(WaitList object) {
        return waitListRepository.save(object);
    }

    @Override
    public void delete(WaitList object) {
        waitListRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        waitListRepository.deleteById(aLong);
    }
}
