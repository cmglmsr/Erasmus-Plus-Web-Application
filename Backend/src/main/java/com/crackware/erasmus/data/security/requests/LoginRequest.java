package com.crackware.erasmus.data.security.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String mail;

    @NotBlank
    private String password;

}
