package com.crackware.erasmus.data.repositories;

import com.crackware.erasmus.data.model.List;
import org.springframework.data.repository.CrudRepository;
/**
 * Interface which acts as a repository for List class
 */
public interface ListRepository extends CrudRepository<List,Long> {
}
