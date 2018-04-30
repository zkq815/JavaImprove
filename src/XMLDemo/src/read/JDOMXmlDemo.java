package XMLDemo.src.read;

import com.zkq.BookBean;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zkq on 2017/2/27.
 */
public class JDOMXmlDemo {

    private ArrayList<BookBean> bookListObject = null;
    private BookBean bookObject = null;

    public void jdomxmlTest(String xmlFilePath){
        bookListObject = new ArrayList<BookBean>();
        try {
            bookObject = new BookBean();
            //创建一个输入流，将xml文件加载到输入流中
//            InputStream inputStream = new FileInputStream(xmlFilePath);
            InputStream inputStream = new FileInputStream("src/main/res/bookstore.xml");
            //包装输入流，指定编码格式，防止乱码
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            //创建一个SAXBuild对象，加载文件
            SAXBuilder saxBuilder = new SAXBuilder();
            //通过saxbuild的build方法，将输入流加载到saxbuild中
            Document document = saxBuilder.build(inputStreamReader);
            //通过document对象获取xml文件的根节点
            Element rootElement = document.getRootElement();
            //根据节点下的字节点list集合
            List<Element> bookList = rootElement.getChildren();
            //继续解析
            for (Element book:bookList) {
                System.out.println("开始解析第"+(bookList.indexOf(book)+1)+"本书");
                List<Attribute> attributeList = book.getAttributes();
                //知道book节点下的属性名称以及属性值
                String attributeName = book.getAttributeValue("id");
//                bookObject.setId(attributeName);
                //遍历attrlist（在不知道book节点下的属性名称以及属性值）
                for (Attribute attribute:attributeList) {
                    //获取属性名
                    String attrName = attribute.getName();
                    //获取属性值
                    String attrValue = attribute.getValue();
                    if("id".equals(attrName)){
                        bookObject.setId(attrValue);
                    }
                    System.out.println("属性名=="+attrName+"-----属性值=="+attrValue);
                }

                //遍历attrlist（在不知道book节点下的属性名称以及属性值）
                List<Element> bookChildren = book.getChildren();

                for (Element child:bookChildren) {
                    //获取属性名
                    String attrName = child.getName();
                    //获取属性值
                    String attrValue = child.getValue();

                    System.out.println("字节点  属性名=="+attrName+"-----属性值=="+attrValue);

                    if("name".equals(attrName)){
                        bookObject.setName(attrValue);
                    }else if("author".equals(attrName)){
                        bookObject.setAuthor(attrValue);
                    }else if("price".equals(attrName)){
                        bookObject.setPrice(attrValue);
                    }else if("year".equals(attrName)){
                        bookObject.setYear(attrValue);
                    }
                }
                bookListObject.add(bookObject);
                //对book节点的字节点的节点名以及节点值的遍历
                System.out.println("结束解析第"+(bookList.indexOf(book)+1)+"本书");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BookBean> getBookListObject() {
        return bookListObject;
    }

    public void setBookListObject(ArrayList<BookBean> bookListObject) {
        this.bookListObject = bookListObject;
    }
}
