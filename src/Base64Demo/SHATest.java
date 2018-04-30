package Base64Demo;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * Created by zkq on 2017/2/23.
 */
public class SHATest {

    public void jdkSHA1Test(String string){
        System.out.println("--------jdk sha1-------------");
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(string.getBytes());
            byte[] bytes = md.digest();
            String encode = Hex.encodeHexString(bytes);
            System.out.println("jdk sha1 = " + encode);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void bcSHA1Test(String string){
        System.out.println("--------bc sha1-------------");
        Digest digest = new SHA1Digest();
        byte[] bytes = string.getBytes();
        digest.update(bytes,0,bytes.length);
        byte[] sha1Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha1Bytes,0);
        System.out.println("bc sha1 = " + org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
    }

    public void bcSHA224Test(String string){
        System.out.println("--------bc sha224 方法一  -------------");
        Digest digest = new SHA224Digest();
        byte[] bytes = string.getBytes();
        digest.update(bytes,0,bytes.length);
        byte[] bytes1 = new byte[digest.getDigestSize()];
        digest.doFinal(bytes1,0);
        System.out.println("bc sha224 = " + org.bouncycastle.util.encoders.Hex.toHexString(bytes1));
    }

    public void bcSHA224Test1(String string){
        System.out.println("--------bc sha224 方法二  -------------");
        Security.addProvider(new BouncyCastleProvider());
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-224");
            md.update(string.getBytes());
            byte[] bytes = md.digest();
            System.out.println("bc sha224 = " + org.bouncycastle.util.encoders.Hex.toHexString(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void ccSHA1Test(String string){
        System.out.println("--------cc sha1 方法1  -------------");
        System.out.println("cc sha1_1 = "+DigestUtils.sha1Hex(string));
        System.out.println("cc sha1_1 = "+DigestUtils.sha1Hex(string.getBytes()));

    }
}
