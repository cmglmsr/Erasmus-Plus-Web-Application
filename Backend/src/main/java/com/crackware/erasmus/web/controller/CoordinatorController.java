package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Coordinator;
import com.crackware.erasmus.data.services.CoordinatorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/coordinator", "coordinator"})
public class CoordinatorController {

    CoordinatorService coordinatorService;

    @GetMapping()
    public String processUpdateOwnerForm(Model model) {
        model.addAttribute(coordinatorService.findById(1L));
       return "index.html";
    }

}
