package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Instructor;
import com.crackware.erasmus.data.model.Schedule;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.ToDoList;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.InstructorService;
import com.crackware.erasmus.data.services.ScheduleService;
import com.crackware.erasmus.data.services.ToDoListService;
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

    private final ToDoListService toDoListService;

    public InstructorController(HelperService helperService, InstructorService instructorService, ScheduleService scheduleService, ToDoListService toDoListService) {
        this.helperService = helperService;
        this.instructorService = instructorService;
        this.scheduleService = scheduleService;
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
        ToDoList toDoList = ToDoListHelper.toDoListHelp(toDoRequest);
        if (toDoList.isDone()){
            toDoListService.delete(toDoList);
        }else {
            toDoListService.save(toDoList);
        }
        instructorService.save((Instructor) helperService.getUser());
    }

    @PostMapping("/schedule")
    public void instructorSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
        Schedule schedule = ScheduleHelper.scheduleHelp(scheduleRequest);
        if (schedule.isDone()){
            scheduleService.delete(schedule);
        }else {
            scheduleService.save(schedule);
        }
        instructorService.save((Instructor) helperService.getUser());

    }

}
