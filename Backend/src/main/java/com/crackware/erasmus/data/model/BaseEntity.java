package com.crackware.erasmus.data.model;


import com.crackware.erasmus.data.model.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;


@Getter
@Setter
@MappedSuperclass
public class BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Role role;

    private String name;

    private String surname;

    private String mail;

    @JsonIgnore
    private String password;

    private String dateOfBirth;

}
