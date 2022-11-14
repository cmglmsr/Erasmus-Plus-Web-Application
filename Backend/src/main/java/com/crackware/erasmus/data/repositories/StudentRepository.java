package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Language;
import com.crackware.erasmus.data.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
