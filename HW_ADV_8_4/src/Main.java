import models.A;
import models.B;

/**
 * Домашнее задание 8
 * Задание 4
 * Создать 2 произвольных класса с полями и методами.
 * Необходимо синхронизировать методы этих классов между собой,
 * т.е. чтобы выводило на экран значения друг за другом (1 класс, 2 класс, 1, 2 и т.д.).
 */


public class Main {
    public static void main(String[] args) {
       Thread thread0 = new Thread(new A());
       Thread thread1 = new Thread(new B());

       thread0.start();
       thread1.start();
    }
}
