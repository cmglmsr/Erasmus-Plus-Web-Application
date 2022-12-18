package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.*;
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
@RequestMapping({"iso", "/iso"})
public class InternationalStudentOfficeController {

    private final HelperService helperService;
    private final DocumentService documentService;

    private final ToDoListService toDoListService;

    private final ToDoListItemService toDoListItemService;

    private final InternationalStudentOfficeService isoService;

    private final StudentService studentService;

    public InternationalStudentOfficeController(HelperService helperService, StudentService studentService,
                                                InternationalStudentOfficeService isoService,
                                                DocumentService documentService,
                                                ToDoListService toDoListService,
                                                ToDoListItemService toDoListItemService,
                                                StudentService studentService1) {
        this.helperService = helperService;
        this.isoService = isoService;
        this.documentService = documentService;
        this.toDoListService = toDoListService;
        this.toDoListItemService = toDoListItemService;
        this.studentService = studentService1;
    }

    @GetMapping("/home")
    public InternationalStudentOffice internationalStudentOfficeHome() {
        return (InternationalStudentOffice) helperService.getUser();
    }
    @GetMapping("/profile")
    public InternationalStudentOffice internationalStudentOfficeProfile() {
        return (InternationalStudentOffice) helperService.getUser();
    }

    @PostMapping("/upload/transcript")
    public void uploadTranscript(@RequestParam("transcript") MultipartFile transcript) throws IOException {
        Document document = new Document();
        document.setType(transcript.getContentType());
        document.setName(transcript.getName());
        document.setData(transcript.getBytes());
        documentService.save(document);
    }

    @PostMapping("/todolist")
    public void isoToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
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
            isoService.save((InternationalStudentOffice) helperService.getUser());
        }

    }

    @GetMapping("/students")
    public ResponseEntity<ArrayList<Student>> getStudents() {
        ArrayList<Student> students = new ArrayList<>(studentService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
}