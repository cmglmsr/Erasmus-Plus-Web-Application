package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.Course;
import com.crackware.erasmus.data.repositories.CourseRepository;
import com.crackware.erasmus.data.services.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
/**
 *  Service class which handles Excel operations
 */
public class ExcelService {

    private final CourseService courseService;

    // Constructor which takes a CourseService parameter
    public ExcelService(CourseService courseService) {
        this.courseService = courseService;
    }

    // Function which saves an input file
    public void save(MultipartFile file) {
        try {
            List<Course> courses = ExcelHelper.excelToCourses(file.getInputStream());
            for (Course course : courses) {
                courseService.save(course);
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    // Function which returns all courses in List<Course>
    public List<Course> getAllCourses() {
        return new ArrayList<Course>((Collection<Course>) courseService.findAll());
    }
}