/**
 * Домашнее задание 8
 * Задание 2
 * Задержка потока. Необходимо создать 3 потока, каждых из этих потоков запустить (например: main, second, first),
 * и когда эти потоки успешно отработают – вывести на экран сообщение (завершение потом first, second и main).
 *
 * ЗАДЕРЖИВАТЬ ПОТОКИ МОЖНО ПО - РАЗНОМУ, РЕАЛИЗУЕМ НЕСКОЛЬКО ВАРИАНТОВ
 */

//first option
public class Main_1_option {
    public static void main(String[] args) {
        int valueOfSleep = 100;
        long timeStart = System.currentTimeMillis();
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(valueOfSleep);
                } catch (InterruptedException e) {
                    System.out.println("поток был прекращен");
                }
                System.out.println(Thread.currentThread().getName() + " ".repeat(Math.max(0, (8 - Thread.currentThread().getName().length())))
                        + " : отработал, за " + (System.currentTimeMillis() - timeStart) + " мл.сек.");
            }
        }, "first");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(valueOfSleep * 2L);
                } catch (InterruptedException e) {
                    System.out.println("поток был прекращен");
                }
                System.out.println(Thread.currentThread().getName() + " ".repeat(Math.max(0, (8 - Thread.currentThread().getName().length())))
                        + " : отработал, за " + (System.currentTimeMillis() - timeStart) + " мл.сек.");
            }
        }, "second");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(valueOfSleep * 3L);
                } catch (InterruptedException e) {
                    System.out.println("поток был прекращен");
                }
                System.out.println(Thread.currentThread().getName() + " ".repeat(Math.max(0, (8 - Thread.currentThread().getName().length())))
                        + " : отработал, за " + (System.currentTimeMillis() - timeStart) + " мл.сек.");
            }
        }, "main");

        thread0.start();
        thread1.start();
        thread2.start();
        System.out.println("завершение");

    }
}
