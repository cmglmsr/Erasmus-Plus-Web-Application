package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Document;
import com.crackware.erasmus.data.model.FacultyBoardMember;
import org.springframework.data.repository.CrudRepository;

public interface FacultyBoardMemberRepository extends CrudRepository<FacultyBoardMember, Long> {
    public FacultyBoardMember findByMail(String mail);

}