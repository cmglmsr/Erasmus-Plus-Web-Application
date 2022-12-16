package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseApplication;
import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.model.PlacementList;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.services.ApplicationService;
import com.crackware.erasmus.data.services.helper.PlacementService;
import com.crackware.erasmus.data.services.impl.PlacementListServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "localhost://", maxAge = 3600)
@RestController
@RequestMapping({ "/coordinator/placements"})
public class PlacementListController {
    private final PlacementService placementService;
    private final PlacementListServiceImpl placementListService;

    public PlacementListController(PlacementService placementService, PlacementListServiceImpl placementListService) {
        this.placementService = placementService;
        this.placementListService = placementListService;
    }

    @GetMapping("/finalize")
    public void finalizePlacements() {
        placementService.finalizePlacements();
    }

    @GetMapping()
    public ResponseEntity<Set<ResponseApplication>> listPlacements() {
        ArrayList<PlacementList> placementLists = new ArrayList<>();
        placementLists.addAll(placementListService.findAll());
        PlacementList placementList = placementLists.get(0);
        Set<Application> applications = placementList.getApplications();
        Set<ResponseApplication> responseApplications = new HashSet<>();
        for(Application a : applications) {
            responseApplications.add(new ResponseApplication(a));
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseApplications);
    }
}
