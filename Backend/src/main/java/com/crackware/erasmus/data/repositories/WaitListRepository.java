package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.ApplicationList;
import com.crackware.erasmus.data.model.WaitList;
import org.springframework.data.repository.CrudRepository;

public interface WaitListRepository extends CrudRepository<WaitList,Long> {
}
