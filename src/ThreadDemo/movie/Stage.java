package ThreadDemo.movie;

/**
 * Created by zkq on 2017/2/13.
 */
public class Stage extends Thread {

    @Override
    public void run() {
        //创建 资源线程
        ArmyRunnable armyRunnable1 = new ArmyRunnable();
        ArmyRunnable armyRunnable2 = new ArmyRunnable();
        //创建线程
        Thread thread1 = new Thread(armyRunnable1,"大军");
        Thread thread2 = new Thread(armyRunnable1,"农民");
        //启动线程
        thread1.start();
        thread2.start();

//

        System.out.println("猛人出场");
        Thread thread3 = new KeyPersonThread();
        thread3.setName("赵云");

        System.out.println("赵云七进七出，横扫敌军");

        armyRunnable1.keepRunning = false;
        armyRunnable2.keepRunning = false;


        //舞台线程休眠
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //赵云特写开始
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("赵云封五虎将");

    }
}
