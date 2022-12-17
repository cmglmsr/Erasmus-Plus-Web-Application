package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseFile;
import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
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

    public FacultyBoardMemberController(HelperService helperService,
                                        FacultyBoardMemberService facultyBoardMemberService,
                                        ToDoListService toDoListService, ToDoListItemService toDoListItemService,
                                        DocumentService documentService, ImageService imageService) {
        this.helperService = helperService;
        this.facultyBoardMemberService = facultyBoardMemberService;
        this.toDoListService = toDoListService;
        this.toDoListItemService = toDoListItemService;
        this.documentService = documentService;
        this.imageService = imageService;
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

    @PostMapping("/todolist")
    public void fbmToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
        ToDoListItem toDoListItem = ToDoListHelper.toDoListHelp(toDoRequest);
        if (helperService.getUser().getToDoList() == null){
            helperService.getUser().setToDoList(new ToDoList());
        }
        if (toDoListItem.isDone()){
            toDoListItemService.deleteAllByDescriptionAndDueDate(toDoListItem.getDescription(),
                    toDoRequest.getDueDate());
        }else {
            toDoListItemService.save(toDoListItem);
            if (helperService.getUser().getToDoList() != null)
                helperService.getUser().getToDoList().addItem(toDoListItem);
            else {
                helperService.getUser().setToDoList(new ToDoList());
                helperService.getUser().getToDoList().addItem(toDoListItem);
            }
            toDoListService.save(helperService.getUser().getToDoList());
            facultyBoardMemberService.save((FacultyBoardMember) helperService.getUser());
        }
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

    @GetMapping("/preapprovals")
    public ResponseEntity<ArrayList<ResponseFile>> preApprovals(){
        ArrayList<Document> documents = new ArrayList<>(documentService.findAll());
        ArrayList<ResponseFile> preApps = new ArrayList<>();
        for (Document document : documents) {
            ResponseFile rf;
            if (document.getName().equals("preApproval")) {
                rf = new ResponseFile(document.getName(), document.getType(),document.getId().toString(), document.getDocumentStatus());
                preApps.add(rf);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(preApps);
    }
}