package com.crackware.erasmus.data.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import com.crackware.erasmus.data.model.Document;
import com.crackware.erasmus.data.repositories.DocumentRepository;
import com.crackware.erasmus.data.services.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final DocumentRepository documentRepository;

    public FileUploadServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document FileDB = new Document(fileName, file.getContentType(), file.getBytes());

        return documentRepository.save(FileDB);
    }

    public Document getFile(Long id) {
        return documentRepository.findById(id).get();
    }

    public Stream<Document> getAllFiles() {
        return (Stream<Document>) documentRepository.findAll();
    }

    public void uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\Users\\cemg\\Desktop\\testuploads\\"+file.getOriginalFilename()));
    }
}
