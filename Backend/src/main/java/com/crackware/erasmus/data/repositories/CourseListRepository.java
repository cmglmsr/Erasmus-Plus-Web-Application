package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.CourseList;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for CourseList class
 */
public interface CourseListRepository extends CrudRepository<CourseList,Long> {
}
