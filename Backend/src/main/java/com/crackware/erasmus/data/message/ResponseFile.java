package com.crackware.erasmus.data.message;

import com.crackware.erasmus.data.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseFile {
    private String name;
    private String type;
    private String id;
    private Status status;

    public ResponseFile(String name, String type, String id, Status status) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.status = status;
    }
}
