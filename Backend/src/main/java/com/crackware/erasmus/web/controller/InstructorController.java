package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Instructor;
import com.crackware.erasmus.data.model.InternationalStudentOffice;
import com.crackware.erasmus.data.model.Task;
import com.crackware.erasmus.data.model.ToDoListItem;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ScheduleHelper;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping({"instructor", "/instructor"})
public class InstructorController {

    private final HelperService helperService;

    private final InstructorService instructorService;

    private final ScheduleService scheduleService;

    private final ToDoListItemService toDoListItemService;

    private final TaskService taskService;

    private final ToDoListService toDoListService;

    public InstructorController(HelperService helperService, InstructorService instructorService, ScheduleService scheduleService, ToDoListItemService toDoListItemService, TaskService taskService, ToDoListService toDoListService) {
        this.helperService = helperService;
        this.instructorService = instructorService;
        this.scheduleService = scheduleService;
        this.toDoListItemService = toDoListItemService;
        this.taskService = taskService;
        this.toDoListService = toDoListService;
    }

    @GetMapping("/home")
    public Instructor instructorHome() {
        return (Instructor) helperService.getUser();
    }
    @GetMapping("/profile")
    public Instructor instructorProfile() {
        return (Instructor) helperService.getUser();
    }

    @PostMapping("/todolist")
    public void instructorToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
        ToDoListItem toDoListItem = ToDoListHelper.toDoListHelp(toDoRequest);

        if (toDoListItem.isDone()){
            toDoListItemService.delete(toDoListItem);
        }else {
            toDoListItemService.save(toDoListItem);
        }
        helperService.getUser().getToDoList().addItem(toDoListItem);
        toDoListService.save(helperService.getUser().getToDoList());
        instructorService.save((Instructor) helperService.getUser());
    }

    @PostMapping("/schedule")
    public void instructorSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
        Task task = ScheduleHelper.scheduleHelp(scheduleRequest);
        if (task.isDone()){
            taskService.delete(task);
        }else {
            taskService.save(task);
        }
        helperService.getUser().getSchedule().addItem(task);
        scheduleService.save(helperService.getUser().getSchedule());
        instructorService.save((Instructor) helperService.getUser());

    }

}
