package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Task;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.ToDoListItem;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ScheduleHelper;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    public StudentController(HelperService helperService, StudentService studentService, ToDoListService toDoListService, ToDoListItemService toDoListItemService, TaskService taskService, ScheduleService scheduleService) {
        this.helperService = helperService;
        this.studentService = studentService;
        this.toDoListService = toDoListService;
        this.toDoListItemService = toDoListItemService;
        this.taskService = taskService;
        this.scheduleService = scheduleService;
    }
    @GetMapping("/home")
    public Student studentHome(){
        return (Student) helperService.getUser();
    }
    @GetMapping("/profile")
    public Student studentProfile() {
        return (Student) helperService.getUser();
    }

    @PostMapping("/todolist")
    public void studentToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
        ToDoListItem toDoListItem = ToDoListHelper.toDoListHelp(toDoRequest);

        if (toDoListItem.isDone()){
            toDoListItemService.delete(toDoListItem);
        }else {
            toDoListItemService.save(toDoListItem);
        }
        helperService.getUser().getToDoList().addItem(toDoListItem);
        toDoListService.save(helperService.getUser().getToDoList());
        studentService.save((Student) helperService.getUser());
    }

    @PostMapping("/schedule")
    public void studentSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
        Task task = ScheduleHelper.scheduleHelp(scheduleRequest);
        if (task.isDone()){
            taskService.delete(task);
        }else {
            taskService.save(task);
        }
        helperService.getUser().getSchedule().addItem(task);
        scheduleService.save(helperService.getUser().getSchedule());
        studentService.save((Student) helperService.getUser());
    }
}

