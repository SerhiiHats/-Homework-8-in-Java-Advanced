package models;

import color.Color;

import java.util.Queue;

public class B implements Runnable {
     String name = "2 класс";
     String BLUE = Color.BLUE;
     String DEFAULT = Color.DEFAULT;

    public synchronized void print() {
        for (int i = 0; i < 20; i++) {
            System.out.println(BLUE + name + DEFAULT);
        }
    }

    @Override
    public void run() {
        print();
    }
}
