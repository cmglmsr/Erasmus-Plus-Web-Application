package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.BaseEntity;
import com.crackware.erasmus.data.model.security.EnumRole;
import com.crackware.erasmus.data.model.security.Role;
import com.crackware.erasmus.data.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HelperService {

    private final AdminService adminService;

    private final StudentService studentService;

    private final CoordinatorService coordinatorService;

    private final InstructorService instructorService;

    private final InternationalStudentOfficeService isoService;

    private final FacultyBoardMemberService facultyBoardMemberService;

    public HelperService(AdminService adminService, StudentService studentService,
                         CoordinatorService coordinatorService, InstructorService instructorService,
                         InternationalStudentOfficeService isoService,
                         FacultyBoardMemberService facultyBoardMemberService) {
        this.adminService = adminService;
        this.studentService = studentService;
        this.coordinatorService = coordinatorService;
        this.instructorService = instructorService;
        this.isoService = isoService;
        this.facultyBoardMemberService = facultyBoardMemberService;
    }

    public BaseEntity getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getAuthorities());
        ArrayList<GrantedAuthority> authorities = new ArrayList<>(authentication.getAuthorities());
        if (authorities.size() == 0)
            return null;

        Role currentRole = new Role();
        currentRole.setName(EnumRole.valueOf(authorities.get(0).getAuthority()));
        if (authorities.get(0) == null)
            return null;
        String mail = authentication.getName();
        switch (currentRole.getName()){
            case ROLE_ADMIN: return adminService.findByEmail(mail);
            case ROLE_ISO: return isoService.findByEmail(mail);
            case ROLE_STUDENT: return studentService.findByEmail(mail);
            case ROLE_INSTRUCTOR: return instructorService.findByEmail(mail);
            case ROLE_COORDINATOR: return coordinatorService.findByEmail(mail);
            case ROLE_FACULTY_BOARD_MEMBER: return facultyBoardMemberService.findByEmail(mail);
        }
        return null;
    }
}
