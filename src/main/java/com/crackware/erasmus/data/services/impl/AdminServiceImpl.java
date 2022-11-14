package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.repositories.AdminRepository;
import com.crackware.erasmus.data.services.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
}
