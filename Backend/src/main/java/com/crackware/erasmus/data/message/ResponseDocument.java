package com.crackware.erasmus.data.message;

import com.crackware.erasmus.data.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDocument {
    String fullname;
    String id;
    String cgpa;
    String documentId;
    String status;
    public ResponseDocument() {}
    public ResponseDocument(String fullname, String id, String cgpa, String status, String documentId) {
        this.fullname = fullname;
        this.id = id;
        this.cgpa = cgpa;
        this.status = status;
        this.documentId = documentId;
    }
}
