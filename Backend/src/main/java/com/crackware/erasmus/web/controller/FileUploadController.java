package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseFile;
import com.crackware.erasmus.data.model.Document;
import com.crackware.erasmus.data.services.impl.FileUploadServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:8080")
public class FileUploadController {
    @Autowired
    FileUploadServiceImpl fileUploadService;

    @PostMapping("fileupload")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            fileUploadService.store(file);
            System.out.println("[+] File upload successful.");
        } catch (IOException e) {
            System.out.println("[-] File upload failed.");
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = fileUploadService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId().toString())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    dbFile.getType(),
                    fileDownloadUri,
                    dbFile.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Document doc = fileUploadService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + doc.getName() + "\"")
                .body(doc.getData());
    }
}
