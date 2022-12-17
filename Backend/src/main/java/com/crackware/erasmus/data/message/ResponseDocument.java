package com.crackware.erasmus.data.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDocument {
    String fullname;
    String id;
    String cgpa;
    String documentId;
    public ResponseDocument() {}
    public ResponseDocument(String fullname, String id, String cgpa, String documentId) {
        this.fullname = fullname;
        this.id = id;
        this.cgpa = cgpa;
        this.documentId = documentId;
    }
}
