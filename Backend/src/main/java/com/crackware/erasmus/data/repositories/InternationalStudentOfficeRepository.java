package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.InternationalStudentOffice;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for InternationalStudentOffice class
 */
public interface InternationalStudentOfficeRepository extends CrudRepository<InternationalStudentOffice, Long> {
    // Abstract function which finds an InternationalStudentOffice class instance by mail parameter
    public InternationalStudentOffice findByMail(String mail);


}