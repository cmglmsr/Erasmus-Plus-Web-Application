package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.BaseEntity;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.repositories.StudentRepository;
import com.crackware.erasmus.data.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<Student> findAll() {
        HashSet<Student> students = new HashSet<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Student findById(Long aLong) {
        return studentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void delete(Student object) {
        studentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        studentRepository.deleteById(aLong);
    }

    @Override
    public BaseEntity findByEmail(String email) {
        System.out.println("AAAAAA" + studentRepository.findByMail(email).getRole().getName());
        return studentRepository.findByMail(email);
    }
}
