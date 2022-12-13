package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.InternationalStudentOffice;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.services.InternationalStudentOfficeService;
import com.crackware.erasmus.data.services.StudentService;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"iso", "/iso"})
public class InternationalStudentOfficeController {

    private final HelperService helperService;

    private final InternationalStudentOfficeService isoService;
    public InternationalStudentOfficeController(HelperService helperService, StudentService studentService, InternationalStudentOfficeService isoService) {
        this.helperService = helperService;
        this.isoService = isoService;
    }

    @GetMapping("/home")
    public InternationalStudentOffice coordinatorHome() {
        return (InternationalStudentOffice) helperService.getUser();
    }
    @GetMapping("/profile")
    public InternationalStudentOffice coordinatorProfile() {
        return (InternationalStudentOffice) helperService.getUser();
    }
}