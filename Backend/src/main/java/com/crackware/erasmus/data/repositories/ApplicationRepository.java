package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Application;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for Application class
 */
public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
