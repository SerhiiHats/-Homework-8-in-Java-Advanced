package models;

import color.Color;


public class A implements Runnable {
    String name = "1 класс";
    String YELLOW = Color.YELLOW;
    String DEFAULT = Color.DEFAULT;

    Sinhronizator sinhronizator;

    public A(Sinhronizator sinhronizator) {
        this.sinhronizator = sinhronizator;
    }

    public void print() {
        for (int i = 1; i <= 20; i++) {
            sinhronizator.sinchronizatorA(YELLOW + name + DEFAULT + " напечатался " + i + "-й раз");
        }
    }

    @Override
    public void run() {
        print();
    }
}
