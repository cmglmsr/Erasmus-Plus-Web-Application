package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.repositories.SchoolRepository;
import com.crackware.erasmus.data.services.SchoolService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public Set<School> findAll() {
        HashSet<School> schools = new HashSet<>();
        schoolRepository.findAll().forEach(schools::add);
        return schools;
    }

    @Override
    public School findById(Long aLong) {
        return schoolRepository.findById(aLong).orElse(null);
    }

    @Override
    public School save(School object) {
        return schoolRepository.save(object);
    }

    @Override
    public void delete(School object) {
        schoolRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        schoolRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() { schoolRepository.deleteAll();}

}
