package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseApplication;
import com.crackware.erasmus.data.message.ResponseSchools;
import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.services.ApplicationService;
import com.crackware.erasmus.data.services.SchoolService;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.impl.ApplicationListServiceImpl;
import com.crackware.erasmus.data.services.impl.ApplicationServiceImpl;
import com.crackware.erasmus.data.services.impl.SchoolServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.*;

@RestController
@RequestMapping("student")
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
    public ResponseEntity<?> createApplication(@RequestBody HashMap<String, Object> payload) {
        Student student = (Student) helperService.getUser();
        System.out.println(student.getTerm());
        if(Double.parseDouble(student.getCgpa()) < 2.5 | student.getTerm() > 5 | student.getTerm() < 3) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Student ineligible for application!"); // 406
        }
        if(student.getApplication() != null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Student already has an application!");
        }
        Application application = new Application();
        application.setDate(new Date());
        application.setDepartment(student.getDepartment());
        // Can be sent as JSON
        /*
        * TO DO:
        * Get CV
        * Get Semester
        * */
        System.out.println(payload);
        application.setPoints(student.calculatePoints());
        application.setSchool1(schoolService.findById(Long.valueOf((String)payload.get("pref1"))));
        application.setSchool2(schoolService.findById(Long.valueOf((String)payload.get("pref2"))));
        application.setSchool3(schoolService.findById(Long.valueOf((String)payload.get("pref3"))));
        application.setSchool4(schoolService.findById(Long.valueOf((String)payload.get("pref4"))));
        application.setSchool5(schoolService.findById(Long.valueOf((String)payload.get("pref5"))));
        application.setStudent(student);
        student.setApplication(application);
        applicationService.save(application);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping("/getApplication")
    public ResponseEntity<ResponseApplication> getApplicationPage(){
        Student s = (Student) helperService.getUser();
        if(s.getApplication() == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseApplication(null, null, null, null, null));
        }
        Application a = s.getApplication();
        ResponseApplication r = new ResponseApplication(a);
       return ResponseEntity.status(HttpStatus.OK).body(r);
    }


    @GetMapping("/applications")
    public ResponseEntity<Set<ResponseApplication>> listApplications() {
        Set<Application> applications = applicationService.findAll();
        Set<ResponseApplication> responseApplications = new HashSet<>();
        for(Application a : applications) {
            ResponseApplication ra = new ResponseApplication(a);
            responseApplications.add(ra);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseApplications);
    }

    @PostMapping("/manageApplication")
    public ResponseEntity<ResponseApplication> manageApplication(@RequestBody HashMap<String, Object> payload) {
        Student s = (Student) helperService.getUser();
        if(s.getApplication() == null) {
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new ResponseApplication(null, null, null, null, null));
        }
        Application a = s.getApplication();
        for(String parameter : payload.keySet()) {
            if(parameter=="pref1") {
                a.setSchool1(schoolService.findById(Long.valueOf((int)payload.get("pref1"))));
            }
            if(parameter=="pref2") {
                a.setSchool2(schoolService.findById(Long.valueOf((int)payload.get("pref2"))));
            }
            if(parameter=="pref3") {
                a.setSchool3(schoolService.findById(Long.valueOf((int)payload.get("pref3"))));
            }
            if(parameter=="pref4") {
                a.setSchool4(schoolService.findById(Long.valueOf((int)payload.get("pref4"))));
            }
            if(parameter=="pref5") {
                a.setSchool5(schoolService.findById(Long.valueOf((int)payload.get("pref5"))));
            }
        }
        a.setStatus(Status.MANAGED);
        applicationService.save(a);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseApplication(a));
    }

}
