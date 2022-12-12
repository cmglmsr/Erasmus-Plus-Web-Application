package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Coordinator;
import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.repositories.CoordinatorRepository;
import com.crackware.erasmus.data.services.CoordinatorService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CoordinatorServiceImpl implements CoordinatorService {

    private final CoordinatorRepository coordinatorRepository;

    public CoordinatorServiceImpl(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
        Coordinator student = new Coordinator();
        student.setName("ASLI FUCKING KARAMAN");
        student.setDepartment(Department.CS);
        coordinatorRepository.save(student);
    }

    @Override
    public Set<Coordinator> findAll() {
        HashSet<Coordinator> coordinators = new HashSet<>();
        coordinatorRepository.findAll().forEach(coordinators::add);
        return coordinators;
    }

    @Override
    public Coordinator findById(Long aLong) {
        return coordinatorRepository.findById(aLong).orElse(null);
    }

    @Override
    public Coordinator save(Coordinator object) {
        return coordinatorRepository.save(object);
    }

    @Override
    public void delete(Coordinator object) {
        coordinatorRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        coordinatorRepository.deleteById(aLong);
    }
}
