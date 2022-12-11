package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.ApplicationList;
import com.crackware.erasmus.data.repositories.ApplicationListRepository;
import com.crackware.erasmus.data.services.ApplicationListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ApplicationListServiceImpl implements ApplicationListService {

    private final ApplicationListRepository applicationListRepository;

    public ApplicationListServiceImpl(ApplicationListRepository applicationListRepository) {
        this.applicationListRepository = applicationListRepository;
    }

    @Override
    public Set<ApplicationList> findAll() {
        HashSet<ApplicationList> applicationLists = new HashSet<>();
        applicationListRepository.findAll().forEach(applicationLists::add);
        return applicationLists;
    }

    @Override
    public ApplicationList findById(Long aLong) {
        return applicationListRepository.findById(aLong).orElse(null);
    }

    @Override
    public ApplicationList save(ApplicationList object) {
        return applicationListRepository.save(object);
    }

    @Override
    public void delete(ApplicationList object) {
        applicationListRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        applicationListRepository.deleteById(aLong);
    }
}
