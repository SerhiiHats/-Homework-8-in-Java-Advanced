package models;

import color.Color;

import java.util.Queue;

public class A implements Runnable {
    String name = "1 класс";
    String YELLOW = Color.YELLOW;
    String DEFAULT = Color.DEFAULT;


    public synchronized void print() {
        for (int i = 0; i < 20; i++) {
            System.out.println(YELLOW + name + DEFAULT);
        }
    }

    @Override
    public void run() {
        print();
    }
}
