package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.School;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for School class
 */
public interface SchoolRepository extends CrudRepository<School, Long> {
    @Override
    void deleteAll();
}
