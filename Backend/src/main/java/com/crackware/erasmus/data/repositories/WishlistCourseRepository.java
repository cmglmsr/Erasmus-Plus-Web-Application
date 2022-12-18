package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.WishlistCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface which acts as a repository for WishlistCourse class
 */
public interface WishlistCourseRepository extends CrudRepository<WishlistCourse, Long> {
}
