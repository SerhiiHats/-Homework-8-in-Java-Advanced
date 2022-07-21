/**
 * Домашнее задание 8
 * Задание 3
 * Демонстрация приоритетов. Создать 2 класса PriorityRunner и PriorityThread.
 * Запустить 3 потока с приоритетами (min, max, norm).
 * При помощи цикла for выведем на экран значения от 1 до 50 и укажем, какой именно поток данную операцию делает.
 */

public class PriorityThread {
    public static void main(String[] args) {
    Thread threadMinPriority = new Thread(new PriorityRunner(), "thread min priority");
    Thread threadNormPriority = new Thread(new PriorityRunner(), "thread norm priority");
    Thread threadMaxPriority = new Thread(new PriorityRunner(), "thread max priority");

    threadMinPriority.setPriority(1);
    threadNormPriority.setPriority(5);
    threadMaxPriority.setPriority(10);

    threadMinPriority.start();
    threadNormPriority.start();
    threadMaxPriority.start();

    }
}
