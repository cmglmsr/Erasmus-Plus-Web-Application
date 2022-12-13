package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.services.impl.CourseListServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8080")
public class CourseListController {
    private final CourseListServiceImpl courseListService;

    public CourseListController(CourseListServiceImpl courseListService) {
        this.courseListService = courseListService;
    }

    @PostMapping("/createCourseWishlist")
    public void createCourseList() {}
}
