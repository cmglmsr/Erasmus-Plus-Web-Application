package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.PlacementList;
/**
 * Interface which acts as a service for PlacementList class
 */
public interface PlacementListService extends CrudService<PlacementList, Long>{
    public void deleteAll();
}
