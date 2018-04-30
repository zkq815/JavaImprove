package XMLDemo.src.read;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by zkq on 2017/2/24.
 */
public class JavaXMLTest {

    public void readXMLContent(String xmlFilePath){
        System.out.println("----------NamedNodeMap--------------");
        try {
            //创建DocumentBuilderFactory对象
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            //创建DocumentBuilder对象
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //通过DocumentBuilder对象的parser方法加载xml文件到当前项目下
            Document document = documentBuilder.parse(xmlFilePath);
            //获取所有目标节点的集合
            NodeList nodeList = document.getElementsByTagName("book");
            System.out.println("共有："+ nodeList.getLength()+"个元素");
            //获取节点集合的长度
            int elementsLength = nodeList.getLength();

            for (int i = 0; i < elementsLength; i++) {
                //获取单个节点
                Node node = nodeList.item(i);
                //获取节点的属性集合
                NamedNodeMap namedNodeMap = node.getAttributes();
                //获取节点属性集合的长度
                int mapLength = namedNodeMap.getLength();
                for (int j = 0; j < mapLength; j++) {
                    //获取节点属性
                    Node itemNode = namedNodeMap.item(j);
                    //获取子节点属性的名称和值
                    System.out.println("itemNode Name = " + itemNode.getNodeName()+"---Value = " + itemNode.getNodeValue());
                }

                //获取节点的子节点
                NodeList childNodeList = node.getChildNodes();
                int childlength = childNodeList.getLength();
                System.out.println("第 " +(i+1)+" 个元素有"+childlength+" 个子节点");

                for (int j = 0; j < childlength; j++) {
                    if(childNodeList.item(j).getNodeType() == Node.ELEMENT_NODE){
                        Node childNode = childNodeList.item(j);
                        //获取第一个子节点的内容childNode.getFirstChild().getNodeValue()
                        System.out.println("childNode Name = " + childNode.getNodeName()+"---Value = " + childNode.getFirstChild().getNodeValue());
                        //获取多个子节点中的文字内容childNode.getTextContent()  多个子节点的节点值一起取出
                        System.out.println("childNode Name = " + childNode.getNodeName()+"---Value = " + childNode.getTextContent());
                    }
                }

            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readXMLContentWithNodeName(String xmlFilePath){
        try {
            System.out.println("----------Elements---------------");
            //创建DocumentBuilderFactory对象
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            //创建DocumentBuilder对象
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //通过DocumentBuilder对象的parser方法加载xml文件到当前项目下
            Document document = documentBuilder.parse(xmlFilePath);
            //获取所有目标节点的集合
            NodeList nodeList = document.getElementsByTagName("book");
            //获取节点集合长度
            int nodeLength = nodeList.getLength();
            for (int i = 0; i < nodeLength; i++) {
                //获取单个节点元素
                Element element = (Element) nodeList.item(i);
                System.out.println("id 属性为 = " + element.getAttribute("id"));
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
