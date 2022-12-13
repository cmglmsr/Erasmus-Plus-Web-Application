package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Instructor;
import com.crackware.erasmus.data.services.InstructorService;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({"instructor", "/instructor"})
public class InstructorController {

    private final HelperService helperService;

    private final InstructorService instructorService;

    public InstructorController(HelperService helperService, InstructorService instructorService) {
        this.helperService = helperService;
        this.instructorService = instructorService;
    }

    @GetMapping("/home")
    public Instructor instructorHome() {
        return (Instructor) helperService.getUser();
    }
    @GetMapping("/profile")
    public Instructor instructorProfile() {
        return (Instructor) helperService.getUser();
    }
}
