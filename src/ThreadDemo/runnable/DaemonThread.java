package ThreadDemo.runnable;

import java.io.*;

/**
 * Created by zkq on 2017/2/13.
 */
public class DaemonThread implements Runnable {
    @Override
    public void run() {
        System.out.println("进入守护线程"+Thread.currentThread().getName());
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("退出守护线程"+Thread.currentThread().getName());

    }

    private void writeToFile() throws IOException, InterruptedException {
        File filename = new File("/Users/meizu/Desktop/java/threadDemo/file","daemon.txt");
        OutputStream outputStream = new FileOutputStream(filename,true);
        int count = 0;
        while(count<999){
            outputStream.write(("\r\nword"+count).getBytes());
            System.out.println("守护线程"+Thread.currentThread().getName()+"向文件中写入了word"+(count++));
            Thread.sleep(1000);
        }
    }
}
