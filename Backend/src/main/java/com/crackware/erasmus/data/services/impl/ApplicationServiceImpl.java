package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.repositories.ApplicationRepository;
import com.crackware.erasmus.data.repositories.StudentRepository;
import com.crackware.erasmus.data.services.ApplicationService;
import com.crackware.erasmus.data.services.CoordinatorService;
import com.crackware.erasmus.data.services.ToDoListItemService;
import com.crackware.erasmus.data.services.ToDoListService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of ApplicationService interface
 */
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    private final StudentRepository studentRepository;

    private final ToDoListService toDoListService;

    private final ToDoListItemService toDoListItemService;

    private final CoordinatorService coordinatorService;

    // Constructor for ApplicationServiceImpl class
    public ApplicationServiceImpl(ApplicationRepository applicationRepository, StudentRepository studentRepository, ToDoListService toDoListService, ToDoListItemService toDoListItemService, CoordinatorService coordinatorService) {
        this.studentRepository = studentRepository;
        this.applicationRepository = applicationRepository;
        this.toDoListService = toDoListService;
        this.toDoListItemService = toDoListItemService;
        this.coordinatorService = coordinatorService;
    }

    @Override
    // Function which finds all Application instances by ID
    public Set<Application> findAll() {
        HashSet<Application> applications = new HashSet<>();
        applicationRepository.findAll().forEach(applications::add);
        return applications;
    }

    @Override
    // Function which finds an Application class instance by ID
    public Application findById(Long aLong) {
        return applicationRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves an Admin class instance to the system
    public Application save(Application object) {
        return applicationRepository.save(object);
    }

    @Override
    // Function which deletes an Admin class instance from the system
    public void delete(Application object) {
        applicationRepository.delete(object);
    }

    @Override
    // Function which deletes an Admin class instance from the system by ID
    public void deleteById(Long aLong) {
        applicationRepository.deleteById(aLong);
    }
}
