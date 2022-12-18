package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Admin;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping({"admin", "admin.html"})
/**
 * Controller class for Admin class
 */
public class AdminController {
    private final StudentService studentService;
    private final InstructorService instructorService;
    private final CoordinatorService coordinatorService;
    private final InternationalStudentOfficeService internationalStudentOfficeService;
    private final FacultyBoardMemberService facultyBoardMemberService;

    private final ImageService imageService;
    private final HelperService helperService;

    // Constructor for AdminController class
    public AdminController(StudentService studentService, InstructorService instructorService,
                           CoordinatorService coordinatorService,
                           InternationalStudentOfficeService internationalStudentOfficeService,
                           FacultyBoardMemberService facultyBoardMemberService, ImageService imageService, HelperService helperService) {
        this.studentService = studentService;
        this.instructorService = instructorService;
        this.coordinatorService = coordinatorService;
        this.internationalStudentOfficeService = internationalStudentOfficeService;
        this.facultyBoardMemberService = facultyBoardMemberService;
        this.imageService = imageService;
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

    @PostMapping("/profile/edit")
    public void editProfile(@RequestParam("profilePic") MultipartFile profilePic) throws IOException {
        imageService.saveImageFile(profilePic);
    }




}
