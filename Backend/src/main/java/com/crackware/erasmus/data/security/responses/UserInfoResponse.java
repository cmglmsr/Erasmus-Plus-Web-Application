package com.crackware.erasmus.data.security.responses;

import com.crackware.erasmus.data.model.security.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
/**
 * Class which contains properties and functions for response of UserInfoResponse class
 */
public class UserInfoResponse {
    private Long id;
    private String email;
    private String role;
    private String cookie;

    // Constructor which assigns a parameter values to the UserInfoResponse attributes
    public UserInfoResponse(Long id, String email, String role, String cookie) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.cookie = cookie;
    }
}
