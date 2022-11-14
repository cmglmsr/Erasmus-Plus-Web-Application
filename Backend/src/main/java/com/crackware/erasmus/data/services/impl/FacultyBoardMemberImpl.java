package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.repositories.FacultyBoardMemberRepository;
import com.crackware.erasmus.data.services.FacultyBoardMemberService;
import org.springframework.stereotype.Service;

@Service
public class FacultyBoardMemberImpl implements FacultyBoardMemberService {

    private final FacultyBoardMemberRepository facultyBoardMemberRepository;

    public FacultyBoardMemberServiceImpl(FacultyBoardMemberRepository facultyBoardMemberRepository) {
        this.facultyBoardMemberRepository = facultyBoardMemberRepository;
    }
}
