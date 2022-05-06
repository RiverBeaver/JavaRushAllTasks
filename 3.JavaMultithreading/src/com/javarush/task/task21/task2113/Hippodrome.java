package com.javarush.task.task21.task2113;

import java.util.List;
import java.util.ArrayList;


public class Hippodrome {

    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > winner.getDistance()) winner = horse;
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName()+ "!");
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<> ();
        horses.add(new Horse("Василий", 3.0, 0.0));
        horses.add(new Horse("Константин", 3.0, 0.0));
        horses.add(new Horse("Фёдор", 3.0, 0.0));

        Hippodrome.game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }

}