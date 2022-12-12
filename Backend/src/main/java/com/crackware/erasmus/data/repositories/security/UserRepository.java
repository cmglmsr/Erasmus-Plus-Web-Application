package com.crackware.erasmus.data.repositories.security;

import com.crackware.erasmus.data.model.BaseEntity;
import com.crackware.erasmus.data.model.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
