package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Coordinator;
import com.crackware.erasmus.data.model.FacultyBoardMember;
import com.crackware.erasmus.data.services.FacultyBoardMemberService;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"fbm", "/fbm"})
public class FacultyBoardMemberController {

    private final HelperService helperService;

    private final FacultyBoardMemberService facultyBoardMemberService;
    public FacultyBoardMemberController(HelperService helperService, FacultyBoardMemberService facultyBoardMemberService) {
        this.helperService = helperService;
        this.facultyBoardMemberService = facultyBoardMemberService;
    }

    @GetMapping("/home")
    public FacultyBoardMember facultyBoardMemberHome() {
        return (FacultyBoardMember) helperService.getUser();
    }
    @GetMapping("/profile")
    public FacultyBoardMember facultyBoardMemberProfile() {
        return (FacultyBoardMember) helperService.getUser();
    }
}