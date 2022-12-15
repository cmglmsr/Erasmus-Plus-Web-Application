package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.Schedule;
import com.crackware.erasmus.data.model.ToDoList;
import com.crackware.erasmus.data.security.requests.ToDoRequest;

public class ToDoListHelper {

    public static ToDoList toDoListHelp(ToDoRequest toDoRequest){
        ToDoList toDoList = new ToDoList();
        toDoList.setDescription(toDoRequest.getDescription());
        toDoList.setDueDate(toDoRequest.getDueDate());
        toDoList.setDone(toDoRequest.isDone());
        return toDoList;
    }

}
