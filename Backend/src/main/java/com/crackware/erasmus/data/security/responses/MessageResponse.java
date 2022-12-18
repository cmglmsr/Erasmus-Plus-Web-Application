package com.crackware.erasmus.data.security.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Class which contains properties and functions for response of MessageResponse class
 */
public class MessageResponse {
    private String message;

    // Function which assigns a value to the message attribute
    public MessageResponse(String s) {
        this.message = s;
    }
}
