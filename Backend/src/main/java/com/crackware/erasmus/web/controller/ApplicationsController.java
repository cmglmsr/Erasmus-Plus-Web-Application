package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseApplication;
import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.impl.ApplicationListServiceImpl;
import com.crackware.erasmus.data.services.impl.ApplicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
public class ApplicationsController {

    private final ApplicationListServiceImpl applicationListService;
    private final ApplicationServiceImpl applicationService;
    private final HelperService helperService;

    public ApplicationsController(ApplicationListServiceImpl applicationListService, ApplicationServiceImpl applicationService, HelperService helperService) {
        this.applicationListService = applicationListService;
        this.applicationService = applicationService;
        this.helperService = helperService;
    }

    @PostMapping("/createApplication")
    public void createApplication(@RequestParam("email") String email,
                                    @RequestParam("address") String address,
                                    @RequestParam("phone_number") String phoneNumber,
                                    @RequestParam("pref1") String pref1,
                                    @RequestParam("pref2") String pref2,
                                    @RequestParam("pref3") String pref3,
                                    @RequestParam("pref4") String pref4,
                                    @RequestParam("pref5") String pref5) {

    }

    @GetMapping("/applications")
    public ResponseEntity<Set<ResponseApplication>> listApplications() {

        return ResponseEntity.status(HttpStatus.OK).header("a","b").build();
    }
}
