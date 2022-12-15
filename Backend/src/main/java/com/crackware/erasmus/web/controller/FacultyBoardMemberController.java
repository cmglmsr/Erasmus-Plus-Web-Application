package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.FacultyBoardMember;
import com.crackware.erasmus.data.model.Instructor;
import com.crackware.erasmus.data.model.Schedule;
import com.crackware.erasmus.data.model.ToDoList;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.FacultyBoardMemberService;
import com.crackware.erasmus.data.services.ScheduleService;
import com.crackware.erasmus.data.services.ToDoListService;
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

    private final ScheduleService scheduleService;

    public FacultyBoardMemberController(HelperService helperService, FacultyBoardMemberService facultyBoardMemberService, ToDoListService toDoListService, ScheduleService scheduleService) {
        this.helperService = helperService;
        this.facultyBoardMemberService = facultyBoardMemberService;
        this.toDoListService = toDoListService;
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
        ToDoList toDoList = ToDoListHelper.toDoListHelp(toDoRequest);
        if (toDoList.isDone()){
            toDoListService.delete(toDoList);
        }else {
            toDoListService.save(toDoList);
        }
        facultyBoardMemberService.save((FacultyBoardMember) helperService.getUser());

    }

    @PostMapping("/schedule")
    public void fbmSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
        Schedule schedule = ScheduleHelper.scheduleHelp(scheduleRequest);
        if (schedule.isDone()){
            scheduleService.delete(schedule);
        }else {
            scheduleService.save(schedule);
        }
        facultyBoardMemberService.save((FacultyBoardMember) helperService.getUser());

    }
}