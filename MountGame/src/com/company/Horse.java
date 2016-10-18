package com.company;

public class Horse <T extends Unit> extends Mount {    
    public Horse(T rider, ActionType actionType){
        super("Horse", rider, actionType);
    }    
}
