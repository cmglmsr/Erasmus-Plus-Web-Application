package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.BaseEntity;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.repositories.StudentRepository;
import com.crackware.erasmus.data.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of StudentService interface
 */
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // Constructor for StudentServiceImpl class
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    // Function which finds all Student instances by ID
    public Set<Student> findAll() {
        HashSet<Student> students = new HashSet<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    // Function which finds a Student class instance by ID
    public Student findById(Long aLong) {
        return studentRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a Student class instance to the system
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    // Function which deletes a Student class instance from the system
    public void delete(Student object) {
        studentRepository.delete(object);
    }

    @Override
    // Function which deletes a Student class instance from the system by ID
    public void deleteById(Long aLong) {
        studentRepository.deleteById(aLong);
    }

    @Override
    // Function which finds a Student class instance by email
    public BaseEntity findByEmail(String email) {
        return studentRepository.findByMail(email);
    }
}
