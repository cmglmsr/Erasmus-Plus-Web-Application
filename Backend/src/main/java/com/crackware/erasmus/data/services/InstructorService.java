package com.example.demo.instructor;
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
