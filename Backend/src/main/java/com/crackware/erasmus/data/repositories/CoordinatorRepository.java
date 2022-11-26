package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.Coordinator;
import com.crackware.erasmus.data.model.Language;
import org.springframework.data.repository.CrudRepository;

public interface CoordinatorRepository extends CrudRepository<Coordinator, Long> {
}
