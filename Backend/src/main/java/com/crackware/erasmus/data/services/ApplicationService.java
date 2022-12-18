package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.repositories.ApplicationRepository;

import java.util.Optional;
import java.util.Set;
/**
 * Interface which acts as a service for Application class
 */
public interface ApplicationService extends CrudService<Application, Long> {
}
