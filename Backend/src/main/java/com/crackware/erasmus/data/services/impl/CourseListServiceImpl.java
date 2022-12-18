package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.CourseList;
import com.crackware.erasmus.data.repositories.CourseListRepository;
import com.crackware.erasmus.data.services.CourseListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of CourseListService interface
 */
public class CourseListServiceImpl implements CourseListService {

    private final CourseListRepository courseListRepository;
    // Constructor for CourseListServiceImpl class
    public CourseListServiceImpl(CourseListRepository courseListRepository) {
        this.courseListRepository = courseListRepository;
    }

    @Override
    // Function which finds all CourseList instances by ID
    public Set<CourseList> findAll() {
        HashSet<CourseList> courseLists = new HashSet<>();
        courseListRepository.findAll().forEach(courseLists::add);
        return courseLists;
    }

    @Override
    // Function which finds a CourseList class instance by ID
    public CourseList findById(Long aLong) {
        return courseListRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a CourseList class instance to the system
    public CourseList save(CourseList object) {
        return courseListRepository.save(object);
    }

    @Override
    // Function which deletes a CourseList class instance from the system
    public void delete(CourseList object) {
        courseListRepository.delete(object);
    }

    @Override
    // Function which deletes a CourseList class instance from the system by ID
    public void deleteById(Long aLong) {
        courseListRepository.deleteById(aLong);
    }
}
