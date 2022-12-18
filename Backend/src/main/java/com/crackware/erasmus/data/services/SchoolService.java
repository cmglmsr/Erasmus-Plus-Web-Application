package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.School;
/**
 * Interface which acts as a service for School class
 */
public interface SchoolService extends CrudService<School, Long>{
    public void deleteAll();
}
