package com.company;

public abstract class Mount <T> extends Unit {
    T rider;
    public Mount(String name, T rider, ActionType actionType){
        super(name, actionType);
        this.rider = rider;
    }
    
    @Override
    public String toString (){
        String shout = rider.toString() + " on " + getName() + " wich "+ getAction();       
        return shout;
    }

}
