/**
 * "Пропущенное домашнее задание которое по ошибке попало не в свою тему
 * а именно Домашнее задание 4 из урока к регулярным выражениям
 * Задание 4
 * Создайте поток-демон и выведите про него как можно больше информации.
 */

public class Main {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int[] mas = new int[100];
                for (int i = 0; i < mas.length; i++) {
                    mas[i] = (int) (Math.random() * 100);
                }
            }
        }, "myThread");

        System.out.println("Главным потоком является поток: " + Thread.currentThread().getName() + ", а поток: " + myThread.getName() + " является: " + (myThread.isDaemon() ? "потоком - Демоном" : "пользовательским потоком"));
        System.out.println("Установим поток: myThread в качестве Демона и просмотрим информацию о нем с момента установки setDaemon до полной отработки его метода run():");

        System.out.println("1-info: Поток: " + myThread.getName() + " является: " + (myThread.isDaemon() ? "потоком - Демоном" : "пользовательским потоком") +
                ", сейчас он: " + (myThread.isAlive() ? "жив!" : "мёртв!") + ", его статус: " + myThread.getState().name() + ", приоритет=" + myThread.getPriority() + ", Id=" + myThread.getId());

        myThread.setDaemon(true);

        System.out.println("2-info: Поток: " + myThread.getName() + " является: " + (myThread.isDaemon() ? "потоком - Демоном" : "пользовательским потоком") +
                ", сейчас он: " + (myThread.isAlive() ? "жив!" : "мёртв!") + ", его статус: " + myThread.getState().name() + ", приоритет=" + myThread.getPriority() + ", Id=" + myThread.getId());

        myThread.start();

        System.out.println("3-info: Поток: " + myThread.getName() + " является: " + (myThread.isDaemon() ? "потоком - Демоном" : "пользовательским потоком") +
                ", сейчас он: " + (myThread.isAlive() ? "жив!" : "мёртв!") + ", его статус: " + myThread.getState().name() + ", приоритет=" + myThread.getPriority() + ", Id=" + myThread.getId());

        try {
            myThread.join();         // присоединяем главный поток в конец потока - демона, с целью увидеть его статус в конце
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("4-info: Поток: " + myThread.getName() + " является: " + (myThread.isDaemon() ? "потоком - Демоном" : "пользовательским потоком") +
                ", сейчас он: " + (myThread.isAlive() ? "жив!" : "мёртв!") + ", его статус: " + myThread.getState().name() + ", приоритет=" + myThread.getPriority() + ", Id=" + myThread.getId());
    }
}
