package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.Coordinator;
import com.crackware.erasmus.data.model.ToDoList;
import com.crackware.erasmus.data.model.ToDoListItem;
import com.crackware.erasmus.data.model.enums.ItemType;
import com.crackware.erasmus.data.services.CoordinatorService;
import com.crackware.erasmus.data.services.ToDoListItemService;
import com.crackware.erasmus.data.services.ToDoListService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ToDoListHelper {


    private final CoordinatorService coordinatorService;

    private final ToDoListService toDoListService;

    private final ToDoListItemService toDoListItemService;

    public ToDoListHelper(CoordinatorService coordinatorService, ToDoListService toDoListService, ToDoListItemService toDoListItemService) {
        this.coordinatorService = coordinatorService;
        this.toDoListService = toDoListService;
        this.toDoListItemService = toDoListItemService;
    }

    public void addItem(ItemType itemType, int count){
        ArrayList<ToDoListItem> toDoListItems = new ArrayList<>(toDoListItemService.findAll());
        ToDoListItem itemToChange = null;
        for(ToDoListItem item: toDoListItems){
            if (item.getItemType() == itemType){
                itemToChange = item;
            }
        }
        if (itemToChange == null){
            switch (itemType){
                case APPLICATION: {
                    ToDoListItem toDoListItem = new ToDoListItem();
                    toDoListItem.setDone(false);
                    toDoListItem.setItemType(itemType);
                    toDoListItem.setDueDate("25.02.2023");
                    toDoListItem.setDescription("there are " + count + " placements to process");
                    toDoListItemService.save(toDoListItem);
                    ArrayList<Coordinator> coordinators = new ArrayList<>(coordinatorService.findAll());
                    coordinators.get(0).getToDoList().addItem(toDoListItem);
                } break;
                case LEARNING_AGREEMENT: {
                    ToDoListItem toDoListItem = new ToDoListItem();
                    toDoListItem.setDone(false);
                    toDoListItem.setItemType(itemType);
                    toDoListItem.setDueDate("25.02.2023");
                    toDoListItem.setDescription("there are " + count + " learning agreements to process");
                    toDoListItemService.save(toDoListItem);
                    ArrayList<Coordinator> coordinators = new ArrayList<>(coordinatorService.findAll());
                    coordinators.get(0).getToDoList().addItem(toDoListItem);
                } break;
            }

        }else {
            switch (itemType){
                case APPLICATION: {
                    itemToChange.setDone(false);
                    itemToChange.setItemType(itemType);
                    itemToChange.setDueDate("25.02.2023");
                    itemToChange.setDescription("there are " + count + " placements to process");
                    toDoListItemService.save(itemToChange);
                } break;
                case LEARNING_AGREEMENT: {
                    itemToChange.setDone(false);
                    itemToChange.setItemType(itemType);
                    itemToChange.setDueDate("09.04.2023");
                    itemToChange.setDescription("there are " + count + " learning agreements to process");
                    toDoListItemService.save(itemToChange);
                } break;
            }
            ArrayList<Coordinator> coordinators = new ArrayList<>(coordinatorService.findAll());
            coordinators.get(0).getToDoList().addItem(itemToChange);
        }
        ArrayList<Coordinator> coordinators = new ArrayList<>(coordinatorService.findAll());
        toDoListService.save(coordinators.get(0).getToDoList());

    }




}
