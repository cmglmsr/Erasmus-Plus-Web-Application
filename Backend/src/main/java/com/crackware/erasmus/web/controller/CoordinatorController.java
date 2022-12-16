package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.message.ResponseApplication;
import com.crackware.erasmus.data.message.ResponseFile;
import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ScheduleHelper;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    public CoordinatorController(CoordinatorService coordinatorService, HelperService helperService, ToDoListService toDoListService, TaskService taskService, ToDoListItemService toDoListItemService, ScheduleService scheduleService, DocumentService documentService, ApplicationService applicationService) {
        this.coordinatorService = coordinatorService;
        this.helperService = helperService;
        this.toDoListService = toDoListService;
        this.taskService = taskService;
        this.toDoListItemService = toDoListItemService;
        this.scheduleService = scheduleService;
        this.documentService = documentService;
        this.applicationService = applicationService;
    }

    @GetMapping("/home")
    public Coordinator coordinatorHome() {
       return (Coordinator) helperService.getUser();
    }
    @GetMapping("/profile")
    public Coordinator coordinatorProfile() {
        return (Coordinator) helperService.getUser();
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
    public void rejectLearningAgreement(@PathVariable String id){
        Document agreement = documentService.findById(Long.valueOf(id));
        agreement.setDocumentStatus(Status.DENIED);
        documentService.save(agreement);
    }

    @GetMapping("/learningAgreements")
    public ResponseEntity<List<ResponseFile>> getAgreements(){
        ArrayList<Document> al = new ArrayList<>(documentService.findAll());
        List<ResponseFile> responseFiles = new ArrayList<>();
        for(Document d : al) {
            ResponseFile rf;
            if(d.getName().equals("learningAgreement")) {
                rf = new ResponseFile(d.getName(), d.getType(),d.getId().toString(), d.getDocumentStatus());
                responseFiles.add(rf);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseFiles);
    }



}

