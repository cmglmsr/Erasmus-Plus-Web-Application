package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.repositories.InternationalStudentOfficeRepository;
import com.crackware.erasmus.data.services.InternationalStudentOfficeService;
import org.springframework.stereotype.Service;

@Service
public class InternationalStudentOfficeServiceImpl implements InternationalStudentOfficeService {

    private final InternationalStudentOfficeRepository internationalStudentOfficeRepository;


    public InternationalStudentOfficeServiceImpl(InternationalStudentOfficeRepository internationalStudentOfficeRepository) {
        this.InternationalStudentOfficeRepository = internationalStudentOfficeRepository;
    }
}
