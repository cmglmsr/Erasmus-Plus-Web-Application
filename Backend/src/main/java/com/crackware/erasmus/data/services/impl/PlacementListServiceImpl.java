package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.PlacementList;
import com.crackware.erasmus.data.repositories.PlacementListRepository;
import com.crackware.erasmus.data.services.PlacementListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PlacementListServiceImpl implements PlacementListService {

    private final PlacementListRepository placementListRepository;


    public PlacementListServiceImpl(PlacementListRepository placementListRepository) {
        this.placementListRepository = placementListRepository;
    }

    @Override
    public Set<PlacementList> findAll() {
        HashSet<PlacementList> placementLists = new HashSet<>();
        placementListRepository.findAll().forEach(placementLists::add);
        return placementLists;
    }

    @Override
    public PlacementList findById(Long aLong) {
        return placementListRepository.findById(aLong).orElse(null);
    }

    @Override
    public PlacementList save(PlacementList object) {
        return placementListRepository.save(object);
    }

    @Override
    public void delete(PlacementList object) {
        placementListRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        placementListRepository.deleteById(aLong);
    }
}
