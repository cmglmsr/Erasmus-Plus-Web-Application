package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseApplication;
import com.crackware.erasmus.data.message.ResponseDocument;
import com.crackware.erasmus.data.message.ResponseFile;
import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ScheduleHelper;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
import java.util.List;

@RestController
@RequestMapping({"/coordinator", "coordinator"})
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    private final HelperService helperService;

    private final ToDoListService toDoListService;

    private final TaskService taskService;

    private final ToDoListItemService toDoListItemService;

    private final ScheduleService scheduleService;

    private final DocumentService documentService;

    private final ApplicationService applicationService;

    private final ImageService imageService;

    private final StudentService studentService;

    public CoordinatorController(CoordinatorService coordinatorService, HelperService helperService, ToDoListService toDoListService, TaskService taskService, ToDoListItemService toDoListItemService, ScheduleService scheduleService, DocumentService documentService, ApplicationService applicationService, ImageService imageService, StudentService studentService) {
        this.coordinatorService = coordinatorService;
        this.helperService = helperService;
        this.toDoListService = toDoListService;
        this.taskService = taskService;
        this.toDoListItemService = toDoListItemService;
        this.scheduleService = scheduleService;
        this.documentService = documentService;
        this.applicationService = applicationService;
        this.imageService = imageService;
        this.studentService = studentService;
    }

    @GetMapping("/home")
    public Coordinator coordinatorHome() {
       return (Coordinator) helperService.getUser();
    }
    @GetMapping("/profile")
    public Coordinator coordinatorProfile() {
        return (Coordinator) helperService.getUser();
    }
    @PostMapping("/profile/edit")
    public void editProfile(@RequestParam("profilePic") MultipartFile profilePic) throws IOException {
        imageService.saveImageFile(profilePic);
    }
    @PostMapping("/todolist")
    public void coordinatorToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
        ToDoListItem toDoListItem = ToDoListHelper.toDoListHelp(toDoRequest);
        if (helperService.getUser().getToDoList() == null) {
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
            coordinatorService.save((Coordinator) helperService.getUser());
        }
    }
    @GetMapping("/applications")
    public ResponseEntity<Set<ResponseApplication>> listApplications() {
        Set<Application> applications = applicationService.findAll();
        Set<ResponseApplication> responseApplications = new HashSet<>();
        for(Application a : applications) {
            ResponseApplication ra = new ResponseApplication(a);
            responseApplications.add(ra);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseApplications);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<ResponseApplication> getApplication(@PathVariable String id) {
        if(applicationService.findById(Long.valueOf(id))==null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseApplication());
        }
        Application a = applicationService.findById(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseApplication(a));
    }

    @PostMapping("/schedule")
    public void coordinatorSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
        Task task = ScheduleHelper.scheduleHelp(scheduleRequest);
        if (helperService.getUser().getSchedule() == null){
            helperService.getUser().setSchedule(new Schedule());
        }
        if (task.isDone()){
            taskService.deleteAllByDescriptionAndDueDate(scheduleRequest.getDescription(),
                    scheduleRequest.getDueDate());
        }else {
            taskService.save(task);
            if (helperService.getUser().getSchedule() != null)
                helperService.getUser().getSchedule().addItem(task);
            else {
                helperService.getUser().setSchedule(new Schedule());
                helperService.getUser().getSchedule().addItem(task);
            }
            scheduleService.save(helperService.getUser().getSchedule());
            coordinatorService.save((Coordinator) helperService.getUser());
        }
    }

    @PostMapping("/learningAgreement/approve/{id}")
    public void approveLearningAgreement(@PathVariable String id){
        Document agreement = documentService.findById(Long.valueOf(id));
        agreement.setDocumentStatus(Status.APPROVED);
        documentService.save(agreement);
    }

    @PostMapping("/learningAgreement/reject/{id}")
    public void rejectLearningAgreement(@PathVariable String id) {
        Document agreement = documentService.findById(Long.valueOf(id));
        agreement.setDocumentStatus(Status.DENIED);
        documentService.save(agreement);
    }

    @PostMapping("/learningAgreement/download/{id}")
    public ResponseEntity<byte[]> downloadLearningAgreement(@PathVariable int id){
        Document learningAgreement = documentService.findById((long) id);

        if(learningAgreement == null) {
            return null;
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + learningAgreement.getName() + ".pdf" + "\"")
                .body(learningAgreement.getData());
    }

    @GetMapping("/learningAgreements")
    public ResponseEntity<List<ResponseDocument>> getAgreements() {
        ArrayList<Student> students = new ArrayList<>(studentService.findAll());
        ArrayList<ResponseDocument> response = new ArrayList<>();
        for(Student s : students) {
            if(s.getLearningAgreement()!=null) {
                ResponseDocument rd = new ResponseDocument(
                        s.getName() + " " + s.getSurname(),
                        s.getBilkentId(),
                        s.getCgpa(),
                        s.getLearningAgreement().getDocumentStatus().toString(),
                        s.getLearningAgreement().getId().toString());
                response.add(rd);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

