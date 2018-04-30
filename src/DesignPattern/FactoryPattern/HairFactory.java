package DesignPattern.FactoryPattern;

import java.util.Map;

/**
 * Created by zkq on 2017/2/1.
 */
public class HairFactory  {

    public HairInterface getHairByKey(String key){
        if("left".equals(key)){
            return new LeftHair();
        }else if("right".equals(key)){
            return new RightHair();
        }

        return null;
    }

    public HairInterface getHairByClass(String className){
        try {
            HairInterface hair = (HairInterface) Class.forName(className).newInstance();
            return hair;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HairInterface getHairByKeyToClass(String key){
        Map<String,String> map = new ProperitesReader().getProperties();

        try {
            HairInterface hair = (HairInterface) Class.forName(map.get(key)).newInstance();
            return hair;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
