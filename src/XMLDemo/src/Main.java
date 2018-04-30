package XMLDemo.src;

import com.zkq.read.Dom4JTest;
import com.zkq.read.JDOMXmlDemo;
import com.zkq.read.JavaXMLTest;
import com.zkq.read.SAXXMLDemo;
import com.zkq.write.DOM4JWriteXMLTest;
import com.zkq.write.DOMTest;
import com.zkq.write.JDOMWriteTest;
import com.zkq.write.SAXTest;

/**
 * Created by zkq on 2017/2/24.
 */
public class Main {
    public static void main(String[] args) {
        //读取文件操作
//        javaXmlTest();
//        saxXmlTest();
//        jdomXmlTest();
//        dom4jTest();
        //写入文件操作
//        domWriteTest();
//        saxWriteTest();
//        dom4jWriteTest();
        jdomWriteTest();
    }

    //读取文件操作
    private static void dom4jTest(){
        Dom4JTest dom4JTest = new Dom4JTest();
        dom4JTest.dom4jMethod("bookstore.xml");
    }
    //读取文件操作
    private static void jdomXmlTest(){
        JDOMXmlDemo jdomXmlDemo = new JDOMXmlDemo();
        jdomXmlDemo.jdomxmlTest("bookstore.xml");
        for (BookBean book :jdomXmlDemo.getBookListObject()) {
            System.out.println(book.getId());
            System.out.println(book.getName());
            System.out.println(book.getAuthor());
            System.out.println(book.getYear());
            System.out.println(book.getLanguage());
            System.out.println(book.getPrice());
            System.out.println("------------end----------------");
        }
    }
    //读取文件操作
    private static void javaXmlTest(){
        JavaXMLTest xmlTest = new JavaXMLTest();
        xmlTest.readXMLContent("bookstore.xml");
        xmlTest.readXMLContentWithNodeName("bookstore.xml");
    }
    //读取文件操作
    private static void saxXmlTest(){
        SAXXMLDemo saxxmlDemo = new SAXXMLDemo();
        saxxmlDemo.saxxmlTest("bookstore.xml");
    }

    //文件写入操作
    private static void domWriteTest(){
        DOMTest domTest = new DOMTest();
        domTest.createXML("src/main/res/bookdom.xml");
    }

    private static void saxWriteTest(){
        SAXTest saxTest = new SAXTest();
        saxTest.createXML("src/main/res/bookstore.xml","src/main/res/booksax.xml");
    }

    private static void dom4jWriteTest(){
        DOM4JWriteXMLTest dom4JWriteXMLTest = new DOM4JWriteXMLTest();
        dom4JWriteXMLTest.dom4jCreateXML("src/main/res/bookstore.xml","src/main/res/bookdom4j.xml");
    }

    private static void jdomWriteTest(){
        JDOMWriteTest jdomWriteTest = new JDOMWriteTest();
        jdomWriteTest.jDOMCreateXML("src/main/res/bookjdom.xml");
    }
}
