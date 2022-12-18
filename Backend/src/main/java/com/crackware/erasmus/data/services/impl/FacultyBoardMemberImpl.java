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
 * Class which contains implementations of FacultyBoardMemberService interface
 */
public class FacultyBoardMemberImpl implements FacultyBoardMemberService {

    private final FacultyBoardMemberRepository facultyBoardMemberRepository;
    // Constructor for FacultyBoardMemberImpl class
    public FacultyBoardMemberImpl(FacultyBoardMemberRepository facultyBoardMemberRepository) {
        this.facultyBoardMemberRepository = facultyBoardMemberRepository;
    }

    @Override
    // Function which finds all CourseList instances by ID
    public Set<FacultyBoardMember> findAll() {
        HashSet<FacultyBoardMember> facultyBoardMembers = new HashSet<>();
        facultyBoardMemberRepository.findAll().forEach(facultyBoardMembers::add);
        return facultyBoardMembers;
    }

    @Override
    // Function which finds a FacultyBoardMember class instance by ID
    public FacultyBoardMember findById(Long aLong) {
        return facultyBoardMemberRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a FacultyBoardMember class instance to the system
    public FacultyBoardMember save(FacultyBoardMember object) {
        return facultyBoardMemberRepository.save(object);
    }

    @Override
    // Function which deletes a FacultyBoardMember class instance from the system
    public void delete(FacultyBoardMember object) {
        facultyBoardMemberRepository.delete(object);
    }

    @Override
    // Function which deletes a FacultyBoardMember class instance from the system by ID
    public void deleteById(Long aLong) {
        facultyBoardMemberRepository.deleteById(aLong);
    }

    @Override
    // Function which finds a FacultyBoardMember class instance by email
    public BaseEntity findByEmail(String email) {
        return facultyBoardMemberRepository.findByMail(email);
    }
}
