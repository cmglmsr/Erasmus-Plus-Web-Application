package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.DepartmentQuota;
/**
 * Interface which acts as a service for DepartmentQuota class
 */
public interface DepartmentQuotaService extends CrudService<DepartmentQuota, Long>{
    public void deleteAll();
}
