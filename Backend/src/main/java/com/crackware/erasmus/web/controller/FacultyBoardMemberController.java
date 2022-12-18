package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseDocument;
import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping({"fbm", "/fbm"})
public class FacultyBoardMemberController {

    private final HelperService helperService;

    private final FacultyBoardMemberService facultyBoardMemberService;

    private final ToDoListService toDoListService;

    private final ToDoListItemService toDoListItemService;

    private final DocumentService documentService;

    private final ImageService imageService;

    private final StudentService studentService;

    public FacultyBoardMemberController(HelperService helperService,
                                        FacultyBoardMemberService facultyBoardMemberService,
                                        ToDoListService toDoListService, ToDoListItemService toDoListItemService,
                                        DocumentService documentService, ImageService imageService,
                                        StudentService studentService) {
        this.helperService = helperService;
        this.facultyBoardMemberService = facultyBoardMemberService;
        this.toDoListService = toDoListService;
        this.toDoListItemService = toDoListItemService;
        this.documentService = documentService;
        this.imageService = imageService;
        this.studentService = studentService;
    }

    @GetMapping("/home")
    public FacultyBoardMember facultyBoardMemberHome() {
        return (FacultyBoardMember) helperService.getUser();
    }
    @GetMapping("/profile")
    public FacultyBoardMember facultyBoardMemberProfile() {
        return (FacultyBoardMember) helperService.getUser();
    }

    @PostMapping("/profile/edit")
    public void editProfile(@RequestParam("profilePic") MultipartFile profilePic) throws IOException {
        imageService.saveImageFile(profilePic);
    }

    @PostMapping("/preapproval/approve/{id}")
    public void approvePreApproval(@PathVariable String id){
        Document document = documentService.findById(Long.valueOf(id));
        document.setDocumentStatus(Status.APPROVED);
        documentService.save(document);
    }

    @PostMapping("/preapproval/reject/{id}")
    public void rejectPreApproval(@PathVariable String id){
        Document document = documentService.findById(Long.valueOf(id));
        document.setDocumentStatus(Status.DENIED);
        documentService.save(document);
    }

    @GetMapping("/download/preapproval/{id}")
    public ResponseEntity<byte[]> getPreApproval(@PathVariable String id) {
        Document preApproval = documentService.findById(Long.valueOf(id));
        if(preApproval==null) {
            return null;
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + preApproval.getName() + ".pdf" + "\"")
                .body(preApproval.getData());
    }

    @GetMapping("/preapprovals")
    public ResponseEntity<ArrayList<ResponseDocument>> preApprovals(){
        ArrayList<Student> students = new ArrayList<>(studentService.findAll());
        ArrayList<ResponseDocument> response = new ArrayList<>();
        for(Student s : students) {
            if(s.getPreApproval()!=null) {
                ResponseDocument rd = new ResponseDocument(
                        s.getName() + " " + s.getSurname(),
                        s.getBilkentId(),
                        s.getCgpa(),
                        s.getPreApproval().getDocumentStatus().toString(),
                        s.getPreApproval().getId().toString());
                response.add(rd);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}