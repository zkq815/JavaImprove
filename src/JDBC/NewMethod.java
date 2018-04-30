package JDBC;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by zkq on 2017/2/5.
 */
public class NewMethod {

    void test(){
        try {

            //InetAddress
            InetAddress notsb = InetAddress.getByName("www.baidu.com");
//            System.out.println("notsb = " + notsb);
//            System.out.println(" ----------------" );
//            InetAddress[] notsbs = InetAddress.getAllByName("www.baidu.com");
//            for (InetAddress notsb1: notsbs) {
//                System.out.println("notsb = " + notsb1);
//            }
//            InetAddress my = InetAddress.getLocalHost();
//            System.out.println("my = " + my);
//            byte[] bs = new byte[]{58,(byte)217,(byte)200,15};
//            InetAddress ip = InetAddress.getByAddress(bs);
//            System.out.println("ip = " + ip);
            //URL
            URL url = new URL("https://ke.qq.com/course/155221");
//            URL url = new URL("http://www.notsb.com");
//            System.out.println("主机 = " + url.getHost());
//            System.out.println("端口 = " + url.getPort());
//            System.out.println("路径 = " + url.getPath());
//            System.out.println("协议 = " + url.getProtocol());
//            System.out.println("文件名称 = " + url.getFile());
//            System.out.println("内容 = " + url.getContent());
//            InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
//            BufferedReader br = new BufferedReader(inputStreamReader);
//            String line = null;
//            while ((line=br.readLine())!=null){
//                System.out.println("line = " + line);
//            }
//            inputStreamReader.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
