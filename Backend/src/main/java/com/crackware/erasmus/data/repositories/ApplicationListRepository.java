package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ApplicationList;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for ApplicationList class
 */
public interface ApplicationListRepository extends CrudRepository<ApplicationList ,Long> {
}
