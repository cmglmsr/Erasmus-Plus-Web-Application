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
 * Class which contains implementations of InternationalStudentOfficeService interface
 */
public class InternationalStudentOfficeServiceImpl implements InternationalStudentOfficeService {

    private final InternationalStudentOfficeRepository internationalStudentOfficeRepository;
    // Constructor for InternationalStudentOfficeServiceImpl class
    public InternationalStudentOfficeServiceImpl(InternationalStudentOfficeRepository internationalStudentOfficeRepository) {
        this.internationalStudentOfficeRepository = internationalStudentOfficeRepository;
    }


    @Override
    // Function which finds all InternationalStudentOffice instances by ID
    public Set<InternationalStudentOffice> findAll() {
        HashSet<InternationalStudentOffice> ISOs = new HashSet<>();
        internationalStudentOfficeRepository.findAll().forEach(ISOs::add);
        return ISOs;
    }

    @Override
    // Function which finds an InternationalStudentOffice class instance by ID
    public InternationalStudentOffice findById(Long aLong) {
        return internationalStudentOfficeRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves an InternationalStudentOffice class instance to the system
    public InternationalStudentOffice save(InternationalStudentOffice object) {
        return internationalStudentOfficeRepository.save(object);
    }

    @Override
    // Function which deletes an InternationalStudentOffice class instance from the system
    public void delete(InternationalStudentOffice object) {
        internationalStudentOfficeRepository.delete(object);
    }

    @Override
    // Function which deletes an InternationalStudentOffice class instance from the system by ID
    public void deleteById(Long aLong) {
        internationalStudentOfficeRepository.deleteById(aLong);
    }

    @Override
    // Function which finds an InternationalStudentOffice class instance by email
    public BaseEntity findByEmail(String email) {
        return internationalStudentOfficeRepository.findByMail(email);
    }
}
