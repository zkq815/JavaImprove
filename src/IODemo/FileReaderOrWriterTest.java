package IODemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zkq on 2017/2/16.
 */
public class FileReaderOrWriterTest {

    /**
     * 使用这种方式，要确定编码格式保持一致，因为无法指定编码格式，如果源文件编码格式与项目编码格式不同，则会造成乱码
     * */
    public static void readOrWriterTest(String basePtah,String targetPath){
        FileReader fr = null;
        FileWriter fw = null;

        try{
            fr = new FileReader(basePtah);
            fw = new FileWriter(targetPath);//将文件覆盖
//            fw = new FileWriter(targetPath,true);//在文件后面接着写入内容， 不覆盖之前内容

            char[] buffer = new char[2056];
            int c ;
            while ((c = fr.read(buffer,0,buffer.length))!=-1){
                fw.write(buffer,0,c);
                fw.flush();
            }
//            fw.flush();
        }catch (IOException e){

        }finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
