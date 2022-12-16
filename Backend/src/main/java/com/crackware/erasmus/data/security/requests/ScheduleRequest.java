package com.crackware.erasmus.data.security.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ScheduleRequest {

    @NotBlank
    private String date;

    @NotBlank
    private String dueDate;

    @NotBlank
    private String description;

    @NotNull
    private boolean done;
}
