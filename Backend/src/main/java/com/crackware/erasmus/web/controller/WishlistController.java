package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.WishlistCourse;
import com.crackware.erasmus.data.services.StudentService;
import com.crackware.erasmus.data.services.WishlistCourseService;
import com.crackware.erasmus.data.services.helper.HelperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@RestController
@RequestMapping("student")
public class WishlistController {

    // give 5 wishlist courses to a student!!!
    private final WishlistCourseService wishlistCourseService;
    private final StudentService studentService;
    private final HelperService helperService;

    public WishlistController(WishlistCourseService wishlistCourseService, StudentService studentService, HelperService helperService) {
        this.wishlistCourseService = wishlistCourseService;
        this.studentService = studentService;
        this.helperService = helperService;
    }

    @PostMapping("/createCourseWishlist")
    public ResponseEntity<?> createCourseWishlist(@RequestBody HashMap<String, Object> payload) {
        Student s = (Student)helperService.getUser();
        if(!s.getCourseWishlist().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User already has a course wishlist!");
        }
        ArrayList<WishlistCourse> wlcs = new ArrayList<>();
        for(String parameter : payload.keySet()) {
            /*
            * TODO
            *  for each wishlist in body
            *  initialize wishlist course
            *  save wishlist course to student
            *  save wishlist course
            * */
            // If two dimensional json ==> LinkedHashMap<String,String> val = (LinkedHashMap<String,String>) payload.get(parameter);
            if(parameter.startsWith("courseName")) {
                WishlistCourse wlc = new WishlistCourse();
                wlc.setCourseName((String) payload.get(parameter));
                wlcs.add(wlc);
            }
            else if(parameter.startsWith("courseCode")) {
                wlcs.get(wlcs.size()-1).setCourseCode((String)payload.get(parameter));
            }
            else if(parameter.startsWith("hostUniversity")) {
                wlcs.get(wlcs.size() - 1).setHostUniversityName((String) payload.get(parameter));
            }
        }
        for(WishlistCourse w : wlcs) {
            wishlistCourseService.save(w);
        }
        s.setCourseWishlist(new HashSet<>(wlcs));
        studentService.save(s);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}
