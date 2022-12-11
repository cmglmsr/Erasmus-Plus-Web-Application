package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Admin;
import com.crackware.erasmus.data.repositories.AdminRepository;
import com.crackware.erasmus.data.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Set<Admin> findAll() {
        HashSet<Admin> admins = new HashSet<>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }

    @Override
    public Admin findById(Long aLong) {
        return adminRepository.findById(aLong).orElse(null);
    }

    @Override
    public Admin save(Admin object) {
        return adminRepository.save(object);
    }

    @Override
    public void delete(Admin object) {
        adminRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        adminRepository.deleteById(aLong);
    }
}
