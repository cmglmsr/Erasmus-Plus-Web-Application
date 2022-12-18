package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.WishlistCourse;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.services.StudentService;
import com.crackware.erasmus.data.services.WishlistCourseService;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("student")
public class WishlistController {

    private final WishlistCourseService wishlistCourseService;
    private final StudentService studentService;
    private final HelperService helperService;

    public WishlistController(WishlistCourseService wishlistCourseService, StudentService studentService, HelperService helperService) {
        this.wishlistCourseService = wishlistCourseService;
        this.studentService = studentService;
        this.helperService = helperService;
    }

    @PostMapping("/createCourseWishlist")
    public ResponseEntity<?> createCourseWishlist(@RequestBody ArrayList<LinkedHashMap<String,Object>> payload) {
        Student s = (Student)helperService.getUser();
        if(!s.getCourseWishlist().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User already has a course wishlist!");
        }
        ArrayList<WishlistCourse> wlcs = new ArrayList<>();
        for(int i = 0; i < payload.size(); i++) {
            for(String parameter : payload.get(0).keySet()) {
                switch (parameter) {
                    case "courseName":
                        System.out.println(parameter);
                        WishlistCourse wlc = new WishlistCourse();
                        wlc.setDepartment(s.getDepartment().toString());
                        wlc.setCourseName((String) payload.get(i).get(parameter));
                        wlcs.add(wlc);
                        break;
                    case "courseCode":
                        System.out.println(parameter);
                        wlcs.get(wlcs.size() - 1).setCourseCode((String) payload.get(i).get(parameter));
                        break;
                    case "hostUniversityName":
                        System.out.println(parameter);
                        wlcs.get(wlcs.size() - 1).setHostUniversityName((String) payload.get(i).get(parameter));
                        break;
                    case "approvedNotapproved":
                        System.out.println(parameter);
                        wlcs.get(wlcs.size() - 1).setApprovedNotApproved((String) payload.get(i).get(parameter));
                        break;
                }
            }
        }
        for(WishlistCourse w : wlcs) {
            w.setStatus(Status.WAITING_INSTRUCTOR);
            wishlistCourseService.save(w);
        }
        s.setCourseWishlist(new HashSet<>(wlcs));
        studentService.save(s);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @GetMapping("/getCourseWishlist")
    public Set<WishlistCourse> getCourseWishlist() {
        Student s = (Student)helperService.getUser();
        return s.getCourseWishlist();
    }
}
