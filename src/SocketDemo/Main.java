package SocketDemo;

/**
 * Created by zkq on 2017/3/17.
 */
public class Main {
    public static void main(String[] args) {
//        inetAddressDemoTest();
        urlDemoTest();
    }

    private static void inetAddressDemoTest(){
        InetAddressDemo inetAddressDemo = new InetAddressDemo();
        inetAddressDemo.inetAddressDemo();
    }

    private static void urlDemoTest(){
        URLDemo urlDemo = new URLDemo();
        urlDemo.urlDemoTest();
        urlDemo.urlReadWeb();
    }
}
