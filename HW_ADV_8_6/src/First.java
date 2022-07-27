public class First {
    private int value1;
    private int value2;

    public First(int value1, int value2) {
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
