package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.ApplicationList;
import com.crackware.erasmus.data.repositories.ApplicationListRepository;
import com.crackware.erasmus.data.services.ApplicationListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of ApplicationListService interface
 */
public class ApplicationListServiceImpl implements ApplicationListService {

    private final ApplicationListRepository applicationListRepository;
    // Constructor for ApplicationListServiceImpl class
    public ApplicationListServiceImpl(ApplicationListRepository applicationListRepository) {
        this.applicationListRepository = applicationListRepository;
    }

    @Override
    public Set<ApplicationList> findAll() {
        HashSet<ApplicationList> applicationLists = new HashSet<>();
        applicationListRepository.findAll().forEach(applicationLists::add);
        return applicationLists;
    }

    @Override
    // Function which finds an ApplicationList class instance by ID
    public ApplicationList findById(Long aLong) {
        return applicationListRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves an ApplicationList class instance to the system
    public ApplicationList save(ApplicationList object) {
        return applicationListRepository.save(object);
    }

    @Override
    // Function which deletes an ApplicationList class instance from the system
    public void delete(ApplicationList object) {
        applicationListRepository.delete(object);
    }

    @Override
    // Function which deletes an ApplicationList class instance from the system by ID
    public void deleteById(Long aLong) {
        applicationListRepository.deleteById(aLong);
    }
}
