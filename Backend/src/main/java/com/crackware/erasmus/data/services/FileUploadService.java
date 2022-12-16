package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileUploadService {

    public Document store(MultipartFile file) throws IOException;

    public Document getFile(Long id);

    public Stream<Document> getAllFiles();

}
