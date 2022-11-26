package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
