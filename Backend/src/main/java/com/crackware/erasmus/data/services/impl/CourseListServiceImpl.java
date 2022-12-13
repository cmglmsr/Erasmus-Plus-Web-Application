package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.CourseList;
import com.crackware.erasmus.data.repositories.CourseListRepository;
import com.crackware.erasmus.data.services.CourseListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CourseListServiceImpl implements CourseListService {

    private final CourseListRepository courseListRepository;

    public CourseListServiceImpl(CourseListRepository courseListRepository) {
        this.courseListRepository = courseListRepository;
    }

    @Override
    public Set<CourseList> findAll() {
        HashSet<CourseList> courseLists = new HashSet<>();
        courseListRepository.findAll().forEach(courseLists::add);
        return courseLists;
    }

    @Override
    public CourseList findById(Long aLong) {
        return courseListRepository.findById(aLong).orElse(null);
    }

    @Override
    public CourseList save(CourseList object) {
        return courseListRepository.save(object);
    }

    @Override
    public void delete(CourseList object) {
        courseListRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        courseListRepository.deleteById(aLong);
    }
}
