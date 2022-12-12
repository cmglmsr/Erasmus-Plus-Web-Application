package com.crackware.erasmus.data.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import com.crackware.erasmus.data.model.Document;
import com.crackware.erasmus.data.repositories.DocumentRepository;
import com.crackware.erasmus.data.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document FileDB = new Document(fileName, file.getContentType(), file.getBytes());

        return documentRepository.save(FileDB);
    }

    public Document getFile(String id) {
        return documentRepository.findById(id).get();
    }

    public Stream<Document> getAllFiles() {
        return documentRepository.findAll().stream();
    }

    public void uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\Users\\cemg\\Desktop\\testuploads\\"+file.getOriginalFilename()));
    }
}
