package ThreadDemo.movie;

/**
 * Created by zkq on 2017/2/13.
 */
public class ArmyRunnable implements Runnable {
    //volatile保证了线程可以正确的读取其他线程写入的值
    //可见性问题  ref jvm
    volatile boolean keepRunning = true;
    @Override
    public void run() {

        while(keepRunning){
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
                Thread.yield();//让出cup处理时间
            }
        }

        System.out.println(Thread.currentThread().getName()+"结束战斗！");
    }
}
