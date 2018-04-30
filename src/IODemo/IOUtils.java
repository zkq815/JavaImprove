package IODemo;

import java.io.*;

/**
 * Created by zkq on 2017/2/16.
 */
public class IOUtils {

    /**
     * fileinputstream
     * 读取指定文件内容，按照16进制输出到控制台
     * 并且每输出10个byte换行
     * */

    public static void printHex(String filePath){
        int b = 0;
        int i = 0;
        FileInputStream in = null;
        try{
            in = new FileInputStream(filePath);
            while ((b=in.read())!=-1){

                if(b<=0xf)//单个数前面补0
                    System.out.print("0");

                System.out.print(Integer.toHexString(b)+" ");
                i++;
                if((i% 9) ==0)
                    System.out.println();
            }
        }catch (IOException e){

        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * fileinputstream
     * 读取指定文件内容，按照16进制输出到控制台
     * 并且每输出10个byte换行
     * */
    public static void printHexByByteArray(String filePath){
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            byte[] buf = new byte[20 * 1024];//开辟的空间越大，越占用内存
            //从输入流中读取字节，放入到buf这个数组中，从第0个位置开始放，最多放buf.length个，返回的是读到的字节个数
//            int bytes = inputStream.read(buf,0,buf.length);//一次性读完，说明字节数组足够大
            int j = 1;
//            for (int i = 0; i < bytes; i++) {
//                if(buf[i]<=0xf)
//                    System.out.print("0");
//                System.out.print(buf[i] + " ");
//                j++;
//                if(j%10 ==0)
//                    System.out.println();
//            }

            int bytes = 0;
            while ((bytes = inputStream.read(buf,0,buf.length))!=-1){
                for (int i = 0; i < bytes; i++) {
                    if(buf[i]<=0xf)
                        System.out.print("0");
                    //byte类型为8位，int类型为32位，为了避免数据转换错误，通过&0xff将高24位清零
                    System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
                    j++;
                    if(j%10 ==0)
                        System.out.println();
                }
            }



        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * fileoutputstream
     * */
    public static void outputStream(String filePath){
        FileOutputStream fileOutputStream = null;
        try{
            //如果该文件不存在，则直接创建，如果该文件存在，则删除后创建
            fileOutputStream = new FileOutputStream(filePath);
            //如果该文件不存在，则直接创建，如果该文件存在，则在文件后追加内容
//            fileOutputStream = new FileOutputStream(filePath,true);

            fileOutputStream.write('a');//写出了'a'的低8位
            fileOutputStream.write('b');//写出了'b'的低8位
            int a = 10;//write只能写8位，那么写一个int需要4次写出，每次写8位
            fileOutputStream.write(a >>>24);
            fileOutputStream.write(a >>>16);
            fileOutputStream.write(a >>>8);
            fileOutputStream.write(a);

            byte[] gbk = "中国".getBytes("gbk");
            fileOutputStream.write(gbk);
            printHex(filePath);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 复制文件
     * */
    public static void copyFile(String basePath,String targetPath){
        File baseFile = new File(basePath);
        File targetFile = new File(targetPath);
        if(!baseFile.exists()){
            throw new IllegalArgumentException("文件"+ baseFile +"不存在");
        }

        if(!baseFile.isFile()){
            throw new IllegalArgumentException("文件"+ baseFile +"不是文件");
        }

        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(baseFile);
            out = new FileOutputStream(targetPath);

            byte[] bytes = new byte[8 * 1024];
            int b = 0;
            while((b=in.read(bytes,0,bytes.length))!=-1){
                out.write(bytes,0,b);
                out.flush();
            }



        }catch (IOException E){

        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 复制文件
     * 使用BufferedOutputStream  BufferedInputStream
     * */
    public static void copyFileByBuffered(String basePath,String targetPath){
        File baseFile = new File(basePath);
        File targetFile = new File(targetPath);
        if(!baseFile.exists()){
            throw new IllegalArgumentException("文件"+baseFile+"不存在");
        }

        if(!baseFile.isFile()){
            throw new IllegalArgumentException("文件"+baseFile+"不是文件");
        }
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            bis = new BufferedInputStream(new FileInputStream(baseFile));
            bos = new BufferedOutputStream(new FileOutputStream(targetFile));
            byte[] bytes = new byte[8*1024];
            int b = 0;
            while ((b=bis.read(bytes,0,bytes.length))!=-1){
                bos.write(bytes,0,b);
                bos.flush();//刷新缓冲区
            }
        }catch (IOException e){

        }finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
