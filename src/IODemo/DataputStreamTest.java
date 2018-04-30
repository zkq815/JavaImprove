package IODemo;

import java.io.*;

/**
 * Created by zkq on 2017/2/16.
 */
public class DataputStreamTest {

    public static void dataOutputStreamTest(String filePath){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(filePath));
            dos.writeInt(10);
            dos.writeInt(-10);
            dos.writeLong(10L);
            dos.writeDouble(10.6);
            //采用utf-8编码格式
            dos.writeUTF("中国");
            //采用utf-16be编码格式
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dataInputStreamTest(String filePath){
//        IOUtils.printHex(filePath);
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(filePath));
            System.out.println("dis = " + dis.readInt());
            System.out.println("dis = " + dis.readInt());
            System.out.println("dis = " + dis.readLong());
            System.out.println("dis = " + dis.readUTF());
        }catch(IOException e){

        }finally {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
