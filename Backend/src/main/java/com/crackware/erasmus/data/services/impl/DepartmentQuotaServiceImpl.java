package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.DepartmentQuota;
import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.repositories.DepartmentQuotaRepository;
import com.crackware.erasmus.data.services.DepartmentQuotaService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DepartmentQuotaServiceImpl implements DepartmentQuotaService {

    private final DepartmentQuotaRepository departmentQuotaRepository;

    public DepartmentQuotaServiceImpl(DepartmentQuotaRepository departmentQuotaRepository) {
        this.departmentQuotaRepository = departmentQuotaRepository;
    }

    @Override
    public Set<DepartmentQuota> findAll() {
        HashSet<DepartmentQuota> departmentQuotas = new HashSet<>();
        departmentQuotaRepository.findAll().forEach(departmentQuotas::add);
        return departmentQuotas;
    }

    @Override
    public DepartmentQuota findById(Long aLong) {
        return departmentQuotaRepository.findById(aLong).orElse(null);
    }

    @Override
    public DepartmentQuota save(DepartmentQuota object) {
        return departmentQuotaRepository.save(object);
    }

    @Override
    public void delete(DepartmentQuota object) {
        departmentQuotaRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        departmentQuotaRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        departmentQuotaRepository.deleteAll();
    }
}
