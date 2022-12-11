package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Course;
import com.crackware.erasmus.data.repositories.CourseRepository;
import com.crackware.erasmus.data.services.CourseService;

import java.util.HashSet;
import java.util.Set;

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Set<Course> findAll() {
        HashSet<Course> courses = new HashSet<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    @Override
    public Course findById(Long aLong) {
        return courseRepository.findById(aLong).orElse(null);
    }

    @Override
    public Course save(Course object) {
        return courseRepository.save(object);
    }

    @Override
    public void delete(Course object) {
        courseRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        courseRepository.deleteById(aLong);
    }
}
