package Base64Demo;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.xml.soap.SOAPPart;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * Created by zkq on 2017/2/22.
 */
public class MD5Test {

    public void jdkMD5(String str){
        System.out.println("---------jdk  MD5-----------");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(str.getBytes());
            String md5Str = Hex.encodeHexString(md5Bytes);
            System.out.println("md5Str = " + md5Str);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void jdkMD2(String str){
        System.out.println("---------jdk  MD2-----------");
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] md2Bytes = md.digest(str.getBytes());
            String md2Str = Hex.encodeHexString(md2Bytes);
            System.out.println("md2Str = " + md2Str);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void bcMD4(String str){
        System.out.println("---------BC  MD4 方法一 -----------");
        try {
            Digest digest = new MD4Digest();
            digest.update(str.getBytes(),0,str.getBytes().length);
            byte[] md4Bytes = new byte[digest.getDigestSize()];
            digest.doFinal(md4Bytes,0);
            String md4Str = org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes);
            System.out.println("md4StrMethod1 = " + md4Str);
            System.out.println("---------BC  MD4 方法二-----------");

            Security.addProvider(new BouncyCastleProvider());
            MessageDigest md = MessageDigest.getInstance("MD4");
            byte[] md4Bytes2 = md.digest(str.getBytes());
            String md4Method2 = org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes2);
            System.out.println("md4StrMethod2 = " + md4Method2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bcMD5(String str){
        System.out.println("---------BC  MD5-----------");
        try {
            Digest digest = new MD5Digest();
            digest.update(str.getBytes(),0,str.getBytes().length);
            byte[] md5Bytes = new byte[digest.getDigestSize()];
            digest.doFinal(md5Bytes,0);
            String md5Str = org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes);
            System.out.println("md5Str = " + md5Str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ccMD2(String str){
        System.out.println("---------CC  MD2-----------");
        String md2Str = DigestUtils.md2Hex(str.getBytes());
        System.out.println("md2Str = " + md2Str);
    }

    public void ccMD5(String str){
        System.out.println("---------CC  MD5-----------");
        String md5Str = DigestUtils.md5Hex(str.getBytes());
        System.out.println("md5Str = " + md5Str);
    }
}
