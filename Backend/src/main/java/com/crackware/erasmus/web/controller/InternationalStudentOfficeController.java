package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.InternationalStudentOffice;
import com.crackware.erasmus.data.model.Schedule;
import com.crackware.erasmus.data.model.ToDoList;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.InternationalStudentOfficeService;
import com.crackware.erasmus.data.services.ScheduleService;
import com.crackware.erasmus.data.services.StudentService;
import com.crackware.erasmus.data.services.ToDoListService;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ScheduleHelper;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import com.crackware.erasmus.data.services.impl.FileUploadServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping({"iso", "/iso"})
public class InternationalStudentOfficeController {

    private final HelperService helperService;
    private final FileUploadServiceImpl fileUploadService;

    private final ToDoListService toDoListService;

    private final ScheduleService scheduleService;

    private final InternationalStudentOfficeService isoService;
    public InternationalStudentOfficeController(HelperService helperService, StudentService studentService,
                                                InternationalStudentOfficeService isoService,
                                                FileUploadServiceImpl fileUploadService,
                                                ToDoListService toDoListService, ScheduleService scheduleService) {
        this.helperService = helperService;
        this.isoService = isoService;
        this.fileUploadService = fileUploadService;
        this.toDoListService = toDoListService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/home")
    public InternationalStudentOffice internationalStudentOfficeHome() {
        return (InternationalStudentOffice) helperService.getUser();
    }
    @GetMapping("/profile")
    public InternationalStudentOffice internationalStudentOfficeProfile() {
        return (InternationalStudentOffice) helperService.getUser();
    }

    @PostMapping("/home")
    public void uploadFile(@RequestParam("transcript") MultipartFile transcript) throws IOException {
        try {
            fileUploadService.store(transcript);
            System.out.println("[+] Transcript upload successful.");
        } catch (IOException e) {
            System.out.println("[-] Transcript upload failed.");
        }
    }

    @PostMapping("/todolist")
    public void isoToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
        ToDoList toDoList = ToDoListHelper.toDoListHelp(toDoRequest);
        if (toDoList.isDone()){
            toDoListService.delete(toDoList);
        }else {
            toDoListService.save(toDoList);
        }
    }

    @PostMapping("/schedule")
    public void isoSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
        Schedule schedule = ScheduleHelper.scheduleHelp(scheduleRequest);
        if (schedule.isDone()){
            scheduleService.delete(schedule);
        }else {
            scheduleService.save(schedule);
        }
    }
}