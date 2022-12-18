package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.PlacementList;
import com.crackware.erasmus.data.repositories.PlacementListRepository;
import com.crackware.erasmus.data.services.PlacementListService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
/**
 * Class which contains implementations of PlacementListService interface
 */
public class PlacementListServiceImpl implements PlacementListService {



    private final PlacementListRepository placementListRepository;

    // Constructor for PlacementListServiceImpl class
    public PlacementListServiceImpl(PlacementListRepository placementListRepository) {
        this.placementListRepository = placementListRepository;
    }

    @Override
    // Function which finds all PlacementList instances by ID
    public Set<PlacementList> findAll() {
        HashSet<PlacementList> placementLists = new HashSet<>();
        placementListRepository.findAll().forEach(placementLists::add);
        return placementLists;
    }

    @Override
    // Function which finds a PlacementList class instance by ID
    public PlacementList findById(Long aLong) {
        return placementListRepository.findById(aLong).orElse(null);
    }

    @Override
    // Function which saves a PlacementList class instance to the system
    public PlacementList save(PlacementList object) {
        return placementListRepository.save(object);
    }

    @Override
    // Function which deletes a PlacementList class instance from the system
    public void delete(PlacementList object) {
        placementListRepository.delete(object);
    }

    @Override
    // Function which deletes a PlacementList class instance from the system by ID
    public void deleteById(Long aLong) {
        placementListRepository.deleteById(aLong);
    }

    // Function which deletes all PlacementList class instances from the system by ID
    public void deleteAll(){
        placementListRepository.deleteAll();
    }
}
