package ThreadDemo.movie;

/**
 * Created by zkq on 2017/2/13.
 */
public class KeyPersonThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始了战斗");

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]"+" 猴塞雷");
        }

        System.out.println(Thread.currentThread().getName()+"结束了战斗");
    }
}
