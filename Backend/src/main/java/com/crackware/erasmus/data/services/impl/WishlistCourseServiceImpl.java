package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.WishlistCourse;
import com.crackware.erasmus.data.services.WishlistCourseService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
/**
 * Class which contains implementations of WishlistCourseService interface
 */
public class WishlistCourseServiceImpl implements WishlistCourseService {
    @Override
    // Function which finds all WishlistCourse instances by ID
    public Set<WishlistCourse> findAll() {
        return null;
    }

    @Override
    // Function which finds a WishlistCourse class instance by ID
    public WishlistCourse findById(Long aLong) {
        return null;
    }

    @Override
    // Function which saves a WishlistCourse class instance to the system
    public WishlistCourse save(WishlistCourse object) {
        return null;
    }

    @Override
    // Function which deletes a WishlistCourse class instance from the system
    public void delete(WishlistCourse object) {

    }

    @Override
    // Function which deletes a WishlistCourse class instance from the system by ID
    public void deleteById(Long aLong) {

    }
}
