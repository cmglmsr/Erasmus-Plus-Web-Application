package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.BaseEntity;
import com.crackware.erasmus.data.model.Coordinator;
import com.crackware.erasmus.data.repositories.CoordinatorRepository;
import com.crackware.erasmus.data.services.CoordinatorService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of CoordinatorService interface
 */
public class CoordinatorServiceImpl implements CoordinatorService {

    private final CoordinatorRepository coordinatorRepository;
    // Constructor for CoordinatorServiceImpl class
    public CoordinatorServiceImpl(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }

    @Override
    // Function which finds all Coordinator instances by ID
    public Set<Coordinator> findAll() {
        HashSet<Coordinator> coordinators = new HashSet<>();
        coordinatorRepository.findAll().forEach(coordinators::add);
        return coordinators;
    }

    @Override
    // Function which finds a Coordinator class instance by ID
    public Coordinator findById(Long aLong) {
        return coordinatorRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a Coordinator class instance to the system
    public Coordinator save(Coordinator object) {
        return coordinatorRepository.save(object);
    }

    @Override
    // Function which deletes a Coordinator class instance from the system
    public void delete(Coordinator object) {
        coordinatorRepository.delete(object);
    }

    @Override
    // Function which deletes a Coordinator class instance from the system by ID
    public void deleteById(Long aLong) {
        coordinatorRepository.deleteById(aLong);
    }

    @Override

// Function which finds a Coordinator class instance by email
    public BaseEntity findByEmail(String email) {
        return coordinatorRepository.findByMail(email);
    }
}
