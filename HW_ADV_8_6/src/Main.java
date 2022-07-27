/**
 * Домашнее задание 8
 * Задание 6
 * Создать 2 класса. Реализовать взаимную блокировку(deadlock) этих классов.
 **/

public class Main {
    public static void main(String[] args) {
        First first = new First(15, 3);
        Second second = new Second(5, 2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (first) {
                    first.devNumber();
                    synchronized (second) {
                        second.sumNumber();
                    }
                }
            }
        }, "thread1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (second) {
                    second.sumNumber();
                    synchronized (first) {
                        first.devNumber();
                    }
                }

            }
        }, "thread2");

        thread1.start();
        thread2.start();

        System.out.println("\tПоток thread1 стартовал, сейчас он: " + (thread1.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread1.getState().name());
        System.out.println("\tПоток thread2 стартовал, сейчас он: " + (thread2.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread2.getState().name());

        while (thread1.getState().name().equalsIgnoreCase("RUNNABLE") || thread2.getState().name().equalsIgnoreCase("RUNNABLE")) {
            if (!thread1.isAlive() || !thread2.isAlive()) {       // задержка потока main до состояния блока дочерних потоков
                break;                                            // с целью корректного отображения статуса дочерних потоков
            }                                                     // если какой -то поток мертв (отработал полностью) - будет выход из задержки
        }

        System.out.println("\tПоток thread1 стартовал, сейчас он: " + (thread1.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread1.getState().name());
        System.out.println("\tПоток thread2 стартовал, сейчас он: " + (thread2.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread2.getState().name());

        if (thread1.getState().name().equalsIgnoreCase("BLOCKED") && thread2.getState().name().equalsIgnoreCase("BLOCKED")) {
            System.out.println("получили: DEADLOCK т.к. thread1: " + thread1.getState().name() + " и thread2: " + thread2.getState().name() + " одновременно и ожидают взаимной разблокировки занятых ими ресурсов!");
        } else {
            System.out.println("не получен: DEADLOCK т.к. thread1: " + thread1.getState().name() + " и thread2: " + thread2.getState().name() + " и они не ожидают разблокировки друг друга!");
        }
    }

}

