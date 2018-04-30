package Base64Demo;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zkq on 2017/2/24.
 */
public class HmacMD5Test {

    public void jdkHmacMD5Test(String string){
        try {
            System.out.println("--------jdk HmacMD5 -------------");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");//初始化KeyGenerator
            SecretKey secretKey = keyGenerator.generateKey();//产生密钥
            byte[] keyBytes = secretKey.getEncoded();//获得密钥

            SecretKey restoreKey = new SecretKeySpec(keyBytes,"HmacMD5");//还原密钥
            Mac mac = Mac.getInstance(restoreKey.getAlgorithm());//实例化mac
            mac.init(restoreKey);//初始化mac
            byte[] bytes = mac.doFinal(string.getBytes());//执行摘要
            System.out.println("jdk hmacmd5 =="+ Hex.encodeHexString(bytes));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public void bcHmacMD5Test(String string){
        System.out.println("--------bc HmacMD5 -------------");
        HMac hMac = new HMac(new MD5Digest());
        hMac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));
        hMac.update(string.getBytes(),0,string.getBytes().length);

        byte[] bytes = new byte[hMac.getMacSize()];
        hMac.doFinal(bytes,0);
        System.out.println("bc HmacMD5 = " + org.bouncycastle.util.encoders.Hex.toHexString(bytes));

    }
}
