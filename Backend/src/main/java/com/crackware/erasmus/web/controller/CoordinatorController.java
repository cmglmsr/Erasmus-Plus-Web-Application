package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Coordinator;
import com.crackware.erasmus.data.services.CoordinatorService;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/coordinator", "coordinator"})
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    private final HelperService helperService;

    public CoordinatorController(CoordinatorService coordinatorService, HelperService helperService) {
        this.coordinatorService = coordinatorService;
        this.helperService = helperService;
    }

    @GetMapping("/home")
    public Coordinator coordinatorHome() {
       return (Coordinator) helperService.getUser();
    }
    @GetMapping("/profile")
    public Coordinator coordinatorProfile() {
        return (Coordinator) helperService.getUser();
    }

}
