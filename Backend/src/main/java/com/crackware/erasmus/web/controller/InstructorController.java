package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping({"instructor", "/instructor"})
/**
 * Controller class for Instructor class
 */
public class InstructorController {

    private final HelperService helperService;

    private final InstructorService instructorService;

    private final ToDoListItemService toDoListItemService;

    private final ToDoListService toDoListService;

    private final ImageService imageService;

    private final StudentService studentService;

    private final WishlistCourseService wishlistCourseService;

    private final CourseService courseService;

    private final ApplicationService applicationService;

    // Constructor for InstructorController class
    public InstructorController(HelperService helperService, InstructorService instructorService,
                                ToDoListItemService toDoListItemService, ToDoListService toDoListService,
                                ImageService imageService, StudentService studentService,
                                WishlistCourseService wishlistCourseService, CourseService courseService, ApplicationService applicationService) {
        this.helperService = helperService;
        this.instructorService = instructorService;
        this.toDoListItemService = toDoListItemService;
        this.toDoListService = toDoListService;
        this.imageService = imageService;
        this.studentService = studentService;
        this.wishlistCourseService = wishlistCourseService;
        this.courseService = courseService;
        this.applicationService = applicationService;
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

    @GetMapping("/wishlists")
    public List<Student> getWishlists() {
        Instructor instructor = (Instructor) helperService.getUser();
        Department department = instructor.getDepartment();
        ArrayList<Student> students = new ArrayList<>(studentService.findAll());
        ArrayList<Student> departmentStudents = new ArrayList<>();
        System.out.println("here");
        for(Student s : students) {
            System.out.println("for student " + s.getName());
            if(s.getDepartment()==department) {
                departmentStudents.add(s);
            }
        }
        return departmentStudents;
    }

    @PostMapping("/wishlist/approve/{studentID}")
    public void approveWishlist(@PathVariable String studentID){
        Student student = studentService.findById(Long.valueOf(studentID));
        ArrayList<WishlistCourse> courses = new ArrayList<>(student.getCourseWishlist());
        for (WishlistCourse course : courses) {
            course.setStatus(Status.APPROVED);
            Course newApproved = new Course();
            newApproved.setCourseName(course.getCourseName());
            newApproved.setDepartment(course.getDepartment());
            newApproved.setHostUniversityName(course.getHostUniversityName());
            newApproved.setCourseCode(course.getCourseCode());
            courseService.save(newApproved);
            wishlistCourseService.save(course);
        }
    }

    @PostMapping("/wishlist/reject/{studentID}")
    public void rejectWishlist(@PathVariable String studentID){
        Student student = studentService.findById(Long.valueOf(studentID));
        ArrayList<WishlistCourse> courses = new ArrayList<>(student.getCourseWishlist());
        for (WishlistCourse course : courses) {
            wishlistCourseService.delete(course);
        }
        student.setCourseWishlist(new HashSet<>());
        studentService.save(student);
    }

    @GetMapping("/wishlist/{studentID}")
    public Set<WishlistCourse> getWishlist(@PathVariable String studentID) {
        Student student = studentService.findById(Long.valueOf(studentID));
        return student.getCourseWishlist();
    }

}
