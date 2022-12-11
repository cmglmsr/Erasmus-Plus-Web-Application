package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.services.ApplicationService;
import com.crackware.erasmus.data.services.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private final ApplicationService applicationService;
    private final StudentService studentService;
    public StudentController(ApplicationService applicationService, StudentService studentService) {
        this.applicationService = applicationService;
        this.studentService = studentService;
    }

    @GetMapping ("student/home")
    public Student viewApplication(@RequestBody Student student) {

        ObjectMapper objectMapper = new ObjectMapper();


        return studentService.findById(student.getId());
    }

    @PostMapping("/application/new")
    public void createApplication(Student student, @RequestBody Application application) {
        if (student.getApplication() == null){
            student.setApplication(application);
        }
    }
}
