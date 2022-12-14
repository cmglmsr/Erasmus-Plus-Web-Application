package com.crackware.erasmus.data.repositories.security;

import com.crackware.erasmus.data.model.security.EnumRole;
import com.crackware.erasmus.data.model.security.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(EnumRole name);
}
