package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.repositories.AdminRepository;
import com.crackware.erasmus.data.repositories.StudentRepository;
import com.crackware.erasmus.data.services.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"admin", "admin.html"})
public class AdminController {
    private final StudentService studentService;
    private final InstructorService instructorService;
    private final CoordinatorService coordinatorService;
    private final InternationalStudentOfficeService internationalStudentOfficeService;
    private final FacultyBoardMemberService facultyBoardMemberService;

    public AdminController(StudentService studentService, InstructorService instructorService,
                           CoordinatorService coordinatorService,
                           InternationalStudentOfficeService internationalStudentOfficeService,
                           FacultyBoardMemberService facultyBoardMemberService) {
        this.studentService = studentService;
        this.instructorService = instructorService;
        this.coordinatorService = coordinatorService;
        this.internationalStudentOfficeService = internationalStudentOfficeService;
        this.facultyBoardMemberService = facultyBoardMemberService;
    }

    





}
