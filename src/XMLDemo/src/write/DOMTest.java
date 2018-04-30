package XMLDemo.src.write;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by zkq on 2017/3/9.
 */
public class DOMTest {

    private DocumentBuilder getDocumentBuilder(){
        DocumentBuilder db = null;
        try {
            //创建一个DocumentBuilderFactory对象
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //创建DocumentBuilder对象
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return db;
    }

    public void createXML(String xmlFileName){
        DocumentBuilder documentBuilder = getDocumentBuilder();
        Document document = documentBuilder.newDocument();
        document.setXmlStandalone(true);//xml文件中的standalone值为yes且不显示
        //创建bookstore节点
        Element bookstore = document.createElement("bookstore");
        for (int i = 0; i < 2; i++) {
            //创建book节点
            Element book = document.createElement("book");
            book.setAttribute("id",""+(i+1));

            Element name = document.createElement("name");
            name.setTextContent("瓦尔登湖");
            Element age = document.createElement("age");
            age.setTextContent("88");
            Element price = document.createElement("price");
            price.setTextContent("28.9");
            Element year = document.createElement("year");
            year.setTextContent("2009");
            book.appendChild(name);
            book.appendChild(age);
            book.appendChild(price);
            book.appendChild(year);
            //向bookstore根节点中添加book子节点
            bookstore.appendChild(book);

        }
        //将bookstore节点（已经包含了book节点）添加到dom树中
        document.appendChild(bookstore);

        try {
            //创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT,"yes");//设置属性换行
            tf.transform(new DOMSource(document),new StreamResult(new File(xmlFileName)));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
