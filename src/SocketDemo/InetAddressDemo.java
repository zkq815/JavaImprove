package SocketDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by zkq on 2017/3/17.
 */
public class InetAddressDemo {
    public void inetAddressDemo(){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("计算机名称=="+inetAddress.getHostName());
            System.out.println("ip地址=="+inetAddress.getHostAddress());
            byte[] bytes = inetAddress.getAddress();
            System.out.println("字节数组形式的ip=="+ Arrays.toString(bytes));
            System.out.println(inetAddress);

            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println("计算机名称=="+inetAddress1.getHostName());
            System.out.println("ip地址=="+inetAddress1.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
