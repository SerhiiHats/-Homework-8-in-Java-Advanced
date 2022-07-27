/**
 * Домашнее задание 8
 * Задание 7
 * Изменить задание №6. Всеми возможными способами (которые Вы знаете) решить проблему взаимной блокировки.
 **/

/**
 * С помощью метода sleep() усыпим один поток дав время отработать другому потоку и таким образом не захватить монитор до окончания работы
 */
public class Main_2_option {
    public static void main(String[] args) {
        First2 first = new First2(15, 3);
        Second2 second = new Second2(7, 2);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (first) {
                    first.devNumber();
                    synchronized (second) {
                        second.sumNumber();
                    }
                }
            }
        }, "thread3");
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (second) {
                    second.sumNumber();
                    synchronized (first) {
                        first.devNumber();
                    }
                }

            }
        }, "thread4");

        thread3.start();
        thread4.start();

        System.out.println("\tПоток thread3 стартовал, сейчас он: " + (thread3.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread3.getState().name());
        System.out.println("\tПоток thread4 стартовал, сейчас он: " + (thread4.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread4.getState().name());

        while (thread3.getState().name().equalsIgnoreCase("RUNNABLE") || thread4.getState().name().equalsIgnoreCase("RUNNABLE")) {
            if (!thread3.isAlive() || !thread4.isAlive()) {       // задержка потока main до состояния блока дочерних потоков
                break;                                            // с целью корректного отображения статуса дочерних потоков
            }                                                     // если какой -то поток мертв (отработал полностью) - будет выход из задержки
        }

        System.out.println("\tПоток thread3 стартовал, сейчас он: " + (thread3.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread3.getState().name());
        System.out.println("\tПоток thread4 стартовал, сейчас он: " + (thread4.isAlive() ? "жив!" : "умер!") + " и его статус: " + thread4.getState().name());

        if (thread3.getState().name().equalsIgnoreCase("BLOCKED") && thread4.getState().name().equalsIgnoreCase("BLOCKED")) {
            System.out.println("получили: DEADLOCK т.к. thread3: " + thread3.getState().name() + " и thread4: " + thread4.getState().name() + " одновременно и ожидают взаимной разблокировки занятых ими ресурсов!");
        } else {
            System.out.println("не получен: DEADLOCK т.к. сейчас thread3: " + thread3.getState().name() + " и thread4: " + thread4.getState().name() + " и они не ожидают разблокировки друг друга!");
        }

    }
}

class First2 {
    private int value1;
    private int value2;

    public First2(int value1, int value2) {
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


class Second2 {
    private int number1;
    private int number2;

    public Second2(int number1, int number2) {
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


