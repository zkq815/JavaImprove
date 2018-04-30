package Base64Demo;

/**
 * Created by zkq on 2017/2/22.
 */
public class Base64Test {
    private static String src = "zkq just persist, you will succeed.";

    public static void main(String[] args) {
//        base64MethodTest();
//        md5Test();
//        shaTest();
        hmacMD5Test();
    }

    private static void hmacMD5Test(){
        HmacMD5Test hmacMD5Test = new HmacMD5Test();
        hmacMD5Test.jdkHmacMD5Test(src);
        hmacMD5Test.bcHmacMD5Test(src);
    }

    //sha
    private static void shaTest(){
        SHATest shaTest = new SHATest();
        shaTest.jdkSHA1Test(src);
        shaTest.bcSHA1Test(src);
        shaTest.bcSHA224Test(src);
        shaTest.bcSHA224Test1(src);
        shaTest.ccSHA1Test(src);
    }

    //MD5
    private static void md5Test(){
        MD5Test md5Test = new MD5Test();
        md5Test.jdkMD5(src);
        md5Test.jdkMD2(src);
        md5Test.bcMD4(src);
        md5Test.bcMD5(src);
        md5Test.ccMD2(src);
        md5Test.ccMD5(src);
    }

    //Base64
    private static void base64MethodTest(){
        Base64Method base64Method = new Base64Method();
        base64Method.jdkBase64(src);
        base64Method.bcBase64(src);
        base64Method.ccBase64(src);
    }
}
