package DesignPattern.TemplatePattern;

/**
 * Created by zkq on 2017/2/1.
 */
public class Cofe extends Muban {
    @Override
    protected void brew() {
        System.out.println("直接冲泡咖啡");
    }

    @Override
    protected void addThings() {
        System.out.println("添加牛奶和糖");
    }
}
