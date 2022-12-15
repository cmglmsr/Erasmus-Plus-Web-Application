package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.services.helper.SchoolsHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;

@RestController
@RequestMapping("student/")
public class SchoolsController {
    private final SchoolsHelper sh;

    public SchoolsController(SchoolsHelper sh) {
        this.sh = sh;
    }

    @GetMapping("/getSchools")
    public ArrayList<School> getSchools() {
        return sh.getSchools();
    }

    @GetMapping("/setSchools")
    public void test() {
        sh.setSchoolRepository();
    }
}
