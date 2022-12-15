package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.Task;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;

public class ScheduleHelper {

    public static Task scheduleHelp(ScheduleRequest scheduleRequest){
        Task task = new Task();
        task.setDate(scheduleRequest.getDate());
        task.setDescription(scheduleRequest.getDescription());
        task.setDueDate(scheduleRequest.getDueDate());
        task.setDone(scheduleRequest.isDone());
        return task;
    }
}
