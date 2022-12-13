package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.InternationalStudentOffice;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.services.InternationalStudentOfficeService;
import com.crackware.erasmus.data.services.StudentService;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"iso", "/iso"})
public class InternationalStudentOfficeController {

    private final HelperService helperService;

    private final InternationalStudentOfficeService isoService;
    public InternationalStudentOfficeController(HelperService helperService, StudentService studentService, InternationalStudentOfficeService isoService) {
        this.helperService = helperService;
        this.isoService = isoService;
    }

    @GetMapping("/home")
    public InternationalStudentOffice internationalStudentOfficeHome() {
        return (InternationalStudentOffice) helperService.getUser();
    }
    @GetMapping("/profile")
    public InternationalStudentOffice internationalStudentOfficeProfile() {
        return (InternationalStudentOffice) helperService.getUser();
    }

    @RestController
    @CrossOrigin("http://localhost:8080") // Change cross-origin when hosted
    public class FileUploadController {
        private final FileUploadServiceImpl fileUploadService;
    @PostMapping("/home")
    public void uploadFile(@RequestParam("transcript") MultipartFile file) throws IOException {
        try {
            fileUploadService.store(file);
            System.out.println("[+] Transcript upload successful.");
        } catch (IOException e) {
            System.out.println("[-] Transcript upload failed.");
        }
    }
}