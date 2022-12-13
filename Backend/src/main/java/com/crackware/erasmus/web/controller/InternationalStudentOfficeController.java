package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.InternationalStudentOffice;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.services.InternationalStudentOfficeService;
import com.crackware.erasmus.data.services.StudentService;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.impl.FileUploadServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping({"iso", "/iso"})
public class InternationalStudentOfficeController {

    private final HelperService helperService;
    private final FileUploadServiceImpl fileUploadService;

    private final InternationalStudentOfficeService isoService;
    public InternationalStudentOfficeController(HelperService helperService, StudentService studentService,
                                                InternationalStudentOfficeService isoService, FileUploadServiceImpl fileUploadService) {
        this.helperService = helperService;
        this.isoService = isoService;
        this.fileUploadService = fileUploadService;
    }

    @GetMapping("/home")
    public InternationalStudentOffice internationalStudentOfficeHome() {
        return (InternationalStudentOffice) helperService.getUser();
    }
    @GetMapping("/profile")
    public InternationalStudentOffice internationalStudentOfficeProfile() {
        return (InternationalStudentOffice) helperService.getUser();
    }

    @PostMapping("/home")
    public void uploadFile(@RequestParam("transcript") MultipartFile transcript) throws IOException {
        try {
            fileUploadService.store(transcript);
            System.out.println("[+] Transcript upload successful.");
        } catch (IOException e) {
            System.out.println("[-] Transcript upload failed.");
        }
    }
}