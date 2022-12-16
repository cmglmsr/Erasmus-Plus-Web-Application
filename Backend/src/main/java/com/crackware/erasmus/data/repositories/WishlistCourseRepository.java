package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.WishlistCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface WishlistCourseRepository extends CrudRepository<WishlistCourse, Long> {
}
