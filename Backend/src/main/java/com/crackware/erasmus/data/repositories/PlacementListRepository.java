package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ApplicationList;
import com.crackware.erasmus.data.model.PlacementList;
import org.springframework.data.repository.CrudRepository;

public interface PlacementListRepository extends CrudRepository<PlacementList,Long> {
}
