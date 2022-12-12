package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.repositories.ApplicationRepository;
import com.crackware.erasmus.data.repositories.StudentRepository;
import com.crackware.erasmus.data.services.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        Student s = new Student();
        s.setName("cem");
        s.setMail("cemg@hotmail.com");
        s.setBilkentId("22003430");
        studentRepository.save(s);
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Set<Application> findAll() {
        HashSet<Application> applications = new HashSet<>();
        applicationRepository.findAll().forEach(applications::add);
        return applications;
    }

    @Override
    public Application findById(Long aLong) {
        return applicationRepository.findById(aLong).orElse(null);
    }

    @Override
    public Application save(Application object) {
        return applicationRepository.save(object);
    }

    @Override
    public void delete(Application object) {
        applicationRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        applicationRepository.deleteById(aLong);
    }
}
