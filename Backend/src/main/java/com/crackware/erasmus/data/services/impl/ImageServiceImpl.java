package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.security.Role;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
/**
 * Class which contains implementations of AdminService interface
 */
public class ImageServiceImpl implements ImageService {

    private final AdminService adminService;

    private final StudentService studentService;

    private final CoordinatorService coordinatorService;

    private final InstructorService instructorService;

    private final InternationalStudentOfficeService isoService;

    private final FacultyBoardMemberService facultyBoardMemberService;

    private final HelperService helperService;
    // Constructor for AdminServiceImpl class
    public ImageServiceImpl(AdminService adminService, StudentService studentService,
                            CoordinatorService coordinatorService, InstructorService instructorService,
                            InternationalStudentOfficeService isoService,
                            FacultyBoardMemberService facultyBoardMemberService, HelperService helperService) {
        this.adminService = adminService;
        this.studentService = studentService;
        this.coordinatorService = coordinatorService;
        this.instructorService = instructorService;
        this.isoService = isoService;
        this.facultyBoardMemberService = facultyBoardMemberService;
        this.helperService = helperService;
    }

    @Override
    public void saveImageFile(MultipartFile file) throws IOException {
        BaseEntity user = helperService.getUser();

        Byte[] byteObjects = new Byte[file.getBytes().length];

        int i = 0;
        for (byte b : file.getBytes()){
            byteObjects[i++] = b;
        }

        user.setImage(byteObjects);

        Role currentRole = user.getRole();
        switch (currentRole.getName()) {
            case ROLE_ADMIN: adminService.save((Admin) user); break;
            case ROLE_ISO: isoService.save((InternationalStudentOffice) user);break;
            case ROLE_STUDENT: studentService.save((Student) user);break;
            case ROLE_INSTRUCTOR: instructorService.save((Instructor) user);break;
            case ROLE_COORDINATOR: coordinatorService.save((Coordinator) user);break;
            case ROLE_FACULTY_BOARD_MEMBER: facultyBoardMemberService.save((FacultyBoardMember) user);break;
        }
    }
}
