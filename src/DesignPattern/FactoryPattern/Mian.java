package DesignPattern.FactoryPattern;

/**
 * Created by zkq on 2017/2/1.
 */
public class Mian {
    public static void main(String[] args){
        HairFactory hairFactory = new HairFactory();
        HairInterface hairInterface = hairFactory.getHairByKeyToClass("right");
        hairInterface.draw();
    }
}
