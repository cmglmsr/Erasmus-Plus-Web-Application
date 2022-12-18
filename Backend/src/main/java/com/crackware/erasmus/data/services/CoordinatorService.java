package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.Coordinator;
/**
 * Interface which acts as a service for Coordinator class
 */
public interface CoordinatorService extends CrudService<Coordinator, Long>, EmailService{
}
