package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.services.StudentService;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "localhost://", maxAge = 3600)
@RestController
@RequestMapping( "/student")
public class StudentController {

    private final HelperService helperService;

    private final StudentService studentService;
    public StudentController(HelperService helperService, StudentService studentService) {
        this.helperService = helperService;
        this.studentService = studentService;
    }
    @GetMapping("/home")
    public Student studentHome() {
        return (Student) helperService.getUser();
    }
    @GetMapping("/profile")
    public Student studentProfile() {
        return (Student) helperService.getUser();
    }
}

