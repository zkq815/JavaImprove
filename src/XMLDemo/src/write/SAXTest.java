package XMLDemo.src.write;

import com.zkq.BookBean;
import com.zkq.SAXParserHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zkq on 2017/3/9.
 */
public class SAXTest {

    private ArrayList<BookBean> saxxmlTest(String xmlFilePath){
        ArrayList<BookBean> bookList = null;
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXParserHandler saxParserHandler = new SAXParserHandler();
            saxParser.parse(xmlFilePath,saxParserHandler);
            bookList = saxParserHandler.getBookList();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void createXML(String oldXMLFilePath,String newXMLName){
        ArrayList<BookBean> bookList = saxxmlTest(oldXMLFilePath);
        System.out.println(bookList.size());
        //生成xml
        try {
            //1、创建一个TransformerFactory类对象
            SAXTransformerFactory saxtff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            //2、通过SAXTransformerFactory对象创建一个TransformerHandler对象
            TransformerHandler handler = saxtff.newTransformerHandler();
            //3、通过TransformerHandler对象创建一个Transformer对象
            Transformer transformer = handler.getTransformer();
            //4、通过transformer对象生成的xml文件进行设置
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");//是否换行
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");//设置编码格式
            //5、创建一个file对象
            File file = new File(newXMLName);
            if(!file.exists()){
                file.getParentFile().mkdir();
                file.createNewFile();
            }
            //6、创建result对象，并与file文件相关联，然后将其与handler关联
            Result result = new StreamResult(new FileOutputStream(newXMLName));
            handler.setResult(result);
            //7、利用handler对象进行xml文件内容的编写
            handler.startDocument();//打开document
            AttributesImpl attr = new AttributesImpl();
            handler.startElement("","","bookstore",attr);
            for (BookBean bookBean :bookList) {
                attr.clear();
                attr.addAttribute("","","id","",bookBean.getId());
                handler.startElement("","","book",attr);
//                attr.clear();
//                attr.addAttribute("","","name","","瓦尔登湖");
//                handler.startElement("","","name",attr);
//                handler.endElement("","","name");
//                handlerDoSomething(attr,handler,"name","瓦尔登湖");
//                handlerDoSomething(attr,handler,"age","243");
//                handlerDoSomething(attr,handler,"year","2009");
//                handlerDoSomething(attr,handler,"price","29.8");
                if(bookBean.getName()!=null &&!bookBean.getName().trim().equals("")){
                    handlerDoSomething(attr,handler,"name",bookBean.getName());
                }

                if(bookBean.getAuthor()!=null &&!bookBean.getName().trim().equals("")){
                    handlerDoSomething(attr,handler,"author",bookBean.getAuthor());
                }

                if(bookBean.getLanguage()!=null &&!bookBean.getName().trim().equals("")){
                    handlerDoSomething(attr,handler,"language",bookBean.getLanguage());
                }

                if(bookBean.getPrice()!=null &&!bookBean.getName().trim().equals("")){
                    handlerDoSomething(attr,handler,"price",bookBean.getPrice());
                }

                if(bookBean.getYear()!=null &&!bookBean.getName().trim().equals("")){
                    handlerDoSomething(attr,handler,"year",bookBean.getYear());
                }
                handler.endElement("","","book");
            }
            handler.endElement("","","bookstore");
            handler.endDocument();//关闭document
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handlerDoSomething(AttributesImpl attr,TransformerHandler handler,String elementName,String elementValue){
        try {
            attr.clear();
//            attr.addAttribute("","",elementName,"","");
            handler.startElement("","",elementName,attr);
            handler.characters(elementValue.toCharArray(),0,elementValue.length());
            handler.endElement("","",elementName);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
