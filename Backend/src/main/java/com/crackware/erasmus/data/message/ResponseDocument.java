package com.crackware.erasmus.data.message;

import com.crackware.erasmus.data.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Class which contains properties and functions for response of Document class
 */
public class ResponseDocument {
    String fullname;
    String id;
    String cgpa;
    String documentId;
    String status;

    // Default constructor
    public ResponseDocument() {}

    // Parameter supplied constructor
    public ResponseDocument(String fullname, String id, String cgpa, String status, String documentId) {
        this.fullname = fullname;
        this.id = id;
        this.cgpa = cgpa;
        this.status = status;
        this.documentId = documentId;
    }
}
