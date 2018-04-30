package XMLDemo.src.read;

import com.zkq.BookBean;
import com.zkq.SAXParserHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by zkq on 2017/2/27.
 */
public class SAXXMLDemo {
    public void saxxmlTest(String xmlFilePath){
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXParserHandler saxParserHandler = new SAXParserHandler();
            saxParser.parse(xmlFilePath,saxParserHandler);
            System.out.println("获取到的书籍有"+saxParserHandler.getBookList().size()+"本，内容如下");

            for (BookBean book: saxParserHandler.getBookList()) {
                System.out.println(book.getId());
                System.out.println(book.getName());
                System.out.println(book.getAuthor());
                System.out.println(book.getYear());
                System.out.println(book.getLanguage());
                System.out.println(book.getPrice());
                System.out.println("------------end----------------");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
