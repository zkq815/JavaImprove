package SocketDemo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author: zkq
 * @Date: 2017/3/20 下午4:23
 * @Modified By:
 * @Description: UDP编程服务端
 */
public class UDPServer {
    public static void main(String[] args) {
        try {
            //1、创建服务端DatagramSocket，指定端口
            DatagramSocket datagramSocket = new DatagramSocket(9998);
            System.out.println("********服务器即将启动，等待客户端连接*********");
            //2、创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[1024];//创建字节数组，指定接收的数据包的大小
            DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
            //3、接收客户端发送的数据
            datagramSocket.receive(datagramPacket);//此方法在收到数据报之前会一直阻塞
            //4、读取数据
            String info = new String(data,0,data.length);
            System.out.println("服务端收到的信息："+info);
            /**
             * 响应给客户端的数据
             * */
            //1、定义客户端的地址、端口号、数据
            InetAddress inetAddress = datagramPacket.getAddress();
            int port = datagramPacket.getPort();
            byte[] data2Client = "welcome to visit".getBytes();
            //2、创建数据报，包含响应的数据信息
            DatagramPacket datagramPacket2Client = new DatagramPacket(data2Client,data2Client.length,inetAddress,port);
            //3、响应客户端
            datagramSocket.send(datagramPacket2Client);
            //4、关闭资源
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
