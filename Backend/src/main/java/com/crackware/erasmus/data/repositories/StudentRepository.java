package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    public Student findByMail(String mail);

}
