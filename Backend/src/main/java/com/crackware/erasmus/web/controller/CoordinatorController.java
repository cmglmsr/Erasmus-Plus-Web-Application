package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Coordinator;
import com.crackware.erasmus.data.model.Document;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.services.CoordinatorService;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.impl.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping({"/coordinator", "coordinator"})
public class CoordinatorController {

    private final CoordinatorService coordinatorService;
    //private final DocumentServiceImpl documentServiceSave;
    private final HelperService helperService;

    public CoordinatorController(CoordinatorService coordinatorService, HelperService helperService) {
        this.coordinatorService = coordinatorService;
        //this.documentServiceSave = documentServiceSave;
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

    @PostMapping("/home")

    public void approveLearningAgreement(@RequestParam("learningAgreement") MultipartFile learningAgreementFile) throws IOException {
        String name = learningAgreementFile.getName();
        String type = learningAgreementFile.getContentType();
        Status documentStatus = Status.APPROVED;
        byte[] dataSize = learningAgreementFile.getBytes();
        Document learningAgreementDocument = new Document(name, type, dataSize, documentStatus);

        // Save the document
        //documentServiceSave.save(learningAgreementDocument);
        // Print out an approved message
        System.out.println("[+] Learning agreement file approved.");
    }

    public void rejectLearningAgreement(@RequestParam("learningAgreement") MultipartFile learningAgreementFile) throws IOException {
        String name = learningAgreementFile.getName();
        String type = learningAgreementFile.getContentType();
        Status documentStatus = Status.DENIED;
        byte[] dataSize = learningAgreementFile.getBytes();
        Document learningAgreementDocument = new Document(name, type, dataSize, documentStatus);

        // Save the document
        //documentServiceSave.save(learningAgreementDocument);
        // Print out an approved message
        System.out.println("[-] Learning agreement file rejected.");
    }

}

