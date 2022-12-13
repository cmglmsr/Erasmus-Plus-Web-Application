package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Admin;
import com.crackware.erasmus.data.model.Coordinator;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final HelperService helperService;

    public AdminController(StudentService studentService, InstructorService instructorService,
                           CoordinatorService coordinatorService,
                           InternationalStudentOfficeService internationalStudentOfficeService,
                           FacultyBoardMemberService facultyBoardMemberService, HelperService helperService) {
        this.studentService = studentService;
        this.instructorService = instructorService;
        this.coordinatorService = coordinatorService;
        this.internationalStudentOfficeService = internationalStudentOfficeService;
        this.facultyBoardMemberService = facultyBoardMemberService;
        this.helperService = helperService;
    }

    @GetMapping("/home")
    public Admin adminHome() {
        return (Admin) helperService.getUser();
    }
    @GetMapping("/profile")
    public Admin adminProfile() {
        return (Admin) helperService.getUser();
    }





}
