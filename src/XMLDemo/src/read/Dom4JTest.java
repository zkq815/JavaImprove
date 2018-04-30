package XMLDemo.src.read;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;


/**
 * Created by zkq on 2017/3/8.
 */
public class Dom4JTest {


    public void dom4jMethod(String xmlFilePath){
        //解析xml文件
        //创建SAXRead的对象reader
        SAXReader saxReader = new SAXReader();
        //通过SAXReader对象的read方法，加载xml文件,并获取Document对象
        try {
            Document document =  saxReader.read(new File(xmlFilePath));
            //通过Document对象的getrootelement方法获取根节点
            Element elementBookStore = document.getRootElement();
            //通过Element对象的elementierator方法获取迭代器
            Iterator it = elementBookStore.elementIterator();
            //遍历迭代器，获取根节点中的信息(书籍)
            while (it.hasNext()){
                System.out.println("开始遍历一本书");
                Element book = (Element) it.next();
                //获取book的属性名以及属性值
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr: bookAttrs) {
                    System.out.println("属性名称=="+attr.getName()+"----属性值=="+attr.getValue());
                }
                Iterator itt = book.elementIterator();
                while(itt.hasNext()){
                    Element bookChild = (Element) itt.next();
                    System.out.println("属性名称=="+bookChild.getName()+"----属性值=="+bookChild.getStringValue());
                }

                System.out.println("结束遍历一本书");

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
