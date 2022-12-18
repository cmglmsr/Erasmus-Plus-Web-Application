package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
/**
 * Class which contains properties and functions for Document class
 */
public class Document {
    private String name;
    private String type;
    private Status documentStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] data;

    // Default constructor
    public Document(){}

    // Parameter supplied constructor
    public Document(String name, String type, byte[] data, Status documentStatus) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.documentStatus = documentStatus;
    }
}
