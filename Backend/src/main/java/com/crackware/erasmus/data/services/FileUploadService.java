package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;
/**
 * Interface which acts as a service for file upload operations
 */
public interface FileUploadService {

    // Function which stores a file
    public Document store(MultipartFile file) throws IOException;

    // Function which gets a file by id
    public Document getFile(Long id);

    // Function which gets all files
    public Stream<Document> getAllFiles();

}
