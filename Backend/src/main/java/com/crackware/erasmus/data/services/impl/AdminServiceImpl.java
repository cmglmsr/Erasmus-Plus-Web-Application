package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Admin;
import com.crackware.erasmus.data.model.BaseEntity;
import com.crackware.erasmus.data.repositories.AdminRepository;
import com.crackware.erasmus.data.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of AdminService interface
 */
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    // Constructor for AdminServiceImpl class
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
    // Function which finds an Admin class instance by ID
    public Admin findById(Long aLong) {
        return adminRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves an Admin class instance to the system
    public Admin save(Admin object) {
        return adminRepository.save(object);
    }

    @Override
    // Function which deletes an Admin class instance from the system
    public void delete(Admin object) {
        adminRepository.delete(object);
    }

    @Override
    // Function which deletes an Admin class instance from the system by ID
    public void deleteById(Long aLong) {
        adminRepository.deleteById(aLong);
    }

    @Override
    // Function which finds an Admin class instance by email
    public BaseEntity findByEmail(String email) {
        return adminRepository.findByMail(email);
    }
}
