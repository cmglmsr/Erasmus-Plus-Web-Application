package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.BaseEntity;
import com.crackware.erasmus.data.model.FacultyBoardMember;
import com.crackware.erasmus.data.repositories.FacultyBoardMemberRepository;
import com.crackware.erasmus.data.services.FacultyBoardMemberService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of AdminService interface
 */
public class FacultyBoardMemberImpl implements FacultyBoardMemberService {

    private final FacultyBoardMemberRepository facultyBoardMemberRepository;
    // Constructor for AdminServiceImpl class
    public FacultyBoardMemberImpl(FacultyBoardMemberRepository facultyBoardMemberRepository) {
        this.facultyBoardMemberRepository = facultyBoardMemberRepository;
    }

    @Override
    public Set<FacultyBoardMember> findAll() {
        HashSet<FacultyBoardMember> facultyBoardMembers = new HashSet<>();
        facultyBoardMemberRepository.findAll().forEach(facultyBoardMembers::add);
        return facultyBoardMembers;
    }

    @Override
    public FacultyBoardMember findById(Long aLong) {
        return facultyBoardMemberRepository.findById(aLong).orElse(null);
    }

    @Override
    public FacultyBoardMember save(FacultyBoardMember object) {
        return facultyBoardMemberRepository.save(object);
    }

    @Override
    public void delete(FacultyBoardMember object) {
        facultyBoardMemberRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        facultyBoardMemberRepository.deleteById(aLong);
    }

    @Override
    public BaseEntity findByEmail(String email) {
        return facultyBoardMemberRepository.findByMail(email);
    }
}
