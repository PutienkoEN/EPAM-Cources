package com.company;

public class Main {

    public static void main(String[] args) {
        Archer arch = new Archer(ActionType.attacking);
        Horse horse = new Horse<Archer>(arch, ActionType.standing);
        Wolf wolf = new Wolf<Horse>(horse, ActionType.moving);

        String message = wolf.toString() + "!";
        System.out.println(message);
    }
}
