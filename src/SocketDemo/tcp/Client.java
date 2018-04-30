package SocketDemo.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by zkq
 * on 2017/3/20.
 * 基于TCP协议的Socket通信，实现用户登录
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1、创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("localhost",9999);
            //2、获取字节输出流，向服务端发送信息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);//将字节输出流包装为打印流
            printWriter.write("用户名：admin；密码：12345");//写入信息
            printWriter.flush();
            socket.shutdownOutput();
            //3、获取服务端响应
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while((info = bufferedReader.readLine())!=null){
                System.out.println("服务端返回信息："+info);
            }

            //4、关闭相关资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
