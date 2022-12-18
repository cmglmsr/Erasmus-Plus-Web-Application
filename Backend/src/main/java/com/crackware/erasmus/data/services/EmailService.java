package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.BaseEntity;
/**
 * Interface which acts as a service for BaseEntity email attribute
 */
public interface EmailService {
    // Function which finds a BaseEntity class instance by entity
    public BaseEntity findByEmail(String email);
}
