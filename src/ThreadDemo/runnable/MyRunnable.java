package ThreadDemo.runnable;

/**
 * Created by zkq on 2017/2/13.
 */
public class MyRunnable implements Runnable {

    private int ticketsCount = 5;
    private String name;
    @Override
    public void run() {
        synchronized(this) {
            while (ticketsCount > 0) {
                ticketsCount--;
                System.out.println(Thread.currentThread().getName() + " 卖了1张票，剩余票数为：" + ticketsCount);
            }
        }
    }
}
