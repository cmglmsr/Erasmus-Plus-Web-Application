package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.BaseEntity;

public interface EmailService {
    public BaseEntity findByEmail(String email);
}
