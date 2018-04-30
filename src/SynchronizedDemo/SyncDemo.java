package SynchronizedDemo;

/**
 * Created by zkq on 2017/2/21.
 */
public class SyncDemo {

    private boolean ready = false;
    private int result = 0;
    private int number = 1;

    public synchronized void write(){
        ready = true;
        number = 2;
    }


    public synchronized void read(){
        if(ready){
            result = number*3;
        }
        System.out.println("result的值为： = " + result);
    }

   public class ReadWriteThread extends Thread{
        private boolean flag;

        public ReadWriteThread(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if(flag){
                write();
            }else {
                read();
            }
        }
    }

}

