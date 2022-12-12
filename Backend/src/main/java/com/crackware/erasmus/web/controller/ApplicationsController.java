package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseApplication;
import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.services.impl.ApplicationListServiceImpl;
import com.crackware.erasmus.data.services.impl.ApplicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:8080")
public class ApplicationsController {

    private final ApplicationListServiceImpl applicationListService;
    private final ApplicationServiceImpl applicationService;

    public ApplicationsController(ApplicationListServiceImpl applicationListService, ApplicationServiceImpl applicationService) {
        this.applicationListService = applicationListService;
        this.applicationService = applicationService;
    }

    @PostMapping("/createApplication")
    public String createApplication() {}

    @GetMapping("/applications")
    public ResponseEntity<Set<ResponseApplication>> listApplications() {
        Set<Application> applications = applicationService.findAll();
        Set<ResponseApplication> responseApplications = new HashSet<>();
        for(Application a : applications) {
            responseApplications.add(new ResponseApplication(a.getStudent().getName(), a.getStudent().getBilkentId(), a.getStudent().getCgpa(), a.getAdmittedSchool().toString(), a.getStatus().toString()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseApplications);
    }
}
