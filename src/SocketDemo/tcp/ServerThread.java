package SocketDemo.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by zkq
 * on 2017/3/20.
 * 服务器线程处理类
 */
public class ServerThread extends Thread {
    //和本线程相关的Socket
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
//        super.run();

        InputStream is = null;//字节输入流
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            //获取输入流，并读取客户端信息
            is = socket.getInputStream();//获取字节输入流
            inputStreamReader = new InputStreamReader(is);//将字节流转换为字符流
            br = new BufferedReader(inputStreamReader);//为字符输入流添加缓冲
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端传递的信息是：" + info);
            }
            socket.shutdownInput();//停止读取输入流
            //获取输出流，响应客户端的请求
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎登陆系统");
            printWriter.flush();
            //关闭相关资源
//            printWriter.close();//关闭打印流
//            outputStream.close();//关闭输出流
//            br.close();//关闭缓冲
//            inputStreamReader.close();//关闭字符流
//            is.close();//关闭字节流
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (printWriter != null)
                    printWriter.close();//关闭打印流
                if (outputStream != null)
                    outputStream.close();//关闭输出流
                if (br != null)
                    br.close();//关闭缓冲
                if (inputStreamReader != null)
                    inputStreamReader.close();//关闭字符流
                if (is != null)
                    is.close();//关闭字节流
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
