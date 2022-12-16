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
public class Document {
    private String name;
    private String type;
    private Status documentStatus;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Lob
    private byte[] data;

    public Document(){}

    public Document(String name, String type, byte[] data, Status documentStatus) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.documentStatus = documentStatus;
    }
}
