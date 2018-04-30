package Base64Demo;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by zkq on 2017/2/22.
 */
public class Base64Method {

    public void jdkBase64(String src){
        System.out.println("----------jdk base64----------------");
        //jdk base64加密
        BASE64Encoder encoder = new BASE64Encoder();
        String temp = encoder.encode(src.getBytes());
        System.out.println("encode = "+temp);

        //jdk base64 解密
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            String result = new String(decoder.decodeBuffer(temp));
            System.out.println("decode = "+result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bcBase64(String src){
        System.out.println("----------bc base64----------------");
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("encode = " + new String(encode));

        byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);
        System.out.println("decode = " + new String(decode));
    }

    public void ccBase64(String src){
        System.out.println("----------cc base64----------------");
        byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
        System.out.println("encode = " + new String(encodeBytes));

        byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
        System.out.println("decode = " + new String(decodeBytes));
    }

}
