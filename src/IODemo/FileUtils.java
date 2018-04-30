package IODemo;

import java.io.File;
import java.io.IOException;

/**
 * Created by zkq on 2017/2/15.
 */
public class FileUtils {
    /**
     * 列出指定目录下（包括其子目录）的所有文件
     * */
    public static void listDirectory(File dir)throws IOException{
        if(!dir.exists()){//文件不存在
            throw new IllegalArgumentException("目录："+dir+"不存在");
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException("目录："+dir+"不是目录");
        }

        String[] strings = dir.list();//获取子目录下的文件夹和文件名称 字符串数组
//        for (String string:strings) {
//            System.out.println("string = " + string);
//        }
//
//        System.out.println("----------------");

        //获取文件数组
        File[] files = dir.listFiles();
        for (File file:files) {
            if(file.isDirectory()){
                //递归
                listDirectory(file);
            }else{
                System.out.println("file = " + file);
            }
        }
    }
}
