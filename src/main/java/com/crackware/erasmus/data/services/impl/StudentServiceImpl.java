package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.repositories.StudentRepository;
import com.crackware.erasmus.data.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
