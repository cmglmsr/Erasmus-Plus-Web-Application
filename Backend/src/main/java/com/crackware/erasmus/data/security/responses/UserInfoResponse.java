package com.crackware.erasmus.data.security.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserInfoResponse {
    private Long id;
    private String email;
    private List<String> roles;
    private String cookie;

    public UserInfoResponse(Long id, String email, List<String> roles, String cookie) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.cookie = cookie;
    }
}
