package XMLDemo.src;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by zkq on 2017/2/27.
 */
public class SAXParserHandler extends DefaultHandler {

    int index = 0;
    String value = null;
    BookBean book = null;
    private ArrayList<BookBean> bookList = new ArrayList<BookBean>();

    /**
     * 遍历xml的开始标签
     * 每一次解析到开始标签，都会调用这个方法
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);//调用父类的startelement方法
//        System.out.println("----------------已知book属性名称------------------");
        if(qName.equals("book")){
            index ++;
            book = new BookBean();
            //已知book元素下的属性名，根据属性名称获取属性值
            String value1 = attributes.getValue("id");
            System.out.println("book的 id 属性值为== "+ value1);
            book.setId(value1);

            //未知元素属性以及名称
//            System.out.println("----------------不知道知book属性名称------------------");
            int attrsLength = attributes.getLength();
            for (int i = 0; i < attrsLength; i++) {
                System.out.println("第"+(index)+"个属性名为=="+attributes.getQName(i)+"----值为=="+attributes.getValue(attributes.getQName(i)));
            }
        }else if(!qName.equals("book") && !qName.equals("bookstore")){
            System.out.println("节点名称是："+qName);
        }

    }

    /**
     * 遍历xml的结束标签
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);//调用父类的endElement方法
        if(qName.equals("book")){
            bookList.add(book);
            book = null;
            System.out.println("=============结束第"+index+"个属性的遍历==================");
        }else if("id".equals(qName)){
            book.setId(value);
        }else if("name".equals(qName)){
            book.setName(value);
        }else if("author".equals(qName)){
            book.setAuthor(value);
        }else if("price".equals(qName)){
            book.setPrice(value);
        }else if("year".equals(qName)){
            book.setYear(value);
        }
    }

    /**
     * 开始遍历
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    /**
     * 结束遍历
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        System.out.println("SAX解析结束");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch,start,length);
        if(!value.trim().equals(""))
            System.out.println("属性值为=="+value);
    }

    public ArrayList<BookBean> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<BookBean> bookList) {
        this.bookList = bookList;
    }
}
