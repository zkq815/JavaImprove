package IODemo;

import java.io.*;

/**
 * Created by zkq on 2017/2/16.
 */
public class PutStream {

    public static void inputStreamReaderTest(String filePath){

        File baseFile = new File(filePath);
        if(!baseFile.exists()){
            throw new IllegalArgumentException("文件"+ baseFile +"不存在");
        }

        if(!baseFile.isFile()){
            throw new IllegalArgumentException("文件"+ baseFile +"不是文件");
        }

        FileInputStream in = null;
        InputStreamReader isr = null;
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        try{
            in = new FileInputStream(filePath);
            isr = new InputStreamReader(in);//默认项目编码，省略了编码模式,应该要写文件本身的编码格式
            out = new FileOutputStream("demo/copyfile.java");
            osw = new OutputStreamWriter(out,"UTF-8");
//            int c = 0;
//            while ((c=isr.read())!=-1){
//                System.out.print((char) c);
//            }

            char[] buffer = new char[8*1024];
            int b = 0;
            while((b=isr.read(buffer,0,buffer.length))!=-1){
//                System.out.print(buffer[b]);
                String s = new String(buffer,0,b);
                System.out.println(s);
                osw.write(buffer,0,b);
                osw.flush();
            }


        }catch (IOException e){

        }finally {
            try {
                in.close();
                isr.close();
                out.close();
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
