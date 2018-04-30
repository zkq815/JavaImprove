package SynchronizedDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zkq on 2017/2/21.
 */
public class VolatileDemo {
    private volatile int number = 0;
    private Lock lock = new ReentrantLock();
    public int getNumber() {
        return number;
    }

    //保证volatile 原子性  方法一

    public synchronized void increaseWithSync(){
        this.number++;
    }

    //保证volatile 原子性  方法二
    //lock功能比较强大：公平锁，读写分离锁
    public void increaseWithRenntrantlock(){
        lock.lock();
        try{
            this.number++;
        }finally {
            lock.unlock();
        }

    }
}
