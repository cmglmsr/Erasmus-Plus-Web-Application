package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Schedule;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.ToDoList;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.ScheduleService;
import com.crackware.erasmus.data.services.StudentService;
import com.crackware.erasmus.data.services.ToDoListService;
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

    private final ScheduleService scheduleService;

    public StudentController(HelperService helperService, StudentService studentService, ToDoListService toDoListService, ScheduleService scheduleService) {
        this.helperService = helperService;
        this.studentService = studentService;
        this.toDoListService = toDoListService;
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
        ToDoList toDoList = ToDoListHelper.toDoListHelp(toDoRequest);
        if (toDoList.isDone()){
            toDoListService.delete(toDoList);
        }else {
            toDoListService.save(toDoList);
        }
    }

    @PostMapping("/schedule")
    public void studentSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
        Schedule schedule = ScheduleHelper.scheduleHelp(scheduleRequest);
        if (schedule.isDone()){
            scheduleService.delete(schedule);
        }else {
            scheduleService.save(schedule);
        }
    }
}

