package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.Schedule;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;

public class ScheduleHelper {

    public static Schedule scheduleHelp(ScheduleRequest scheduleRequest){
        Schedule schedule = new Schedule();
        schedule.setDate(scheduleRequest.getDate());
        schedule.setDescription(scheduleRequest.getDescription());
        schedule.setDueDate(scheduleRequest.getDueDate());
        schedule.setDone(scheduleRequest.isDone());
        return schedule;
    }
}
