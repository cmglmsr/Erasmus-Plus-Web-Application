package com.crackware.erasmus.data.security.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ScheduleRequest {

    @NotBlank
    private String date;

    @NotBlank
    private String dueDate;

    @NotBlank
    private String description;

    @NotBlank
    private boolean done;
}
