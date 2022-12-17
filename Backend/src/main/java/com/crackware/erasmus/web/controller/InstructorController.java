package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping({"instructor", "/instructor"})
public class InstructorController {

    private final HelperService helperService;

    private final InstructorService instructorService;

    private final ToDoListItemService toDoListItemService;

    private final ToDoListService toDoListService;

    private final ImageService imageService;

    private final StudentService studentService;

    public InstructorController(HelperService helperService, InstructorService instructorService, ToDoListItemService toDoListItemService, ToDoListService toDoListService, ImageService imageService, StudentService studentService) {
        this.helperService = helperService;
        this.instructorService = instructorService;
        this.toDoListItemService = toDoListItemService;
        this.toDoListService = toDoListService;
        this.imageService = imageService;
        this.studentService = studentService;
    }

    @GetMapping("/home")
    public Instructor instructorHome() {
        return (Instructor) helperService.getUser();
    }
    @GetMapping("/profile")
    public Instructor instructorProfile() {
        return (Instructor) helperService.getUser();
    }

    @PostMapping("/profile/edit")
    public void editProfile(@RequestParam("profilePic") MultipartFile profilePic) throws IOException {
        imageService.saveImageFile(profilePic);
    }

    @PostMapping("/todolist")
    public void instructorToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
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
            instructorService.save((Instructor) helperService.getUser());
        }
    }


    @GetMapping("/wishlists")
    public void getWishlists() {
        Instructor instructor = (Instructor) helperService.getUser();
        Department department = instructor.getDepartment();
        ArrayList<Student> students = new ArrayList<>(studentService.findAll());
        ArrayList<Student> departmentStudents = new ArrayList<>();
        for(Student s : students) {
            if(s.getDepartment()==department) {
                departmentStudents.add(s);
            }
        }
    }
}
