package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Document;
import com.crackware.erasmus.data.repositories.DocumentRepository;
import com.crackware.erasmus.data.services.DocumentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of AdminService interface
 */
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    // Constructor for AdminServiceImpl class
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Set<Document> findAll() {
        HashSet<Document> documents = new HashSet<>();
        documentRepository.findAll().forEach(documents::add);
        return documents;
    }

    @Override
    public Document findById(Long aLong) {
        return documentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Document save(Document object) {
        return documentRepository.save(object);
    }

    @Override
    public void delete(Document object) {
        documentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        documentRepository.deleteById(aLong);
    }
}
