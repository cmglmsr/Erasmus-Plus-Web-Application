package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Student;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for Student class
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
    // Abstract function which finds a Student class instance by mail parameter
    public Student findByMail(String mail);

}
