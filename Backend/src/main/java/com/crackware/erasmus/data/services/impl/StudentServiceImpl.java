package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.repositories.StudentRepository;
import com.crackware.erasmus.data.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(Long aLong) {
        return null;
    }

    @Override
    public Student save(Student object) {
        return null;
    }

    @Override
    public void delete(Student object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
