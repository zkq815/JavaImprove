package SynchronizedDemo;

/**
 * Created by zkq on 2017/2/21.
 */
public class Main {
    public static void main(String[] args) {
//        syncTest();
        volatileTest();
    }


    /**
     * 同步测试代码
     */
    public static void syncTest() {
        SyncDemo syncDemo = new SyncDemo();
        syncDemo.new ReadWriteThread(true).start();
        syncDemo.new ReadWriteThread(false).start();
    }

    /**
     * 可见性测试
     */
    public static void volatileTest(){
        final VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 500 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volatileDemo.increaseWithSync();
                    System.out.println("volatileDemo = " + volatileDemo.getNumber());
                }
            }).start();
        }
        //如果还有自线程在运行，主线程就让出cpu资源，
        //直到所有自线程都运行完了，主线程再继续往下执行
        while (Thread.activeCount()>1){
            Thread.yield();
        }

        System.out.println("volatileDemo = " + volatileDemo.getNumber());
    }
}
