package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.InternationalStudentOffice;
import com.crackware.erasmus.data.repositories.InternationalStudentOfficeRepository;
import com.crackware.erasmus.data.services.InternationalStudentOfficeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class InternationalStudentOfficeServiceImpl implements InternationalStudentOfficeService {

    private final InternationalStudentOfficeRepository internationalStudentOfficeRepository;

    public InternationalStudentOfficeServiceImpl(InternationalStudentOfficeRepository internationalStudentOfficeRepository) {
        this.internationalStudentOfficeRepository = internationalStudentOfficeRepository;
    }


    @Override
    public Set<InternationalStudentOffice> findAll() {
        return null;
    }

    @Override
    public InternationalStudentOffice findById(Long aLong) {
        return null;
    }

    @Override
    public InternationalStudentOffice save(InternationalStudentOffice object) {
        return null;
    }

    @Override
    public void delete(InternationalStudentOffice object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
