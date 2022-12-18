package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ApplicationList;
import com.crackware.erasmus.data.model.StudentList;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for StudentList class
 */
public interface StudentListRepository extends CrudRepository<StudentList,Long> {
}
