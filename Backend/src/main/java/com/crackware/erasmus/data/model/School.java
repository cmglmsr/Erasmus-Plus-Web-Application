package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DepartmentQuota> departmentQuotas;

    // might delete ?
    @OneToMany
    @OrderBy("points DESC")
    private Set<Application> applications;

    private String name;

    public void addDepartmentQuota(DepartmentQuota departmentQuota){
        if (!departmentQuotas.contains(departmentQuota)){
            departmentQuotas.add(departmentQuota);
        }
    }

}
