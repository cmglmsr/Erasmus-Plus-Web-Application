package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Interface which acts as a repository for Document class
 */
public interface DocumentRepository extends CrudRepository<Document, Long> {
}
