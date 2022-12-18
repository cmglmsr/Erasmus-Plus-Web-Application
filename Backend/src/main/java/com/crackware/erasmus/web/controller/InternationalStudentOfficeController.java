package com.crackware.erasmus.web.controller;

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
@RequestMapping({"iso", "/iso"})
/**
 * Controller class for InternationalStudentOffice class
 */
public class InternationalStudentOfficeController {

    private final HelperService helperService;
    private final DocumentService documentService;

    private final ToDoListService toDoListService;

    private final ToDoListItemService toDoListItemService;

    private final InternationalStudentOfficeService isoService;

    private final StudentService studentService;

    // Constructor for InternationalStudentOfficeController class
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

    @GetMapping("/students")
    public ResponseEntity<ArrayList<Student>> getStudents() {
        ArrayList<Student> students = new ArrayList<>(studentService.findAll());
        ArrayList<Student> response = new ArrayList<>();
        for(Student s : students) {
            if(s.getApplication()!=null&&s.getApplication().getStatus()== Status.FINALIZED) {
                response.add(s);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}