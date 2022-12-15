package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.School;

public interface SchoolService extends CrudService<School, Long>{
    public void deleteAll();
}
