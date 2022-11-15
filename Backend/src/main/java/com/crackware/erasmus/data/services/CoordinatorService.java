package com.example.demo.Coordinator;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoordinatorService {
    public String printInfo() {
        return List.of(
                new Coordinator(
                        "Math",
                        "Sample signature"
                )
        ).toString();
    }
}
