package models;

import color.Color;

public class B implements Runnable {
    String name = "2 класс";
    String BLUE = Color.BLUE;
    String DEFAULT = Color.DEFAULT;

    Sinhronizator sinhronizator;

    public B(Sinhronizator sinhronizator) {
        this.sinhronizator = sinhronizator;
    }

    public void print() {
        for (int i = 1; i <= 20; i++) {
            sinhronizator.sinchronizatorB(BLUE + name + DEFAULT + " напечатался " + i + "-й раз");
        }
    }

    @Override
    public void run() {
        print();
    }
}
