package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.FacultyBoardMember;
import com.crackware.erasmus.data.repositories.FacultyBoardMemberRepository;
import com.crackware.erasmus.data.services.FacultyBoardMemberService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FacultyBoardMemberImpl implements FacultyBoardMemberService {

    private final FacultyBoardMemberRepository facultyBoardMemberRepository;

    public FacultyBoardMemberImpl(FacultyBoardMemberRepository facultyBoardMemberRepository) {
        this.facultyBoardMemberRepository = facultyBoardMemberRepository;
    }

    @Override
    public Set<FacultyBoardMember> findAll() {
        return null;
    }

    @Override
    public FacultyBoardMember findById(Long aLong) {
        return null;
    }

    @Override
    public FacultyBoardMember save(FacultyBoardMember object) {
        return null;
    }

    @Override
    public void delete(FacultyBoardMember object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
