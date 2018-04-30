package ThreadDemo.thread;

/**
 * Created by zkq on 2017/2/13.
 */
public class MyThread extends Thread {
    private int ticketsCount = 5;
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (ticketsCount >0){
            ticketsCount --;
            System.out.println(name +"卖了1张票，剩余票数为："+ticketsCount);
        }
    }
}
