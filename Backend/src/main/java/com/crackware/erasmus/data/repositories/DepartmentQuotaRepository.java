package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.DepartmentQuota;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for DepartmentQuota class
 */
public interface DepartmentQuotaRepository extends CrudRepository<DepartmentQuota, Long> {
    @Override
    void deleteAll();
}
