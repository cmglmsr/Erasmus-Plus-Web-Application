package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.services.WishlistCourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class WishlistController {

    // give 5 wishlist courses to a student!!!
    private final WishlistCourseService wishlistCourseService;

    public WishlistController(WishlistCourseService wishlistCourseService) {
        this.wishlistCourseService = wishlistCourseService;
    }

    @PostMapping("/createCourseWishlist")
    public void createCourseWishlist() {
        
    }
}
