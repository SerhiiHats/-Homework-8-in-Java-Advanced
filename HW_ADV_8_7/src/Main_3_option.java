/**
 * Домашнее задание 8
 * Задание 7
 * Изменить задание №6. Всеми возможными способами (которые Вы знаете) решить проблему взаимной блокировки.
 **/

/**
 * Уберем синхронизацию по объектам которые захватывают мониторы и блокируют друг друга
 */

public class Main_3_option {
    public static void main(String[] args) {
        First3 first = new First3(15, 3);
        Second3 second = new Second3(7, 2);
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (first) {
                    first.devNumber();
                        second.sumNumber();

                }
            }
        }, "thread5");
        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (second) {
                    second.sumNumber();
                        first.devNumber();
                }

            }
        }, "thread6");

        thread5.start();
        thread6.start();

        System.out.println("\tПоток thread5 стартовал, сейчас он: " + (thread5.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread5.getState().name());
        System.out.println("\tПоток thread6 стартовал, сейчас он: " + (thread6.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread6.getState().name());

        while (thread5.getState().name().equalsIgnoreCase("RUNNABLE") || thread6.getState().name().equalsIgnoreCase("RUNNABLE")) {
            if (!thread5.isAlive() || !thread6.isAlive()) {       // задержка потока main до состояния блока дочерних потоков
                break;                                            // с целью корректного отображения статуса дочерних потоков
            }                                                     // если какой -то поток мертв (отработал полностью) - будет выход из задержки
        }

        System.out.println("\tПоток thread5 стартовал, сейчас он: " + (thread5.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread5.getState().name());
        System.out.println("\tПоток thread6 стартовал, сейчас он: " + (thread6.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread6.getState().name());

        if (thread5.getState().name().equalsIgnoreCase("BLOCKED") && thread6.getState().name().equalsIgnoreCase("BLOCKED")) {
            System.out.println("получили: DEADLOCK т.к. thread5: " + thread5.getState().name() + " и thread6: " + thread6.getState().name() + " одновременно и ожидают взаимной разблокировки занятых ими ресурсов!");
        } else {
            System.out.println("не получен: DEADLOCK т.к. сейчас thread5: " + thread5.getState().name() + " и thread6: " + thread6.getState().name() + " и они не ожидают разблокировки друг друга!");
        }

    }
}

class First3 {
    private int value1;
    private int value2;

    public First3(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public void devNumber() {
        final String Y$ = "\u001B[33m";
        final String D$ = "\u001B[0m";
        try {
            System.out.println(Y$ + Thread.currentThread().getName() + ": отрабатывает Метод \"деления\" из класса: " + getClass().getSimpleName() + " " + value1 + " / " + value2 + " = " + (value1 / value2) + D$);
        } catch (ArithmeticException e) {
            System.out.println(Y$ + Thread.currentThread().getName() + ": отрабатывает Метод \"деления\" из класса: " + getClass().getSimpleName() + " " + value1 + " / " + value2 + " = Деление на ноль!" + D$);
        }
    }
}


class Second3 {
    private int number1;
    private int number2;

    public Second3(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void sumNumber() {
        final String B$ = "\u001B[34m";
        final String D$ = "\u001B[0m";
        System.out.println(B$ + Thread.currentThread().getName() + ": отрабатывает Метод \"суммирования\" из класса: " + getClass().getSimpleName() + " " + number1 + " + " + number2 + " = " + (number1 + number2) + D$);
    }


}


