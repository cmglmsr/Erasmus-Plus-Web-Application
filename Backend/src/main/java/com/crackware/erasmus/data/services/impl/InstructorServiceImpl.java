package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Instructor;
import com.crackware.erasmus.data.repositories.InstructorRepository;
import com.crackware.erasmus.data.services.InstructorService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public Set<Instructor> findAll() {
        HashSet<Instructor> instructors = new HashSet<>();
        instructorRepository.findAll().forEach(instructors::add);
        return instructors;
    }

    @Override
    public Instructor findById(Long aLong) {
        return instructorRepository.findById(aLong).orElse(null);
    }

    @Override
    public Instructor save(Instructor object) {
        return instructorRepository.save(object);
    }

    @Override
    public void delete(Instructor object) {
        instructorRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        instructorRepository.deleteById(aLong);
    }
}
