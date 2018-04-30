package IODemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by zkq on 2017/2/15.
 */
public class RandomAccessFileTest {

    public static void randomAccessFile() throws IOException{
        File demo = new File("demo");
        if(!demo.exists()){
            demo.mkdir();
        }
        File file = new File(demo,"raf.dat");
        if(!file.exists()){
            file.createNewFile();
        }

        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
        //指针的位置
        System.out.println("randomAccessFile.getFilePointer() = " + randomAccessFile.getFilePointer());
        randomAccessFile.write('a');//写入一个字节
        System.out.println("randomAccessFile.getFilePointer() = " + randomAccessFile.getFilePointer());
        randomAccessFile.write('b');
//        int i = 0x7fffffff;
//        //用write方法每次只能写入一个字节，如果要把i写进去就得写4次
//        randomAccessFile.write(i >>> 24);//最高的8位
//        randomAccessFile.write(i >>> 16);
//        randomAccessFile.write(i >>> 8);
//        randomAccessFile.write(i );//最低的8位

        System.out.println("randomAccessFile = " + randomAccessFile.getFilePointer());
        String s = "中";
//        byte[] bytes = s.getBytes("utf-16be");
        byte[] bytes = s.getBytes();
        randomAccessFile.write(bytes);
        System.out.println("bytes = " + bytes.length);

        //读取文件必须把指针移动到头部
        randomAccessFile.seek(0);
        //一次性读取，把文件中的内容一次性读到数组中
        byte[] buffer = new byte[(int)randomAccessFile.length()];
        randomAccessFile.read(buffer);
        System.out.println("Arrays.toString(buffer) = " + Arrays.toString(buffer));
        String string = new String(buffer);
        System.out.println("string = " + string);

        randomAccessFile.close();

    }
}
