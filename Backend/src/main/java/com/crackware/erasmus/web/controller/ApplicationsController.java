package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseApplication;
import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.model.enums.School;
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
@CrossOrigin("http://localhost:8080")
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
        final HashSet<School> schools = new HashSet<>();
        final Student student = (Student) helperService.getUser();
        System.out.println(helperService.getUser());
        final Application application = new Application();
        student.setAddress(address);
        student.setPhoneNumber(phoneNumber);
        application.setAdmittedSchool(School.YOZGAT_BOZOK_UNI);
        application.setDate(new Date());
        application.setDepartment(student.getDepartment());
        application.setStatus(Status.APPROVED);
        application.setStudent(student);
        application.setSchools(schools);
        applicationService.save(application);
        System.out.println("[+] Created new application.");
    }

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
