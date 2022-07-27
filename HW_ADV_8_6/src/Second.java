public class Second {
    private int number1;
    private int number2;

    public Second(int number1, int number2) {
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