/**
 * Домашнее задание 8
 * Задание 2
 * Задержка потока. Необходимо создать 3 потока, каждых из этих потоков запустить (например: main, second, first),
 * и когда эти потоки успешно отработают – вывести на экран сообщение (завершение потом first, second и main).
 *
 * ЗАДЕРЖИВАТЬ ПОТОКИ МОЖНО ПО - РАЗНОМУ, РЕАЛИЗУЕМ НЕСКОЛЬКО ВАРИАНТОВ
 */

//third option
public class Main_3_option {
    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ".repeat(Math.max(0, (8 - Thread.currentThread().getName().length())))
                        + " : отработал, за " + (System.currentTimeMillis() - timeStart) + " мл.сек.");
            }
        }, "first");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ".repeat(Math.max(0, (8 - Thread.currentThread().getName().length())))
                        + " : отработал, за " + (System.currentTimeMillis() - timeStart) + " мл.сек.");
            }
        }, "second");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ".repeat(Math.max(0, (8 - Thread.currentThread().getName().length())))
                        + " : отработал, за " + (System.currentTimeMillis() - timeStart) + " мл.сек.");
            }
        }, "main");

        thread0.setPriority(10);
        thread1.setPriority(5);
        thread2.setPriority(1);

        thread0.start();
        thread1.start();
        thread2.start();
        System.out.println("завершение");

    }
}
