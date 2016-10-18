package com.company;

public class Wolf <T extends Unit> extends Mount {
   public Wolf(T rider, ActionType actionType){
        super("Wolf", rider, actionType);
    }    
}
