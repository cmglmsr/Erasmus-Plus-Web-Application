package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ApplicationList;
import com.crackware.erasmus.data.model.WaitList;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for WaitList class
 */
public interface WaitListRepository extends CrudRepository<WaitList,Long> {
    // Abstract function which deletes all WaitList class instances
    @Override
    void deleteAll();
}
