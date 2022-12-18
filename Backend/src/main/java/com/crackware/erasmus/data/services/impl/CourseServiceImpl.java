package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Course;
import com.crackware.erasmus.data.repositories.CourseRepository;
import com.crackware.erasmus.data.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of CourseService interface
 */
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    // Constructor for CourseServiceImpl class
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    // Function which finds all Course instances by ID
    public Set<Course> findAll() {
        HashSet<Course> courses = new HashSet<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    @Override
    // Function which finds a Course class instance by ID
    public Course findById(Long aLong) {
        return courseRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a Course class instance to the system
    public Course save(Course object) {
        return courseRepository.save(object);
    }

    @Override
    // Function which deletes a Course class instance from the system
    public void delete(Course object) {
        courseRepository.delete(object);
    }

    @Override
    // Function which deletes a Course class instance from the system by ID
    public void deleteById(Long aLong) {
        courseRepository.deleteById(aLong);
    }
}
