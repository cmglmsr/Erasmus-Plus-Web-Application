package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseApplication;
import com.crackware.erasmus.data.message.ResponseSchools;
import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.services.ApplicationService;
import com.crackware.erasmus.data.services.SchoolService;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.impl.ApplicationListServiceImpl;
import com.crackware.erasmus.data.services.impl.ApplicationServiceImpl;
import com.crackware.erasmus.data.services.impl.SchoolServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("student/")
public class ApplicationsController {

    private final ApplicationService applicationService;
    private final HelperService helperService;
    private final SchoolService schoolService;

    public ApplicationsController(ApplicationListServiceImpl applicationListService, ApplicationServiceImpl applicationService, HelperService helperService, SchoolService schoolService) {
        this.applicationService = applicationService;
        this.helperService = helperService;
        this.schoolService = schoolService;
    }

    @PostMapping("/createApplication")
    public void createApplication(  @RequestParam(value = "pref1") Integer pref1,
                                    @RequestParam(value = "pref2") Integer pref2,
                                    @RequestParam(value = "pref3") Integer pref3,
                                    @RequestParam(value = "pref4") Integer pref4,
                                    @RequestParam(value = "pref5") Integer pref5) {
        Student student = (Student) helperService.getUser();
        Application application = new Application();
        application.setDate(new Date());
        application.setDepartment(student.getDepartment());
        // SEND AS FORM DATA
        /*
        * TO DO:
        * Create schools beforehand
        * Fetch them from database
        * GPA SHOULD BE MI 2.5
        * MIN SEMESTER 3, MAX SEMESTER 5
        * */
        application.setPoints(student.calculatePoints());
        application.setSchool1(schoolService.findById((long) pref1));
        application.setSchool2(schoolService.findById((long) pref2));
        application.setSchool3(schoolService.findById((long) pref3));
        application.setSchool4(schoolService.findById((long) pref4));
        application.setSchool5(schoolService.findById((long) pref5));
        application.setStudent(student);
        applicationService.save(application);
    }

    @GetMapping("/getApplication")
    public ResponseEntity<?> getApplicationPage(){
       return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseSchools(schoolService.findAll()));
    }


    @GetMapping("/applications")
    public ResponseEntity<Set<ResponseApplication>> listApplications() {
        Set<Application> applications = applicationService.findAll();
        Set<ResponseApplication> responseApplications = new HashSet<>();
        for(Application a : applications) {
            String name = a.getStudent().getName();
            String bilkendId = a.getStudent().getBilkentId();
            String cgpa = a.getStudent().getCgpa();
            String finalSchool = "";
            String status = "";
            if(a.getFinalSchool() != null) finalSchool = a.getFinalSchool().getName();
            if(a.getStatus() != null) status =  a.getStatus().toString();
            if(name == null) name = "";
            if(bilkendId == null) bilkendId = "";
            if(cgpa == null) cgpa = "";
            if(finalSchool == null) finalSchool = "";
            if(status == null) status = "";
            responseApplications.add(new ResponseApplication(name, bilkendId, cgpa, finalSchool, status));
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseApplications);
    }
}
