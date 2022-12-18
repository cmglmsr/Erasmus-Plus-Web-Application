package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.enums.ItemType;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping( "/student")
/**
 * Controller class for Student class
 */
public class StudentController {

    private final HelperService helperService;

    private final StudentService studentService;

    private final ToDoListHelper toDoListHelper;

    private final ToDoListService toDoListService;

    private final ToDoListItemService toDoListItemService;

    private final DocumentService documentService;

    private final ImageService imageService;

    private final CourseService courseService;

    // Constructor for StudentController class
    public StudentController(HelperService helperService, StudentService studentService,
                             ToDoListHelper toDoListHelper, ToDoListService toDoListService, ToDoListItemService toDoListItemService,
                             DocumentService documentService, ImageService imageService,
                             CourseService courseService) {
        this.helperService = helperService;
        this.studentService = studentService;
        this.toDoListHelper = toDoListHelper;
        this.toDoListService = toDoListService;
        this.toDoListItemService = toDoListItemService;
        this.documentService = documentService;
        this.imageService = imageService;
        this.courseService = courseService;
    }
    @GetMapping("/home")
    public Student studentHome() {
        return (Student) helperService.getUser();
    }
    @GetMapping("/profile")
    public Student studentProfile() {
        return (Student) helperService.getUser();
    }

    @PostMapping("/profile/edit")
    public void editProfile(@RequestParam("profilePic") MultipartFile profilePic) throws IOException {
        imageService.saveImageFile(profilePic);
    }

    @PostMapping("/upload/learningAgreement")
    public void submitLearningAgreement(@RequestParam("learningAgreement") MultipartFile learningAgreement) throws IOException {
            Document learning = new Document();
            learning.setName(learningAgreement.getName());
            learning.setType(learningAgreement.getContentType());
            learning.setData(learningAgreement.getBytes());
            documentService.save(learning);
            learning.setDocumentStatus(Status.WAITING_COORDINATOR);
            Student curr = (Student) helperService.getUser();
            curr.setLearningAgreement(learning);
            studentService.save(curr);
            int count = 0;
            ArrayList<Student> students = new ArrayList<>(studentService.findAll());
            for (Student student: students){
                if (student.getLearningAgreement() != null)
                    count++;
            }
            toDoListHelper.addItem(ItemType.LEARNING_AGREEMENT, count);
    }

    @GetMapping("learningAgreement")
    public Document viewLearningAgreement(){
        Student student = (Student) helperService.getUser();
        return student.getLearningAgreement();
    }

    @PostMapping("/upload/preapproval")
        public void uploadPreApproval(@RequestParam("preApproval") MultipartFile preApprovalFile) throws IOException {
        Document preApproval = new Document();
        preApproval.setData(preApprovalFile.getBytes());
        preApproval.setType(preApprovalFile.getContentType());
        preApproval.setName(preApprovalFile.getName());
        documentService.save(preApproval);
        preApproval.setDocumentStatus(Status.WAITING_FBM);
        Student curr = (Student) helperService.getUser();
        curr.setPreApproval(preApproval);
        studentService.save(curr);

    }

    @GetMapping("/preapproval")
    public Document showPreApproval(){
        Student student = (Student) helperService.getUser();
        return (student.getPreApproval());
    }

    @GetMapping("/download/preapproval")
    public ResponseEntity<byte[]> getPreApproval() {
        Student s = (Student) helperService.getUser();
        if(s.getPreApproval()==null||s.getPreApproval().getData()==null) {
            return null;
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + s.getPreApproval().getName() + ".pdf" + "\"")
                .body(s.getPreApproval().getData());
    }

    @GetMapping("/download/learningAgreement")
    public ResponseEntity<byte[]> getLearningAgreement() {
        Student s = (Student) helperService.getUser();
        if(s.getLearningAgreement()==null||s.getLearningAgreement().getData()==null) {
            return null;
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + s.getLearningAgreement().getName() + ".pdf" + "\"")
                .body(s.getLearningAgreement().getData());
    }

    @GetMapping("/approvedCoursesList")
    public Set<Course> showCourses(){
        Student s = (Student) helperService.getUser();
        if(s.getApplication() == null || s.getApplication().getStatus() != Status.FINALIZED) {
            return new HashSet<>();
        }
        School school = s.getApplication().getFinalSchool();
        ArrayList<Course> courses = new ArrayList<>(courseService.findAll());
        ArrayList<Course> returnCourses = new ArrayList<>();
        for(Course c : courses) {
            if(c.getHostUniversityName()!=null && c.getHostUniversityName().equals(school.getName())) {
                returnCourses.add(c);
            }
        }
        return new HashSet<>(returnCourses);
    }
}

