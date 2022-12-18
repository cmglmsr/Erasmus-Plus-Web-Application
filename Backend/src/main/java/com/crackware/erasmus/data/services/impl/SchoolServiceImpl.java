package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.repositories.SchoolRepository;
import com.crackware.erasmus.data.services.SchoolService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of SchoolService interface
 */
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    // Constructor for SchoolServiceImpl class
    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    // Function which finds all School instances by ID
    public Set<School> findAll() {
        HashSet<School> schools = new HashSet<>();
        schoolRepository.findAll().forEach(schools::add);
        return schools;
    }

    @Override
    // Function which finds a School class instance by ID
    public School findById(Long aLong) {
        return schoolRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a School class instance to the system
    public School save(School object) {
        return schoolRepository.save(object);
    }

    @Override
    // Function which deletes a School class instance from the system
    public void delete(School object) {
        schoolRepository.delete(object);
    }

    @Override
    // Function which deletes a School class instance from the system by ID
    public void deleteById(Long aLong) {
        schoolRepository.deleteById(aLong);
    }

    @Override
    // Function which deletes all School class instances from the system by ID
    public void deleteAll() { schoolRepository.deleteAll();}

}
