package com.crackware.erasmus.data.services.impl;

import com.crackware.erasmus.data.model.Schedule;
import com.crackware.erasmus.data.repositories.ScheduleRepository;
import com.crackware.erasmus.data.services.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    @Override
    public Set<Schedule> findAll() {
        HashSet<Schedule> schedules = new HashSet<>();
        scheduleRepository.findAll().forEach(schedules::add);
        return schedules;
    }

    @Override
    public Schedule findById(Long aLong) {
        return scheduleRepository.findById(aLong).orElse(null);
    }

    @Override
    public Schedule save(Schedule object) {
        return scheduleRepository.save(object);
    }

    @Override
    public void delete(Schedule object) {
        scheduleRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        scheduleRepository.deleteById(aLong);
    }
}
