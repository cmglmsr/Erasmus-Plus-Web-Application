package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.DepartmentQuota;
import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.repositories.DepartmentQuotaRepository;
import com.crackware.erasmus.data.services.DepartmentQuotaService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of DepartmentQuotaService interface
 */
public class DepartmentQuotaServiceImpl implements DepartmentQuotaService {

    private final DepartmentQuotaRepository departmentQuotaRepository;
    // Constructor for DepartmentQuotaServiceImpl class
    public DepartmentQuotaServiceImpl(DepartmentQuotaRepository departmentQuotaRepository) {
        this.departmentQuotaRepository = departmentQuotaRepository;
    }

    @Override
    // Function which finds all CourseList instances by ID
    public Set<DepartmentQuota> findAll() {
        HashSet<DepartmentQuota> departmentQuotas = new HashSet<>();
        departmentQuotaRepository.findAll().forEach(departmentQuotas::add);
        return departmentQuotas;
    }

    @Override
    // Function which finds a DepartmentQuota class instance by ID
    public DepartmentQuota findById(Long aLong) {
        return departmentQuotaRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a DepartmentQuota class instance to the system
    public DepartmentQuota save(DepartmentQuota object) {
        return departmentQuotaRepository.save(object);
    }

    @Override
    // Function which deletes a DepartmentQuota class instance from the system
    public void delete(DepartmentQuota object) {
        departmentQuotaRepository.delete(object);
    }

    @Override
    // Function which deletes a DepartmentQuota class instance from the system by ID
    public void deleteById(Long aLong) {
        departmentQuotaRepository.deleteById(aLong);
    }

    @Override
    // Function which deletes all DepartmentQuota class instances from the system
    public void deleteAll() {
        departmentQuotaRepository.deleteAll();
    }
}
