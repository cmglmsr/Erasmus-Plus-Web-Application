package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ApplicationList;
import com.crackware.erasmus.data.model.Course;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for Course class
 */
public interface CourseRepository extends CrudRepository<Course,Long> {
}
