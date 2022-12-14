package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    public Instructor findByMail(String mail);

}
