package DesignPattern.FactoryPattern;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zkq on 2017/2/1.
 */
public class ProperitesReader {

    public Map<String,String> getProperties(){
        Properties properties = new Properties();
        Map<String,String> map = new HashMap<String,String>();
        try {
            InputStream in = getClass().getResourceAsStream("tyep.properties");
            properties.load(in);
            Enumeration enumeration = properties.propertyNames();
            while(enumeration.hasMoreElements()){
                String key = (String) enumeration.nextElement();
                String property = properties.getProperty(key);
                map.put(key,property);
                System.out.println(key+"~~~~~~~"+property);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
