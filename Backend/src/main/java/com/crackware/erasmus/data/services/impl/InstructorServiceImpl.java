package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.BaseEntity;
import com.crackware.erasmus.data.model.Instructor;
import com.crackware.erasmus.data.repositories.InstructorRepository;
import com.crackware.erasmus.data.services.InstructorService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of InstructorService interface
 */
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    // Constructor for InstructorServiceImpl class
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    // Function which finds all Instructor instances by ID
    public Set<Instructor> findAll() {
        HashSet<Instructor> instructors = new HashSet<>();
        instructorRepository.findAll().forEach(instructors::add);
        return instructors;
    }

    @Override
    // Function which finds an Instructor class instance by ID
    public Instructor findById(Long aLong) {
        return instructorRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves an Instructor class instance to the system
    public Instructor save(Instructor object) {
        return instructorRepository.save(object);
    }

    @Override
    // Function which deletes an Instructor class instance from the system
    public void delete(Instructor object) {
        instructorRepository.delete(object);
    }

    @Override
    // Function which deletes an Instructor class instance from the system by ID
    public void deleteById(Long aLong) {
        instructorRepository.deleteById(aLong);
    }

    @Override
    // Function which finds an Instructor class instance by email
    public BaseEntity findByEmail(String email) {
        return instructorRepository.findByMail(email);
    }
}
