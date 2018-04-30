package XMLDemo.src.write;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zkq on 2017/3/10.
 */
public class DOM4JWriteXMLTest {

    //理解什么是RSS
    private void praseXML(String xmlFilePath) {
        //解析xml文件
        //创建SAXRead的对象reader
        SAXReader saxReader = new SAXReader();
        //通过SAXReader对象的read方法，加载xml文件,并获取Document对象
        try {
            Document document = saxReader.read(new File(xmlFilePath));
            //通过Document对象的getrootelement方法获取根节点
            Element elementBookStore = document.getRootElement();
            //通过Element对象的elementierator方法获取迭代器
            Iterator it = elementBookStore.elementIterator();
            //遍历迭代器，获取根节点中的信息(书籍)
            while (it.hasNext()) {
                Element book = (Element) it.next();
                //获取book的属性名以及属性值
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr : bookAttrs) {
                    System.out.println("属性名称==" + attr.getName() + "----属性值==" + attr.getValue());
                }
                Iterator itt = book.elementIterator();
                while (itt.hasNext()) {
                    Element bookChild = (Element) itt.next();
                    System.out.println("属性名称==" + bookChild.getName() + "----属性值==" + bookChild.getStringValue());
                }


            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void dom4jCreateXML(String oldXMLPath, String newXMLFilePath) {

        try {
            //1、创建document袖低昂，代表整个xml文档
            Document document = DocumentHelper.createDocument();
            //2、创建根节点rss
            Element rss = document.addElement("rss");
            //3、向rss根节点添加version属性
            rss.addAttribute("version", "2.0");
            //4、生成子节点以及节点内容
            Element channel = rss.addElement("channel");
            Element title = channel.addElement("title");
//            title.setText("国际新闻");
            title.setText("<![CDATA[啊哈哈哈哈哈哈]]>");
            //5、设置生成xml文件的格式
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();//设置漂亮格式
            outputFormat.setEncoding("UTF-8");//设置编码格式
            //6、生成xml文件
            File file = new File(newXMLFilePath);
            if (!file.exists()) {
                file.getParentFile().mkdir();
                file.createNewFile();
            }
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(file),outputFormat);
            //设置是否开启转义标签，默认是true，防止创建文件时将一些内容当做标签转义
            xmlWriter.setEscapeText(false);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
