package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.BaseEntity;
import com.crackware.erasmus.data.model.InternationalStudentOffice;
import com.crackware.erasmus.data.repositories.InternationalStudentOfficeRepository;
import com.crackware.erasmus.data.services.InternationalStudentOfficeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of AdminService interface
 */
public class InternationalStudentOfficeServiceImpl implements InternationalStudentOfficeService {

    private final InternationalStudentOfficeRepository internationalStudentOfficeRepository;
    // Constructor for AdminServiceImpl class
    public InternationalStudentOfficeServiceImpl(InternationalStudentOfficeRepository internationalStudentOfficeRepository) {
        this.internationalStudentOfficeRepository = internationalStudentOfficeRepository;
    }


    @Override
    public Set<InternationalStudentOffice> findAll() {
        HashSet<InternationalStudentOffice> ISOs = new HashSet<>();
        internationalStudentOfficeRepository.findAll().forEach(ISOs::add);
        return ISOs;
    }

    @Override
    public InternationalStudentOffice findById(Long aLong) {
        return internationalStudentOfficeRepository.findById(aLong).orElse(null);
    }

    @Override
    public InternationalStudentOffice save(InternationalStudentOffice object) {
        return internationalStudentOfficeRepository.save(object);
    }

    @Override
    public void delete(InternationalStudentOffice object) {
        internationalStudentOfficeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        internationalStudentOfficeRepository.deleteById(aLong);
    }

    @Override
    public BaseEntity findByEmail(String email) {
        return internationalStudentOfficeRepository.findByMail(email);
    }
}
