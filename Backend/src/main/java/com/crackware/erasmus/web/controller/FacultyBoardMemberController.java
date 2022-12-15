package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.FacultyBoardMember;
import com.crackware.erasmus.data.model.Instructor;
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
@RequestMapping({"fbm", "/fbm"})
public class FacultyBoardMemberController {

    private final HelperService helperService;

    private final FacultyBoardMemberService facultyBoardMemberService;

    private final ToDoListService toDoListService;

    private final TaskService taskService;

    private final ToDoListItemService toDoListItemService;

    private final ScheduleService scheduleService;

    public FacultyBoardMemberController(HelperService helperService, FacultyBoardMemberService facultyBoardMemberService, ToDoListService toDoListService, TaskService taskService, ToDoListItemService toDoListItemService, ScheduleService scheduleService) {
        this.helperService = helperService;
        this.facultyBoardMemberService = facultyBoardMemberService;
        this.toDoListService = toDoListService;
        this.taskService = taskService;
        this.toDoListItemService = toDoListItemService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/home")
    public FacultyBoardMember facultyBoardMemberHome() {
        return (FacultyBoardMember) helperService.getUser();
    }
    @GetMapping("/profile")
    public FacultyBoardMember facultyBoardMemberProfile() {
        return (FacultyBoardMember) helperService.getUser();
    }

    @PostMapping("/todolist")
    public void fbmToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
        ToDoListItem toDoListItem = ToDoListHelper.toDoListHelp(toDoRequest);

        if (toDoListItem.isDone()){
            toDoListItemService.delete(toDoListItem);
        }else {
            toDoListItemService.save(toDoListItem);
        }
        helperService.getUser().getToDoList().addItem(toDoListItem);
        toDoListService.save(helperService.getUser().getToDoList());
        facultyBoardMemberService.save((FacultyBoardMember) helperService.getUser());

    }

    @PostMapping("/schedule")
    public void fbmSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
        Task task = ScheduleHelper.scheduleHelp(scheduleRequest);
        if (task.isDone()){
            taskService.delete(task);
        }else {
            taskService.save(task);
        }
        helperService.getUser().getSchedule().addItem(task);
        scheduleService.save(helperService.getUser().getSchedule());
        facultyBoardMemberService.save((FacultyBoardMember) helperService.getUser());

    }
}