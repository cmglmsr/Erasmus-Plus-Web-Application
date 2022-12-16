package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.PlacementList;

public interface PlacementListService extends CrudService<PlacementList, Long>{
    public void deleteAll();
}
