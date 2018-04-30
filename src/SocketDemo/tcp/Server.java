package SocketDemo.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zkq
 * on 2017/3/20.
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务端
 */
public class Server {
    public static void main(String[] args) {

        try {
            //1、创建一个服务端Socket，即ServerSocket指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("********服务器即将启动，等待客户端连接*********");
            //2、调用accept方法开始监听，等到客户端的连接
            Socket socket = null;
            int count = 0;
            //循环创建socket用来接收客户端请求
            for (;;){
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("当前已经连接的数量："+count+"当前客户端的ip地址："+socket.getInetAddress().getHostAddress());
            }
//            //3、获取输入流，并读取客户端信息
//            InputStream is = socket.getInputStream();//字节输入流
//            InputStreamReader inputStreamReader = new InputStreamReader(is);//将字节流转换为字符流
//            BufferedReader br = new BufferedReader(inputStreamReader);//为字符输入流添加缓冲
//            String info = null;
//            while ((info = br.readLine())!=null){
//                System.out.println("我是服务器，客户端传递的信息是："+info);
//            }
//            socket.shutdownInput();//停止读取输入流
//            //4、获取输出流，响应客户端的请求
//            OutputStream outputStream = socket.getOutputStream();
//            PrintWriter printWriter = new PrintWriter(outputStream);
//            printWriter.write("欢迎登陆系统");
//            printWriter.flush();
//            //5、关闭相关资源
//            printWriter.close();
//            outputStream.close();
//            br.close();//关闭缓冲
//            inputStreamReader.close();//关闭字符流
//            is.close();//关闭字节流
//            socket.close();//关闭socket资源
//            serverSocket.close();//关闭服务端连接
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
