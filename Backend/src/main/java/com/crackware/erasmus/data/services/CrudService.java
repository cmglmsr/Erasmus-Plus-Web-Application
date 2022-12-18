package com.crackware.erasmus.data.services;

import java.util.Set;
/**
 * Interface which acts as a service for CrudService class
 */
public interface CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
