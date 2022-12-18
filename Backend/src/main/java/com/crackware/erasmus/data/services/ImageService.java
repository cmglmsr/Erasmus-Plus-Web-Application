package com.crackware.erasmus.data.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
/**
 * Interface which acts as a service for image file operations
 */
public interface ImageService {
    // Function which saves an image file to the system
    void saveImageFile(MultipartFile file) throws IOException;
}
