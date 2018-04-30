package XMLDemo.src.write;

import com.sun.javaws.jnl.XMLFormat;
import com.zkq.read.JDOMXmlDemo;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.EscapeStrategy;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zkq on 2017/3/10.
 */
public class JDOMWriteTest {

    private void parseXML(String oldxmlPath){
        JDOMXmlDemo jdomXmlDemo = new JDOMXmlDemo();
        jdomXmlDemo.jdomxmlTest(oldxmlPath);
    }

    public void jDOMCreateXML(String newXMLPath){
        try {
            //1、生成一个根节点
            Element rss = new Element("rss");
            //2、为节点添加属性名和属性值
            rss.setAttribute("version","2.0");
            //3、生成一个document对象
            Document document = new Document(rss);
            //创建子节点
            Element channel = new Element("channel");
            Element title = new Element("title");
            title.setText("<![CDATA[啊哈哈哈哈哈哈]]>");
            Element title1 = new Element("title1");
            CDATA cdata = new CDATA("[CDATA[啊哈哈哈哈哈哈]]");
            title1.addContent(cdata);
            channel.addContent(title);
            channel.addContent(title1);
            rss.addContent(channel);
            //格式设置
            Format format = Format.getPrettyFormat();//设置为漂亮格式
            format.setEncoding("UTF-8");
            //4、创建XMLOutputter对象
            XMLOutputter xmlOutputter = new XMLOutputter(format);
            //5、利用outputter将document对象转换成为xml文件
            xmlOutputter.output(document,new FileOutputStream(new File(newXMLPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
