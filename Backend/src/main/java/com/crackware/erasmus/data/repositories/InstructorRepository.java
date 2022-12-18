package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Instructor;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for Instructor class
 */
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    // Abstract function which finds an Instructor class instance by mail parameter
    public Instructor findByMail(String mail);

}
