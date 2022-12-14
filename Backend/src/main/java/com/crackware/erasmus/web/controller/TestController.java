package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.services.helper.ExcelHelper;
import com.crackware.erasmus.data.services.helper.ExcelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequestMapping("/student/excel")
public class TestController {


    private final ExcelService fileService;


    public TestController(ExcelService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            if (ExcelHelper.hasExcelFormat(file)){
                fileService.save(file);
                System.out.println("[+] File upload successful.");
            }
        }catch (Exception e){
            System.out.println("[-] File upload error.");
            System.out.println(e.getMessage());
        }

    }

}
