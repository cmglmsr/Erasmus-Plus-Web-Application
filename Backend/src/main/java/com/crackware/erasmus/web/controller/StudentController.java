package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ScheduleHelper;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@CrossOrigin(origins = "localhost://", maxAge = 3600)
@RestController
@RequestMapping( "/student")
public class StudentController {

    private final HelperService helperService;

    private final StudentService studentService;

    private final ToDoListService toDoListService;

    private final ToDoListItemService toDoListItemService;

    private final TaskService taskService;

    private final ScheduleService scheduleService;

    private final DocumentService documentService;

    public StudentController(HelperService helperService, StudentService studentService, ToDoListService toDoListService, ToDoListItemService toDoListItemService, TaskService taskService, ScheduleService scheduleService, DocumentService documentService) {
        this.helperService = helperService;
        this.studentService = studentService;
        this.toDoListService = toDoListService;
        this.toDoListItemService = toDoListItemService;
        this.taskService = taskService;
        this.scheduleService = scheduleService;
        this.documentService = documentService;
    }
    @GetMapping("/home")
    public Student studentHome() {
        return (Student) helperService.getUser();
    }
    @GetMapping("/profile")
    public Student studentProfile() {
        return (Student) helperService.getUser();
    }

    @PostMapping("/todolist")
    public void studentToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
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
            studentService.save((Student) helperService.getUser());
        }

    }

    @PostMapping("/schedule")
    public void studentSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
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
            studentService.save((Student) helperService.getUser());
        }

    }

    @PostMapping("/upload/LearningAgreement")
    public void submitLearningAgreement(@RequestParam("learningAgreement") MultipartFile learningAgreement) throws IOException {
            Document learning = new Document();
            learning.setName(learningAgreement.getName());
            learning.setType(learningAgreement.getContentType());
            learning.setData(learningAgreement.getBytes());
            documentService.save(learning);
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
    }

    @GetMapping("/preapproval")
    public Document showPreApproval(){
        Student student = (Student) helperService.getUser();
        return (student.getPreApproval());
    }


}

