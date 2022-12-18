package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Coordinator;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for Coordinator class
 */
public interface CoordinatorRepository extends CrudRepository<Coordinator, Long> {
    // Abstract function which finds a Coordinator class instance by mail parameter
    public Coordinator findByMail(String mail);

}
