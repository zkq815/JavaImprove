package ThreadDemo;


import ThreadDemo.movie.Stage;
import ThreadDemo.runnable.DaemonThread;
import ThreadDemo.runnable.MyRunnable;

import java.util.Scanner;

/**
 * Created by zkq on 2017/2/13.
 */
public class main {
    public static void main(String[] args){
        fighting();
    }

    //打仗
    private static void fighting(){
        new Stage().start();
    }

    //守护线程
    private static void daemonTest(){
        System.out.println("进入主线程"+Thread.currentThread().getName());
        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);
        thread.setDaemon(true);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("退出主线程"+Thread.currentThread().getName());
    }

    //卖票
    private static void sellTickets(){
        //实现runnable
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable,"窗口1");
        Thread thread2 = new Thread(myRunnable,"窗口2");
        Thread thread3 = new Thread(myRunnable,"窗口3");

        //继承thread
//        MyThread thread1 = new MyThread("窗口1");
//        MyThread thread2 = new MyThread("窗口2");
//        MyThread thread3 = new MyThread("窗口3");
//
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
