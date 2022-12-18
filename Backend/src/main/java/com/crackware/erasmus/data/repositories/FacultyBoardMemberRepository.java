package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Document;
import com.crackware.erasmus.data.model.FacultyBoardMember;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for FacultyBoardMember class
 */
public interface FacultyBoardMemberRepository extends CrudRepository<FacultyBoardMember, Long> {
    // Abstract function which finds a FacultyBoardMember class instance by mail parameter
    public FacultyBoardMember findByMail(String mail);

}