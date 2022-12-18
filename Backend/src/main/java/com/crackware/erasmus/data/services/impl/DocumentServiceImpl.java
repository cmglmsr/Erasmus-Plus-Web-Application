package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Document;
import com.crackware.erasmus.data.repositories.DocumentRepository;
import com.crackware.erasmus.data.services.DocumentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of DocumentService interface
 */
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    // Constructor for DocumentServiceImpl class
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    // Function which finds all Document instances by ID
    public Set<Document> findAll() {
        HashSet<Document> documents = new HashSet<>();
        documentRepository.findAll().forEach(documents::add);
        return documents;
    }

    @Override
    // Function which finds a Document class instance by ID
    public Document findById(Long aLong) {
        return documentRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a Document class instance to the system
    public Document save(Document object) {
        return documentRepository.save(object);
    }

    @Override
    // Function which deletes a Document class instance from the system
    public void delete(Document object) {
        documentRepository.delete(object);
    }

    @Override
    // Function which deletes a Document class instance from the system by ID
    public void deleteById(Long aLong) {
        documentRepository.deleteById(aLong);
    }
}
