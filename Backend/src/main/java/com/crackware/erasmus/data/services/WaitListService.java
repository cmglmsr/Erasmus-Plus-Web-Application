package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.WaitList;
/**
 * Interface which acts as a service for WaitList class
 */
public interface WaitListService extends CrudService<WaitList, Long>{
    // Function which deletes all WaitList class instances from the system
    public void deleteAll();
}
