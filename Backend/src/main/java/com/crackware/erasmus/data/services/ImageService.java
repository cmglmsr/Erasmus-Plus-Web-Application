package com.crackware.erasmus.data.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    void saveImageFile(MultipartFile file) throws IOException;
}
