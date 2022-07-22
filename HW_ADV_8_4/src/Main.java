import models.A;
import models.B;
import models.Sinhronizator;

/**
 * Домашнее задание 8
 * Задание 4
 * Создать 2 произвольных класса с полями и методами.
 * Необходимо синхронизировать методы этих классов между собой,
 * т.е. чтобы выводило на экран значения друг за другом (1 класс, 2 класс, 1, 2 и т.д.).
 */


public class Main {
    public static void main(String[] args) {
        Sinhronizator sinhronizator = new Sinhronizator();
        Thread threadFirst = new Thread(new A(sinhronizator), "first");
        Thread threadSecond = new Thread(new B(sinhronizator), "second");

        threadFirst.start();
        threadSecond.start();
    }

}
