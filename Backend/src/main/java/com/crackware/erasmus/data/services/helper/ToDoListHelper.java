package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.ToDoListItem;
import com.crackware.erasmus.data.security.requests.ToDoRequest;

public class ToDoListHelper {

    public static ToDoListItem toDoListHelp(ToDoRequest toDoRequest){
        ToDoListItem toDoListItem = new ToDoListItem();
        toDoListItem.setDescription(toDoRequest.getDescription());
        toDoListItem.setDueDate(toDoRequest.getDueDate());
        toDoListItem.setDone(toDoRequest.isDone());
        return toDoListItem;
    }

}
