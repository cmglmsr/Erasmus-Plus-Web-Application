package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.DepartmentQuota;

public interface DepartmentQuotaService extends CrudService<DepartmentQuota, Long>{
    public void deleteAll();
}
