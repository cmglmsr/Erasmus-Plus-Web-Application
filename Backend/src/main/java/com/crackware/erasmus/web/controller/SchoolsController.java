package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.services.helper.SchoolsHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("student/")
public class SchoolsController {
    private final SchoolsHelper sh;

    public SchoolsController(SchoolsHelper sh) {
        this.sh = sh;
    }

    @GetMapping("/getSchools")
    public ArrayList<School> getSchools() {
        return new ArrayList<>(sh.getSchools());
    }

    @GetMapping("/setSchools")
    public ResponseEntity<String> setSchools() {
        if(sh.setSchoolRepository()) {
            return ResponseEntity.status(HttpStatus.OK).body("Schools were set.");
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body("Schools were already initialized!");
        }
    }
}
