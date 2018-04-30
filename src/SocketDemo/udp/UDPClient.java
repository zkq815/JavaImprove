package SocketDemo.udp;

import java.io.IOException;
import java.net.*;

/**
 * @Author: zkq
 * @Date: 2017/3/20 下午4:34
 * @Modified By:
 * @Description: UDP编程客户端
 */
public class UDPClient {
    public static void main(String[] args) {
        try {
            //1、定义服务器的地址、端口号、数据
            InetAddress inetAddress = InetAddress.getByName("localhost");
            int port = 9998;
            byte[] data = "用户名：admin；密码：1234".getBytes();
            //2、创建数据报，包含发送的数据信息
            DatagramPacket datagramPacket = new DatagramPacket(data,data.length,inetAddress,port);
            //3、创建DatagramSocket对象
            DatagramSocket datagramSocket = new DatagramSocket();
            //4、向服务器发送数据报
            datagramSocket.send(datagramPacket);

            /**
             * 接收服务器响应的数据
             * */
            //1、创建数据报，用于接收服务器端响应的数据
            byte[] dataFromServer = new byte[1024];
            DatagramPacket datagramPacketFromServer = new DatagramPacket(dataFromServer,dataFromServer.length);
            //2、接收服务器响应的数据
            datagramSocket.receive(datagramPacketFromServer);
            //3、读取数据
            String result = new String(dataFromServer,0,dataFromServer.length);
            System.out.println("客户端收到的消息：服务端的响应为："+result);
            datagramSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
