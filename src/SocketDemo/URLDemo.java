package SocketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zkq on 2017/3/17.
 */
public class URLDemo {

    /**
     * URL类使用测试
     */
    public void urlDemoTest(){
        try {
            URL url = new URL("http://www.imooc.com");
            //？后面表示参数，#后面表示锚点
            URL newUrl = new URL(url,"index.html?username=tom#test");
            System.out.println("协议："+ url.getProtocol());
            System.out.println("主机："+ url.getHost());
            //如果未指定端口号，则使用默认的端口号，此时getPort方法返回值为-1
            System.out.println("端口："+ url.getPort());
            System.out.println("文件路径："+ url.getPath());
            System.out.println("文件名："+ url.getFile());
            System.out.println("相对路径："+ url.getRef());
            System.out.println("查询字符串："+ url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用URL读取页面内容
     */
    public void urlReadWeb(){
        try {
            URL url = new URL("http://www.baidu.com");
            //获取url对象所表示的资源的字节输入流
            InputStream inputStream = url.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            byte[] bytes = new byte[1024];
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data = bufferedReader.readLine();
            while(data!=null){
                System.out.println(data);
                data = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
