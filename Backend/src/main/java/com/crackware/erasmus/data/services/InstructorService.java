package com.crackware.erasmus.data.services;
import com.crackware.erasmus.data.model.Instructor;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class InstructorService {
    public String printInfo() {
        return List.of(
                new Instructor(
                        "Math",
                        "Sample signature"
                )
        ).toString();
    }
}
