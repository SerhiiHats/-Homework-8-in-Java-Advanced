import color.Color;

public class PriorityRunner implements Runnable {
    final String G$ = Color.GREEN;
    final String Y$ = Color.YELLOW;
    final String B$ = Color.BLUE;
    final String D$ = Color.DEFAULT;

    @Override
    public void run() {

        for (int i = 1; i <= 50; i++) {
            System.out.println(i + " it does : " + (Thread.currentThread().getName().equals("thread max priority") ? G$ : Thread.currentThread().getName().equals("thread norm priority") ? Y$ : B$)
                    + Thread.currentThread().getName() + D$);
        }
    }
}
