package IODemo;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by zkq on 2017/2/14.
 */
public class main {
    public static void main(String[] args){

        long start = System.currentTimeMillis();
        //        codeFormat();
//        filetest();
//        fileDirTest();
//        randomaccessfileTest();
//        dataputStreamTest();
//        iotest();
//        inOrOutputStreamTest();
//        fileReaderOrWriterTest();
//        bufferedReaderOrWriter();
        serializableTest();


        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
    }


    //Serializable序列化测试
    private static void serializableTest(){
//        SerializableTest.serializableSaveTest("demo/hahapei.java");
        SerializableTest.serializableReadTest("demo/hahapei.java");
    }

    //bufferedReader or bufferedWriter
    private static void bufferedReaderOrWriter(){
        BufferedReaderOrWriter.bufferedReaderOrWriterTest("demo/copy.java");
    }

    //filereader  filewriter
    private static void fileReaderOrWriterTest(){
        FileReaderOrWriterTest.readOrWriterTest("src/main/main.java","demo/copy.java");
    }

    //InputStreamReader  or  OutputStreamWriter
    private static void inOrOutputStreamTest(){
        PutStream.inputStreamReaderTest("demo/copyfile.java");
    }

    //DataOutputStream测试
    private static void dataputStreamTest(){
//        DataputStreamTest.dataOutputStreamTest("demo/out.txt");
        DataputStreamTest.dataInputStreamTest("demo/out.txt");
    }

    //io流测试
    private static void iotest(){
//        IOUtils.printHex("demo/raf.dat");
//        IOUtils.printHexByByteArray("src/main/FileUtils.java");
//        IOUtils.copyFile("src/main/FileUtils.java","demo/coopyfile.java");
//        IOUtils.copyFileByBuffered("src/main/FileUtils.java","demo/coopyfile.java");
        IOUtils.printHexByByteArray("demo/a.dmg");
    }

    //访问文件内容
    private static void randomaccessfileTest(){
        try {
            RandomAccessFileTest.randomAccessFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //文件子目录和子文件列表
    private static void fileDirTest(){
        try {
            FileUtils.listDirectory(new File("/users/meizu/desktop/java/javaIODemo"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //文件常用方法
    private static void filetest(){
        File file = new File("/users/meizu/desktop/java/javaIODemo/hah");
        System.out.println("file.exists() = " + file.exists());
        if(!file.exists()){
            file.mkdir();
        }
//        else{
//            file.delete();
//        }
        System.out.println("file.exists() = " + file.exists());

        File file1 = new File("/users/meizu/desktop/java/javaIODemo/hah","test1.txt");
        try {
            file1.createNewFile();
            System.out.println("file1 = " + file1);//打印出绝对路径
            System.out.println("file1.getAbsolutePath() = " + file1.getAbsolutePath());//取得绝对路径
            System.out.println("file1.getPath() = " + file1.getPath());//取得地址
            System.out.println("file1.getParent() = " + file1.getParent());//取得父地址
            System.out.println("file1.getName() = " + file1.getName());//取得名称
            System.out.println("file.getName() = " + file.getName());//取得名称
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //编码测试
    private static void codeFormat(){
        try {
        String str = "魅族abc";
        byte[] bytes = str.getBytes();//转换成字节序列，使用的是项目默认的编码

        for (byte b:bytes) {
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        System.out.println();
            byte[] byte1 = str.getBytes("gbk");//设置编码格式
            //gbk编码 中文占用2个字节，英文占用1个字节
            for (byte b:byte1) {
                System.out.print(Integer.toHexString(b & 0xff)+" ");
            }

        System.out.println();
            byte[] byte2 = str.getBytes("utf-8");//设置编码格式
            //utf-8编码 中文占用3个字节，英文占用1个字节
            for (byte b:byte2) {
                System.out.print(Integer.toHexString(b & 0xff)+" ");
            }

        System.out.println();

            byte[] byte3 = str.getBytes("utf-16be");//设置编码格式
            //utf-16be编码 中文占用2个字节，英文占用1个字节
            for (byte b:byte3) {
                System.out.print(Integer.toHexString(b & 0xff)+" ");
            }



            /**
             * 当字节的序列是某种编码时，这个时候想把字节序列转变为字符串，也需要指定编码格式来进行转换，否则会出现乱码
             * */
            String str1 = new String(byte1);
            System.out.println("str1 = " + str1);
            String str2 = new String(byte3,"utf-16be");
            System.out.println("str2 = " + str2);

            /**
             * 文本文件本身就是字节序列
             * 可以是任意编码的字节序列
             * 如果我们在中文机器上直接创建文本文件，那么该文本文件只能识别ansi编码
             * */

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
