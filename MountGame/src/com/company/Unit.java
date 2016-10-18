package com.company;

public abstract class Unit {
    private String name;    
    private ActionType actionType;
    
    public Unit(String name, ActionType actionType){
        this.name = name;        
        this.actionType = actionType;
    }        
    public String getName(){
        return name;
    }    
    public ActionType getAction(){
        return actionType;
    }
    @Override
    public String toString(){
        String shout = getName() + " " + actionType;
        return shout;
    }
}
