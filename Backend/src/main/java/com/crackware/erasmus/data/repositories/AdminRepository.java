package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Admin;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for Admin class
 */
public interface AdminRepository extends CrudRepository<Admin, Long> {
    // Abstract function which finds an Admin class instance by mail parameter
    public Admin findByMail(String mail);
}
