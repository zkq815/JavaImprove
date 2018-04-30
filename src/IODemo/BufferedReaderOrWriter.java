package IODemo;

import java.io.*;

/**
 * Created by zkq on 2017/2/16.
 */
public class BufferedReaderOrWriter {

    public static void bufferedReaderOrWriterTest(String filePath){

        //对文件进行读写操作，一次读一行
        BufferedReader br = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("demo/hah.java")));
            pw = new PrintWriter("demo/haha.java");
            String line = "";
            while ((line = br.readLine())!=null){
//                System.out.println(line);
                bw.write(line);
                bw.newLine();//换行
//                bw.write("\n");//换行
                bw.flush();

//                pw.write(line);
//                pw.write("\n");
                pw.println(line);//写入，带换行
                pw.flush();

            }


        }catch (IOException e){

        }finally {
            try {
                br.close();
                bw.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
