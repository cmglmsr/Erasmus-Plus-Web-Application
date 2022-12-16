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

@RestController
@RequestMapping({"iso", "/iso"})
public class InternationalStudentOfficeController {

    private final HelperService helperService;
    private final DocumentService documentService;

    private final ToDoListService toDoListService;

    private final ScheduleService scheduleService;

    private final TaskService taskService;

    private final ToDoListItemService toDoListItemService;

    private final InternationalStudentOfficeService isoService;
    public InternationalStudentOfficeController(HelperService helperService, StudentService studentService,
                                                InternationalStudentOfficeService isoService,
                                                DocumentService documentService,
                                                ToDoListService toDoListService, ScheduleService scheduleService,
                                                TaskService taskService, ToDoListItemService toDoListItemService) {
        this.helperService = helperService;
        this.isoService = isoService;
        this.documentService = documentService;
        this.toDoListService = toDoListService;
        this.scheduleService = scheduleService;
        this.taskService = taskService;
        this.toDoListItemService = toDoListItemService;
    }

    @GetMapping("/home")
    public InternationalStudentOffice internationalStudentOfficeHome() {
        return (InternationalStudentOffice) helperService.getUser();
    }
    @GetMapping("/profile")
    public InternationalStudentOffice internationalStudentOfficeProfile() {
        return (InternationalStudentOffice) helperService.getUser();
    }

    @PostMapping("/upload/transcript")
    public void uploadTranscript(@RequestParam("transcript") MultipartFile transcript) throws IOException {
        Document document = new Document();
        document.setType(transcript.getContentType());
        document.setName(transcript.getName());
        document.setData(transcript.getBytes());
        documentService.save(document);
    }

    @PostMapping("/todolist")
    public void isoToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
        ToDoListItem toDoListItem = ToDoListHelper.toDoListHelp(toDoRequest);
        if (helperService.getUser().getSchedule() == null){
            helperService.getUser().setSchedule(new Schedule());
        }
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
            isoService.save((InternationalStudentOffice) helperService.getUser());
        }

    }

    @PostMapping("/schedule")
    public void isoSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
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
            isoService.save((InternationalStudentOffice) helperService.getUser());
        }

    }
}