package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.List;
import com.crackware.erasmus.data.repositories.ListRepository;
import com.crackware.erasmus.data.services.ListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ListServiceImpl implements ListService {

    private final ListRepository listRepository;


    public ListServiceImpl(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public Set<List> findAll() {
        HashSet<List> lists = new HashSet<>();
        listRepository.findAll().forEach(lists::add);
        return lists;
    }

    @Override
    public List findById(Long aLong) {
        return listRepository.findById(aLong).orElse(null);
    }

    @Override
    public List save(List object) {
        return listRepository.save(object);
    }

    @Override
    public void delete(List object) {
        listRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        listRepository.deleteById(aLong);
    }
}
